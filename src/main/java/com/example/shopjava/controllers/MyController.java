package com.example.shopjava.controllers;

import com.example.shopjava.configs.security.CustomUserDetailsService;
import com.example.shopjava.entities.*;
import com.example.shopjava.entities.contacts.Contact;
import com.example.shopjava.repos.Utils;
import com.example.shopjava.services.CareerService;
import com.example.shopjava.services.ContactService;
import com.example.shopjava.services.FaqService;
import com.example.shopjava.services.FilterProducts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MyController {

    @Autowired
    private FilterProducts filterProducts;

    @Autowired
    private CareerService careerService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private FaqService faqService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private Utils utils;

    private static final Logger log = LoggerFactory.getLogger("log");

    @GetMapping("/")
    public String getHomePage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        return "home";
    }

    @PostMapping(value = "/", params = "registration")
    public String registration(@RequestParam("email") String email,
                               @RequestParam("psw") String psw,
                               @RequestParam("psw-repeat") String pswRepeat,
                               HttpServletRequest request,
                               Model model
                               ){
        String result = userDetailsService.signUp(email, psw, pswRepeat, request);
        if(!result.isEmpty()){
            model.addAttribute("userExist", result);
            return "home";
        }
        return "home";
    }

    @PostMapping(value = "/", params = "login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("psw") String psw,
                        HttpServletRequest request,
                        Model model
    ){
        log.info(email);
        log.info(psw);
        String res = userDetailsService.signIn(email, psw, request);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        log.info(""+securityContext.getAuthentication().getName());
        log.info(res);

        model.addAttribute("isAuthenticated", securityContext.getAuthentication().isAuthenticated());
        return "home";
    }

    @PostMapping(value = "/", params = "logout")
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "home";
    }

    @GetMapping("/searching")
    public String filtersPage(Model model, @RequestParam("search") String searchKey, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        List<? extends Product> products = filterProducts.searchProducts(searchKey);
        model.addAttribute("products", products);
        model.addAttribute("searchKey", searchKey);

        model.addAttribute("seacrhBool", true);
        return "filters";
    }

