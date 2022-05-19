package com.example.shopjava.controllers;

import com.example.shopjava.configs.security.CustomUserDetailsService;
import com.example.shopjava.entities.*;
import com.example.shopjava.entities.admin.AdminHome;
import com.example.shopjava.entities.contacts.Contact;
import com.example.shopjava.repos.UserRepository;
import com.example.shopjava.repos.Utils;
import com.example.shopjava.services.*;
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
    private FavoriteService favoriteService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private Utils utils;

    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/")
    public String getHomePage(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);

        List<AdminHome> banners = adminService.getBannerData();

        model.addAttribute("link1", banners.get(0).getLink());
        String[] banner1Text = banners.get(0).getText().split("#");
        model.addAttribute("banner11", banner1Text[0]);
        model.addAttribute("banner12", banner1Text[1]);
        model.addAttribute("banner13", banner1Text[2]);

        model.addAttribute("link2", banners.get(1).getLink());
        String[] banner2Text = banners.get(1).getText().split("#");
        model.addAttribute("banner21", banner2Text[0]);
        model.addAttribute("banner22", banner2Text[1]);
        model.addAttribute("banner23", banner2Text[2]);

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
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Favorite favorite = favoriteService.getUserProducts(userDetailsService.getUserByEmail(name).getId());
        model.addAttribute("favoriteProducts", favorite.getFavoriteProducts());
        model.addAttribute("favoriteSize", favorite.getFavoriteProducts().size());
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

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Favorite favorite = favoriteService.getUserProducts(userDetailsService.getUserByEmail(name).getId());
        model.addAttribute("favoriteProducts", favorite.getFavoriteProducts());
        model.addAttribute("favoriteSize", favorite.getFavoriteProducts().size());
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
        model = filterPostModel(model, "Phones", phoneFilters, keys, filters, minValue, maxValue, sortType, authentication);
//        model.addAttribute("category", "Phones");
//        model.addAttribute("filters", phoneFilters);
//        model.addAttribute("filtersKeys", keys);
//        model.addAttribute("filterName",filters);
        model.addAttribute("products", phones);
//        model.addAttribute("minValue", minValue);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.max(filterProducts.getAllPhones()).getPrice()));
//        model.addAttribute("sortType", sortType);
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
        model = filterPostModel(model, "Laptops", laptopFilters, keys, filters, minValue, maxValue, sortType, authentication);
//        laptops = filterProducts.sort(phones, sortType);

//        model.addAttribute("category", "Laptops");
//        model.addAttribute("filters", laptopFilters);
//        model.addAttribute("filtersKeys", keys);
//        model.addAttribute("filterName",filters);
        model.addAttribute("products", laptops);
//        model.addAttribute("minValue", minValue);
//        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.maxLaptop(filterProducts.getAllLaptops()).getPrice()));
//        model.addAttribute("sortType", sortType);
        return "filters";
    }

    @GetMapping("/product/{id}")
    public String getDescription(Model model, Authentication authentication,
                                 @PathVariable("id") Long id){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
//        Phone phone = filterProducts.getPhoneByName(name);
        Phone phone = filterProducts.getPhoneById(id);
        List<Review> reviews = reviewService.findReviewsByProduct(id);

        log.info(phone.getName());
        model.addAttribute("product", phone);
        model.addAttribute("reviews", reviews);
        model.addAttribute("recommended", reviewService.calculateRecommended(reviews));
        return "description";
    }

    @PostMapping(value = "/product/{id}", params = "reviewSend")
    public String sendReview(Model model, Authentication authentication,
                             @PathVariable("id") Long id,
                             @RequestParam("rate") Integer rate, @RequestParam("review") String review,
                             @RequestParam("recommend") Boolean recommend){
        Phone phone = filterProducts.getPhoneById(id);
        boolean flag = reviewService.addReview(rate, review, recommend, authentication, id);
        List<Review> reviews = reviewService.findReviewsByProduct(id);

        model.addAttribute("product", phone);
        model.addAttribute("reviewExists", flag);
        model.addAttribute("reviews", reviews);
        model.addAttribute("recommended", reviewService.calculateRecommended(reviews));
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

        model = filterPostModel(model, "Watches", watchFilters, keys, filters, minValue, maxValue, sortType, authentication);
//        model.addAttribute("category", "Watches");
//        model.addAttribute("filters", watchFilters);
//        model.addAttribute("filtersKeys", keys);
//        model.addAttribute("filterName",filters);
        model.addAttribute("products", watches);
//        model.addAttribute("minValue", minValue);
//        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.maxWatch(filterProducts.getAllWatches()).getPrice()));
//        model.addAttribute("sortType", sortType);
        return "filters";
    }

    @GetMapping("/discounts")
    public String discounts(Model model, Authentication authentication){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        List<Product> products = filterProducts.getProductsWithDiscount();
        model.addAttribute("products", products);
        model.addAttribute("seacrhBool", true);
        return "filters";
    }

    @PostMapping("/discounts")
    public String sortedDiscounts(Model model, Authentication authentication, @RequestParam("sort") String sortType){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        List<Product> products = filterProducts.getProductsWithDiscount();
//        products = filterProducts.sort(products, sortType);
        model.addAttribute("products", products);
        model.addAttribute("seacrhBool", true);
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

//    @GetMapping("/description")
//    public String getDescriptionPage(Model model, Authentication authentication){
//        if(utils.checkAuth(authentication))
//            model.addAttribute("isAuthenticated", true);
//        return "description";
//    }

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

    @PostMapping(value = "updateFavorites", params = "heart")
    public String updateFavorites(Model model, Authentication authentication,
                                  @RequestParam("productId") Long productId,
                                  @RequestParam("path") String path
                                  ){
        Favorite favorite = favoriteService.getUserProducts(userDetailsService.getUserByEmail(authentication.getName()).getId());
        favorite = favoriteService.deleteProduct(favorite, productId);
        model.addAttribute("favoriteProducts", favorite.getFavoriteProducts());
        log.info(path);
        String redirect = "redirect:" + path;
        return redirect;
    }

    @PostMapping(value = "/phone", params = "addFavorite")
    public String addFavoritePhone(Model model, Authentication authentication,
                                   @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                   @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                   @RequestParam("sort") String sortType, @RequestParam("productId") Long productId){
        if(utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        Favorite favorite = favoriteService.getUserProducts(userDetailsService.getUserByEmail(authentication.getName()).getId());
        favoriteService.addProduct(favorite, productId);

        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        List<Phone> phones = filterProducts.phones(filters, phoneFilters, minValue, maxValue);
        phones = filterProducts.sort(phones, sortType);
        model = filterPostModel(model, "Phones", phoneFilters, keys, filters, minValue, maxValue, sortType, authentication);
        model.addAttribute("products", phones);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.max(filterProducts.getAllPhones()).getPrice()));
        return "filters";
    }

    private Model filterPostModel(Model model, String category, Map<String, List<String>> mapFilters,
                                  Set<String> keys, Set<String> filters,
                                  Integer minValue, Integer maxValue, String sortType,
                                  Authentication authentication){
        model.addAttribute("userFavorites", userDetailsService.getUserByEmail(authentication.getName()).getFavorite());
        model.addAttribute("category", category);
        model.addAttribute("filters", mapFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        model.addAttribute("minValue", minValue);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", (int) Math.floor(utils.maxLaptop(filterProducts.getAllLaptops()).getPrice()));
        model.addAttribute("sortType", sortType);
        return model;
    }
}
