package com.example.shopjava.controllers;

import com.example.shopjava.entities.Career;
import com.example.shopjava.entities.FAQ;
import com.example.shopjava.entities.Product;
import com.example.shopjava.entities.Review;
import com.example.shopjava.entities.admin.AdminHome;
import com.example.shopjava.entities.contacts.Contact;
import com.example.shopjava.entities.contacts.Message;
import com.example.shopjava.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private FaqService faqService;

    @Autowired
    private CareerService careerService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private FilterProducts filterProducts;

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/home")
    public String getAdminHome(Model model) {
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

        return "admin-home";
    }

    @PostMapping(value = "/admin/home", params = "see")
    public String getHomeChanges(Model model,
                                 @RequestParam("link1") String link1, @RequestParam("link2") String link2,
                                 @RequestParam("banner11") String banner11, @RequestParam("banner12") String banner12,
                                 @RequestParam("banner13") String banner13, @RequestParam("banner21") String banner21,
                                 @RequestParam("banner22") String banner22, @RequestParam("banner23") String banner23
                                 ){
        model.addAttribute("link1", link1);
        model.addAttribute("link2", link2);
        model.addAttribute("banner11", banner11);
        model.addAttribute("banner12", banner12);
        model.addAttribute("banner13", banner13);
        model.addAttribute("banner21", banner21);
        model.addAttribute("banner22", banner22);
        model.addAttribute("banner23", banner23);
        return "admin-home";
    }

    @PostMapping(value = "/admin/home", params = "save")
    public String saveHomeChanges(Model model,
                                  @RequestParam("link1") String link1, @RequestParam("link2") String link2,
                                  @RequestParam("banner11") String banner11, @RequestParam("banner12") String banner12,
                                  @RequestParam("banner13") String banner13, @RequestParam("banner21") String banner21,
                                  @RequestParam("banner22") String banner22, @RequestParam("banner23") String banner23){
        List<AdminHome> adminHomeList = new ArrayList<>();
        String banner1Text = banner11 + "#" + banner12 + "#" + banner13;
        String banner2Text = banner21 + "#" + banner22 + "#" + banner23;
        adminHomeList.add(new AdminHome(1, link1, banner1Text));
        adminHomeList.add(new AdminHome(2, link2, banner2Text));
        adminService.addNewBannerState(adminHomeList);

        model.addAttribute("link1", link1);
        model.addAttribute("link2", link2);
        model.addAttribute("banner11", banner11);
        model.addAttribute("banner12", banner12);
        model.addAttribute("banner13", banner13);
        model.addAttribute("banner21", banner21);
        model.addAttribute("banner22", banner22);
        model.addAttribute("banner23", banner23);
        return "admin-home";
    }

    @GetMapping("/admin/career")
    public String getAdminCareerFirst(Model model){
        return getAdminCareer(model, 1);
    }

    @GetMapping("/admin/career/{pageNum}")
    public String getAdminCareer(Model model,
                                 @PathVariable("pageNum") int pageNum) {
        Page<Career> pageCareers = careerService.getCareers(pageNum);
        List<Career> careers = pageCareers.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pageCareers.getTotalPages());
        model.addAttribute("totalItems", pageCareers.getTotalElements());
        model.addAttribute("careers", careers);
        return "admin-career";
    }

    @GetMapping("/admin/career/{pageNum}/delete/{id}")
    public String deleteCareer(Model model, @PathVariable("id") Long id,
                               @PathVariable("pageNum") int pageNum) {
        careerService.deleteCareerUserById(id);
        Page<Career> pageCareers = careerService.getCareers(pageNum);
        List<Career> careers = pageCareers.getContent();
        if(careers.isEmpty() && pageNum != 1){
            pageCareers = careerService.getCareers(pageNum-1);
            careers = pageCareers.getContent();
        }
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pageCareers.getTotalPages());
        model.addAttribute("totalItems", pageCareers.getTotalElements());
        model.addAttribute("careers", careers);
        return "admin-career";
    }

    @GetMapping("/admin/faq")
    public String getAdminFaq(Model model) {
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        model.addAttribute("editMode", false);
        return "admin-faq";
    }

    @PostMapping(value = "/admin/faq", params = "addFaq")
    public String addFaq(Model model,
                         @RequestParam("question") String question,
                         @RequestParam("answer") String answer
    ) {
        faqService.addFaq(new FAQ(question, answer));
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        model.addAttribute("editMode", false);
        return "admin-faq";
    }

    @GetMapping(value = "/admin/faq/{id}")
    public String getEditFaq(Model model,
                             @RequestParam("ex-question") String question,
                             @RequestParam("ex-answer") String answer,
                             @PathVariable("id") Long id
    ) {
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        model.addAttribute("editMode", true);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        model.addAttribute("id", id);
        return "admin-faq";
    }

    @PostMapping(value = "/admin/faq", params = "edit")
    public String postEditFaq(Model model,
                              @RequestParam("editQuestion") String question,
                              @RequestParam("editAnswer") String answer,
                              @RequestParam("id") Long id) {
        faqService.editFaq(id, question, answer);
        log.info(question);
        log.info(answer);
        log.info("" + id);
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        model.addAttribute("editMode", false);
        model.addAttribute("id", id);
        return "admin-faq";
    }

    @GetMapping(value = "/admin/faq/delete/{id}")
    public String deleteFaq(Model model,
                            @PathVariable("id") Long id
    ) {
        faqService.deleteById(id);
        log.info(id + "");
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        model.addAttribute("editMode", false);
        return "admin-faq";
    }

    @GetMapping("/admin/feedback")
    public String getFirstAdminFeedback(Model model){
        return getAdminFeedback(model, 1);
    }

    @GetMapping("/admin/feedback/{pageNum}")
    public String getAdminFeedback(Model model, @PathVariable("pageNum") int pageNum) {
        Page<Message> pageContacts = contactService.contacts(pageNum);
        List<Message> messages = pageContacts.getContent();
        model.addAttribute("messages", messages);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pageContacts.getTotalPages());
        model.addAttribute("totalItems", pageContacts.getTotalElements());
        return "admin-feedback";
    }

    @GetMapping("/admin/feedback/{pageNum}/delete/{id}")
    public String deleteContact(Model model, @PathVariable("id") Long id, @PathVariable("pageNum") int pageNum) {
        contactService.deleteById(id);
        Page<Message> pageContacts = contactService.contacts(pageNum);
        List<Message> messages = pageContacts.getContent();
        if(messages.isEmpty() && pageNum != 1){
            pageContacts = contactService.contacts(pageNum-1);
            messages = pageContacts.getContent();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pageContacts.getTotalPages());
        model.addAttribute("totalItems", pageContacts.getTotalElements());
        return "admin-feedback";
    }

    @GetMapping("/admin/products")
    public String getAdminFirstProducts(Model model){
        return getAdminProducts(model, 1);
    }

    @GetMapping("/admin/products/{pageNum}")
    public String getAdminProducts(Model model, @PathVariable("pageNum") int pageNum) {
        Page<Product> pageProducts = filterProducts.getAllProducts(pageNum);
        List<Product> products = pageProducts.getContent();
        model.addAttribute("products", products);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pageProducts.getTotalPages());
        model.addAttribute("totalItems", pageProducts.getTotalElements());
        return "admin-products";
    }

    @PostMapping(value = "/admin/products")
    public String findProducts(Model model, @RequestParam("searchKey") String search){
        List<Product> products = new ArrayList<>();
        try {
            Product product = filterProducts.getProductById(Long.valueOf(search));
            products.add(product);
        }catch (NumberFormatException e){
            products = filterProducts.searchUncertainProducts(search);
        }
        model.addAttribute("products", products);
        return "admin-products";
    }

    @GetMapping("/admin/products/{pageNum}/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Long id, @PathVariable("pageNum") int pageNum){
        filterProducts.deleteById(id);
        Page<Product> pageProducts = filterProducts.getAllProducts(pageNum);
        List<Product> products = pageProducts.getContent();
        if(products.isEmpty() && pageNum != 1){
            pageProducts = filterProducts.getAllProducts(pageNum-1);
            products = pageProducts.getContent();
        }
        model.addAttribute("products", products);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pageProducts.getTotalPages());
        model.addAttribute("totalItems", pageProducts.getTotalElements());
        return "admin-products";
    }

    @GetMapping("/admin/reviews")
    public String getAdminFirstReviews(Model model){
        return getAdminReviews(model, 1);
    }

    @GetMapping("/admin/reviews/{pageNum}")
    public String getAdminReviews(Model model, @PathVariable("pageNum") int pageNum) {
        Page<Review> pagesReviews = reviewService.getAll(pageNum);
        List<Review> reviews = pagesReviews.getContent();
        model.addAttribute("reviews", reviews);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pagesReviews.getTotalPages());
        model.addAttribute("totalItems", pagesReviews.getTotalElements());
        return "admin-reviews";
    }

    @GetMapping("/admin/addProduct")
    public String addProduct(Model model){
        return "add-product";
    }

    @PostMapping("/admin/addProduct")
    public String generalProduct(Model model,
                                 @RequestParam("name") String name,
                                 @RequestParam("category") String category,
                                 @RequestParam("brand") String brand,
                                 @RequestParam("price") String stringPrice,
                                 @RequestParam("payment") String payment,
                                 @RequestParam("warranty") Integer warranty,
                                 @RequestParam("available") Boolean available,
                                 @RequestParam(value = "gifts", required = false) String gifts,
                                 @RequestParam(value = "discount", required = false) int discount,
                                 @RequestParam("link") String link
                                 ){
        stringPrice = stringPrice.replace(" ", "");
        stringPrice = stringPrice.replace(",", ".");
        Float price;
        try {
            price = Float.valueOf(stringPrice);
        } catch (NumberFormatException e){
            price = (float) 0;
        }
        Product product = new Product(link, name, price, brand, payment, (float) 0, discount, gifts, available, warranty,
                Date.from(Instant.now()), 0, filterProducts.getCategory(category));
        model.addAttribute("product", product);
//        model.addAttribute("values", defineCategoryValue());
        return "add-certain-product";
    }

    @GetMapping(value = "/admin/reviews/{pageNum}/delete/{id}")
    public String deleteReview(Model model,
                               @PathVariable("id") Long id, @PathVariable("pageNum") int pageNum){
        reviewService.deleteById(id);
        Page<Review> pagesReviews = reviewService.getAll(pageNum);
        List<Review> reviews = pagesReviews.getContent();
        if(reviews.isEmpty() && pageNum != 1){
            pagesReviews = reviewService.getAll(pageNum - 1);
            reviews = pagesReviews.getContent();
        }
        model.addAttribute("reviews", reviews);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pagesReviews.getTotalPages());
        model.addAttribute("totalItems", pagesReviews.getTotalElements());
        return "admin-reviews";
    }

    @PostMapping("/admin/reviews")
    public String searchReviews(Model model, @RequestParam("search") String searchKey){
        List<Review> reviews = null;
        try {
            reviews = reviewService.findReviewsByProduct(Long.valueOf(searchKey));
        } catch (NumberFormatException e){
            reviews = reviewService.findReviewsByUser(searchKey);
        }
        model.addAttribute("reviews", reviews);
        return "admin-reviews";
    }
}