//    @PostMapping("/searching")
//    public String getFilters(Model model, @RequestParam("search") String searchKey){
//        List<? extends Product> products = filterProducts.searchProducts(searchKey);
//
//        model.addAttribute("products", products);
//        model.addAttribute("seacrhBool", true);
//        return "filters";
//    }

    @GetMapping("/phones")
    public String phoneFilters(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        List<Phone> phones = filterProducts.getAllPhones();
        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        LinkedHashSet<String> filters = new LinkedHashSet<>();
        int max = (int) Math.floor(utils.max(phones).getPrice());


        model.addAttribute("category", "Phones");
        model.addAttribute("filters", phoneFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        model.addAttribute("products", phones);
        model.addAttribute("minValue", 0);
        model.addAttribute("maxValue", max);
        model.addAttribute("max", max);
        return "filters";
    }

    @PostMapping("/phones")
    public String phoneFiltersPost(Model model, Authentication authentication,
                                   @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                   @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                   @RequestParam("sort") String sortType){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        List<Phone> phones = filterProducts.phones(filters, phoneFilters, minValue, maxValue);
        phones = filterProducts.sort(phones, sortType);

        model.addAttribute("category", "Phones");
        model.addAttribute("filters", phoneFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        model.addAttribute("products", phones);
        model.addAttribute("minValue", minValue);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.max(filterProducts.getAllPhones()).getPrice()));
        model.addAttribute("sortType", sortType);
        return "filters";
    }

    @GetMapping("/laptops")
    public String laptopFilters(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        List<Laptop> laptops = filterProducts.getAllLaptops();
        Map<String, List<String>> laptopFilters = filterProducts.getLaptopCharacteristics();
        Set<String> keys = laptopFilters.keySet();
        LinkedHashSet<String> filters = new LinkedHashSet<>();
        int max = (int) Math.floor(utils.maxLaptop(laptops).getPrice());


        model.addAttribute("category", "Laptops");
        model.addAttribute("filters", laptopFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        model.addAttribute("products", laptops);
        model.addAttribute("minValue", 0);
        model.addAttribute("maxValue", max);
        model.addAttribute("max", max);
        return "filters";
    }

    @PostMapping("/laptops")
    public String laptopFiltersPost(Model model, Authentication authentication,
                                   @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                   @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                   @RequestParam("sort") String sortType){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        Map<String, List<String>> laptopFilters = filterProducts.getLaptopCharacteristics();
        Set<String> keys = laptopFilters.keySet();
        List<Laptop> laptops = filterProducts.laptops(filters, laptopFilters, minValue, maxValue);
//        laptops = filterProducts.sort(phones, sortType);

        model.addAttribute("category", "Laptops");
        model.addAttribute("filters", laptopFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        model.addAttribute("products", laptops);
        model.addAttribute("minValue", minValue);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.maxLaptop(filterProducts.getAllLaptops()).getPrice()));
        model.addAttribute("sortType", sortType);
        return "filters";
    }

    @GetMapping("/product/{id}")
    public String getDescription(Model model, Authentication authentication,
                                 @PathVariable("id") Long id){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
//        Phone phone = filterProducts.getPhoneByName(name);
        Phone phone = filterProducts.getPhoneById(id);
        log.info(phone.getName());
        model.addAttribute("product", phone);
        return "description";
    }

    @GetMapping("/watches")
    public String watchesFilters(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        List<Watch> watches = filterProducts.getAllWatches();
        Map<String, List<String>> watchFilters = filterProducts.getWatchCharacteristics();
        Set<String> keys = watchFilters.keySet();
        LinkedHashSet<String> filters = new LinkedHashSet<>();
        int max = (int) Math.floor(utils.maxWatch(watches).getPrice());


        model.addAttribute("category", "Watches");
        model.addAttribute("filters", watchFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        model.addAttribute("products", watches);
        model.addAttribute("minValue", 0);
        model.addAttribute("maxValue", max);
        model.addAttribute("max", max);
        return "filters";
    }

    @PostMapping("/watches")
    public String watchesFiltersPost(Model model, Authentication authentication,
                                    @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                    @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                    @RequestParam("sort") String sortType){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        Map<String, List<String>> watchFilters = filterProducts.getWatchCharacteristics();
        Set<String> keys = watchFilters.keySet();
        List<Watch> watches = filterProducts.watches(filters, watchFilters, minValue, maxValue);
//        laptops = filterProducts.sort(phones, sortType);

        model.addAttribute("category", "Watches");
        model.addAttribute("filters", watchFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        model.addAttribute("products", watches);
        model.addAttribute("minValue", minValue);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.maxWatch(filterProducts.getAllWatches()).getPrice()));
        model.addAttribute("sortType", sortType);
        return "filters";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        return "about";
    }

    @PostMapping("/about")
    public String filledCareer(Model model, Authentication authentication,
                               @RequestParam("fname") String fname,
                               @RequestParam("lname") String lname,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone,
                               @RequestParam("pos") String pos,
                               @RequestParam("link") String link) {
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        Career career = new Career(fname, lname, email, phone, pos, link);
        String result = careerService.addCareerUser(career);
        model.addAttribute("result", result);
        return "about";
    }

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        return "checkout";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        return "contact";
    }

    @PostMapping(value = "/contact", params = "form")
    public String filledContactForm(Model model, Authentication authentication,
                                    @RequestParam("fname") String fname,
                                    @RequestParam("lname") String lname,
                                    @RequestParam("email") String email,
                                    @RequestParam("subject") String subject,
                                    @RequestParam("message") String message
                                    ){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        Contact contact = new Contact(fname, lname, email);
        String result = contactService.addContactMessage(contact, subject, message);
        model.addAttribute("result", result);
        return "contact";
    }

    @PostMapping(value = "/contact", params = "subs")
    public String filledEmail(Model model, Authentication authentication,
                              @RequestParam("email") String email){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        String result = contactService.subs(email);
        model.addAttribute("result", result);
        return "contact";
    }

    @GetMapping("/description")
    public String getDescriptionPage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        return "description";
    }

    @GetMapping("/help")
    public String getHelpPage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        return "help";
    }

    @GetMapping("/success")
    public String getSuccessPage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        return "success";
    }
}
