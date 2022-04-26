package com.example.shopjava.controllers;

import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;
import com.example.shopjava.services.FilterProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class MyController {

    @Autowired
    private FilterProducts filterProducts;

    @GetMapping("/")
    public String getHomePage(Model model){
        return "home";
    }

    @GetMapping("/filters")
    public String filtersPage(Model model, @Param("search") String searchKey){
        List<? extends Product> products = filterProducts.searchProducts(searchKey);
        model.addAttribute("products", products);
        model.addAttribute("searchKey", searchKey);

        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        model.addAttribute("filters", phoneFilters);
        model.addAttribute("filtersKeys", keys);
        return "filters";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model){
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

    @GetMapping("/description")
    public String getDescriptionPage(Model model){
        return "description";
    }

    @GetMapping("/help")
    public String getHelpPage(Model model){
        return "help";
    }

    @GetMapping("/success")
    public String getSuccessPage(Model model){
        return "success";
    }
}
