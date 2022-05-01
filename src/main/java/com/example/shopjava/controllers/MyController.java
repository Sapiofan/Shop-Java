package com.example.shopjava.controllers;

import com.example.shopjava.entities.Career;
import com.example.shopjava.entities.FAQ;
import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.contacts.Contact;
import com.example.shopjava.entities.Product;
import com.example.shopjava.services.CareerService;
import com.example.shopjava.services.ContactService;
import com.example.shopjava.services.FaqService;
import com.example.shopjava.services.FilterProducts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    private static final Logger log = LoggerFactory.getLogger("log");

    @GetMapping("/")
    public String getHomePage(Model model){
        return "home";
    }

    @GetMapping("/filters")
    public String filtersPage(Model model, @RequestParam("search") String searchKey){
        List<? extends Product> products = filterProducts.searchProducts(searchKey);
        model.addAttribute("products", products);
        model.addAttribute("searchKey", searchKey);

        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        LinkedHashSet<String> filters = new LinkedHashSet<>();
        filters.add("");


        model.addAttribute("filters", phoneFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName",filters);
        return "filters";
    }

    @PostMapping("/filters")
    public String getFilters(Model model, @RequestParam("filter-name") LinkedHashSet<String> filters){
        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        List<? extends Product> products = filterProducts.phones(filters, phoneFilters);
        for (Product phone : products) {
            log.info(phone.getName());
        }
        model.addAttribute("products", products);
        model.addAttribute("filterName",filters);
        model.addAttribute("filters", phoneFilters);
        model.addAttribute("filtersKeys", keys);
        return "filters";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model){
        return "about";
    }

    @PostMapping("/about")
    public String filledCareer(Model model,
                               @RequestParam("fname") String fname,
                               @RequestParam("lname") String lname,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone,
                               @RequestParam("pos") String pos,
                               @RequestParam("link") String link) {
        Career career = new Career(fname, lname, email, phone, pos, link);
        String result = careerService.addCareerUser(career);
        model.addAttribute("result", result);
        return "about";
    }

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model){
        return "checkout";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model){
        return "contact";
    }

    @PostMapping(value = "/contact", params = "form")
    public String filledContactForm(Model model,
                                    @RequestParam("fname") String fname,
                                    @RequestParam("lname") String lname,
                                    @RequestParam("email") String email,
                                    @RequestParam("subject") String subject,
                                    @RequestParam("message") String message
                                    ){
        Contact contact = new Contact(fname, lname, email);
        String result = contactService.addContactMessage(contact, subject, message);
        model.addAttribute("result", result);
        return "contact";
    }

    @PostMapping(value = "/contact", params = "subs")
    public String filledEmail(Model model,
                              @RequestParam("email") String email){
        String result = contactService.subs(email);
        model.addAttribute("result", result);
        return "contact";
    }

    @GetMapping("/description")
    public String getDescriptionPage(Model model){
        return "description";
    }

    @GetMapping("/help")
    public String getHelpPage(Model model){
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        return "help";
    }

    @GetMapping("/success")
    public String getSuccessPage(Model model){
        return "success";
    }
}
