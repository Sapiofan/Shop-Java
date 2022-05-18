package com.example.shopjava.controllers;

import com.example.shopjava.entities.Career;
import com.example.shopjava.entities.FAQ;
import com.example.shopjava.entities.Review;
import com.example.shopjava.entities.contacts.Contact;
import com.example.shopjava.services.CareerService;
import com.example.shopjava.services.ContactService;
import com.example.shopjava.services.FaqService;
import com.example.shopjava.services.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/admin/home")
    public String getAdminHome(Model model) {
        return "admin-home";
    }

    @GetMapping("/admin/career")
    public String getAdminCareer(Model model) {
        List<Career> careers = careerService.getCareers();
        model.addAttribute("careers", careers);
        return "admin-career";
    }

    @GetMapping("/admin/career/delete/{id}")
    public String deleteCareer(Model model, @PathVariable("id") Long id) {
        careerService.deleteCareerUserById(id);
        log.info(id + "");
        List<Career> careers = careerService.getCareers();
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
    public String getAdminFeedback(Model model) {
        List<Contact> contacts = contactService.contacts();
        model.addAttribute("contacts", contacts);
        return "admin-feedback";
    }

    @GetMapping("/admin/feedback/delete/{id}")
    public String deleteContact(Model model, @PathVariable("id") Long id) {
        contactService.deleteById(id);
        log.info(id + "");
        List<Contact> contacts = contactService.contacts();
        model.addAttribute("contacts", contacts);
        return "admin-feedback";
    }

    @GetMapping("/admin/products")
    public String getAdminProducts(Model model) {
        return "admin-products";
    }

    @GetMapping("/admin/reviews")
    public String getAdminReviews(Model model) {
        List<Review> reviews = reviewService.getAll();
        model.addAttribute("reviews", reviews);
        return "admin-reviews";
    }

    @GetMapping(value = "/admin/reviews/delete/{id}")
    public String deleteReview(Model model,
                               @PathVariable("id") Long id){
        reviewService.deleteById(id);
        List<Review> reviews = reviewService.getAll();
        model.addAttribute("reviews", reviews);
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
