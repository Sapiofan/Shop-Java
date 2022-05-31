package com.example.shopjava.controllers;

import com.example.shopjava.configs.security.CustomUserDetailsService;
import com.example.shopjava.entities.another.Career;
import com.example.shopjava.entities.another.FAQ;
import com.example.shopjava.entities.product.*;
import com.example.shopjava.entities.user.Transaction;
import com.example.shopjava.entities.user.cart.CartProduct;
import com.example.shopjava.entities.contacts.Contact;
import com.example.shopjava.entities.user.Favorite;
import com.example.shopjava.entities.user.User;
import com.example.shopjava.repos.Utils;
import com.example.shopjava.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MainController {

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
    private TransactionService transactionService;

    @Autowired
    private CartService cartService;

    @Autowired
    private Utils utils;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String getHomePage(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);

        AdminController.bannersModel(model, adminService);

        List<Product> bestsellers = filterProducts.bestsellers().stream().limit(5).collect(Collectors.toList());
        model.addAttribute("bestsellers", bestsellers);

        return "home";
    }

    @PostMapping(value = "/", params = "registration")
    public String registration(@RequestParam("email") String email,
                               @RequestParam("psw") String psw,
                               @RequestParam("psw-repeat") String pswRepeat,
                               HttpServletRequest request,
                               Model model
    ) {
        String result = userDetailsService.signUp(email, psw, pswRepeat, request);
        if (!result.isEmpty()) {
            model.addAttribute("error", result);
            return getHomePage(model, null);
        }
        return login(email, psw, request, model);
    }

    @PostMapping(value = "/", params = "login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("psw") String psw,
                        HttpServletRequest request,
                        Model model
    ) {
        String res = userDetailsService.signIn(email, psw, request);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(!res.isEmpty()){
            getUserPreferences(model, SecurityContextHolder.getContext().getAuthentication());
        }
        model.addAttribute("error", res);
        return getHomePage(model, securityContext.getAuthentication());
    }

    @PostMapping(value = "/", params = "logout")
    public String logout(Model model) {
        SecurityContextHolder.getContext().setAuthentication(null);
        return getHomePage(model, null);
    }

    @GetMapping("/searching")
    public String filtersPage(Model model, @RequestParam("search") String searchKey, Authentication authentication) {
        if (utils.checkAuth(authentication))
            model.addAttribute("isAuthenticated", true);
        getUserPreferences(model, authentication);
        List<? extends Product> products = filterProducts.searchProducts(searchKey);
        model.addAttribute("products", products);
        model.addAttribute("searchKey", searchKey);

        model.addAttribute("seacrhBool", true);
        return "filters";
    }

    @GetMapping("/phones")
    public String phoneFilters(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);
        List<Phone> phones = filterProducts.getAllPhones();
        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        LinkedHashSet<String> filters = new LinkedHashSet<>();
        int max = utils.max(phones).getPrice();

        filterPostModel(model, "Phones", phoneFilters, keys, filters, 0, max, "From expensive to cheap");
        model.addAttribute("products", phones);
        model.addAttribute("max", max);
        return "filters";
    }

    @PostMapping("/phones")
    public String phoneFiltersPost(Model model, Authentication authentication,
                                   @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                   @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                   @RequestParam("sort") String sortType) {
        getUserPreferences(model, authentication);
        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        List<? extends Product> phones = filterProducts.phones(filters, phoneFilters, minValue, maxValue);
        phones = filterProducts.sort(phones, sortType);
        filterPostModel(model, "Phones", phoneFilters, keys, filters, minValue, maxValue, sortType);
        model.addAttribute("products", phones);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", utils.max(filterProducts.getAllPhones()).getPrice());
        return "filters";
    }

    @GetMapping("/laptops")
    public String laptopFilters(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);
        List<Laptop> laptops = filterProducts.getAllLaptops();
        Map<String, List<String>> laptopFilters = filterProducts.getLaptopCharacteristics();
        Set<String> keys = laptopFilters.keySet();
        LinkedHashSet<String> filters = new LinkedHashSet<>();
        int max = utils.maxLaptop(laptops).getPrice();

        filterPostModel(model, "Laptops", laptopFilters, keys, filters, 0, max, "From expensive to cheap");
        model.addAttribute("products", laptops);
        return "filters";
    }

    @PostMapping("/laptops")
    public String laptopFiltersPost(Model model, Authentication authentication,
                                    @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                    @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                    @RequestParam("sort") String sortType) {
        getUserPreferences(model, authentication);
        Map<String, List<String>> laptopFilters = filterProducts.getLaptopCharacteristics();
        Set<String> keys = laptopFilters.keySet();
        List<Laptop> laptops = filterProducts.laptops(filters, laptopFilters, minValue, maxValue);
        filterPostModel(model, "Laptops", laptopFilters, keys, filters, minValue, maxValue, sortType);
        model.addAttribute("products", laptops);
        model.addAttribute("max", utils.maxLaptop(filterProducts.getAllLaptops()).getPrice());
        return "filters";
    }

    @GetMapping("/product/{id}")
    public String getDescription(Model model, Authentication authentication,
                                 @PathVariable("id") Long id) {
        getUserPreferences(model, authentication);
        List<Review> reviews = reviewService.findReviewsByProduct(id);
        Integer rec = reviewService.calculateRecommended(reviews);
        Product product = filterProducts.getProductById(id);
        Map<String, List<String>> descTable = filterProducts.getDescTable(product);
        Set<String> descTableKeys = descTable.keySet();
        if (authentication != null)
            model.addAttribute("user", userDetailsService.getUserByEmail(authentication.getName()));
        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews);
        model.addAttribute("recommended", rec);
        model.addAttribute("descTable", descTable);
        model.addAttribute("descTableKeys", descTableKeys);
        model.addAttribute("descData", filterProducts.descData(product));
        return "description";
    }

    private void getUserPreferences(Model model, Authentication authentication) {
        if (utils.checkAuth(authentication)) {
            model.addAttribute("isAuthenticated", true);
            User user = userDetailsService.getUserByEmail(authentication.getName());
            model.addAttribute("favoriteProducts", user.getFavorite().getFavoriteProducts());
            model.addAttribute("cartProducts", user.getCart().getCartProducts());
            model.addAttribute("total", user.getCart().getTotalPrice());
        }
    }

    @PostMapping(value = "/product/{id}", params = "reviewSend")
    public String sendReview(Model model, Authentication authentication,
                             @PathVariable("id") Long id, @RequestParam("name") String name,
                             @RequestParam("rate") Integer rate, @RequestParam("review") String review,
                             @RequestParam("recommend") Boolean recommend) {
        getUserPreferences(model, authentication);
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            user.setName(name);
            userDetailsService.saveUser(user);
        }
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
    public String watchesFilters(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);
        List<Watch> watches = filterProducts.getAllWatches();
        Map<String, List<String>> watchFilters = filterProducts.getWatchCharacteristics();
        Set<String> keys = watchFilters.keySet();
        LinkedHashSet<String> filters = new LinkedHashSet<>();
        int max = utils.maxWatch(watches).getPrice();

        filterPostModel(model, "Watches", watchFilters, keys, filters, 0, max, "From expensive to cheap");
        model.addAttribute("products", watches);
        model.addAttribute("max", max);
        return "filters";
    }

    @PostMapping("/watches")
    public String watchesFiltersPost(Model model, Authentication authentication,
                                     @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                     @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                     @RequestParam("sort") String sortType) {
        getUserPreferences(model, authentication);
        Map<String, List<String>> watchFilters = filterProducts.getWatchCharacteristics();
        Set<String> keys = watchFilters.keySet();
        List<Watch> watches = filterProducts.watches(filters, watchFilters, minValue, maxValue);

        filterPostModel(model, "Watches", watchFilters, keys, filters, minValue, maxValue, sortType);
        model.addAttribute("products", watches);
        model.addAttribute("max", utils.maxWatch(filterProducts.getAllWatches()).getPrice());
        return "filters";
    }

    @GetMapping("/discounts")
    public String discounts(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);
        List<Product> products = filterProducts.getProductsWithDiscount();
        model.addAttribute("products", products);
        model.addAttribute("seacrhBool", true);
        return "filters";
    }

    @PostMapping("/discounts")
    public String sortedDiscounts(Model model, Authentication authentication, @RequestParam("sort") String sortType) {
        getUserPreferences(model, authentication);
        List<? extends Product> products = filterProducts.getProductsWithDiscount();
        products = filterProducts.sort(products, sortType);
        model.addAttribute("products", products);
        model.addAttribute("seacrhBool", true);
        return "filters";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);
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
        getUserPreferences(model, authentication);
        Career career = new Career(fname, lname, email, phone, pos, link);
        String result = careerService.addCareerUser(career);
        model.addAttribute("result", result);
        return "about";
    }

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model, Authentication authentication) {
        if (utils.checkAuth(authentication)) {
            model.addAttribute("isAuthenticated", true);
            User user = userDetailsService.getUserByEmail(authentication.getName());
            model.addAttribute("cartProducts", user.getCart().getCartProducts());
            model.addAttribute("total", user.getCart().getTotalPrice());
        }
        return "checkout";
    }

    @GetMapping("/checkout/{id}")
    public String buyProduct(Model model, @PathVariable("id") Long productId){
        Product product = filterProducts.getProductById(productId);
        model.addAttribute("cartProducts", Collections.singletonList(product));
        model.addAttribute("total", product.getPrice());
        return "checkout";
    }

    @PostMapping(value = {"/checkout", "/checkout/{id}"})
    public String pay(Model model,
                      @RequestParam("name") String name,
                      @RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2, @RequestParam("phone3") String phone3,
                      @RequestParam("email") String email,
                      @RequestParam("city") String city,
                      @RequestParam("part1") String card1, @RequestParam("part2") String card2,
                      @RequestParam("part3") String card3, @RequestParam("part4") String card4,
                      @RequestParam("prefix") String date1, @RequestParam("suffix") String date2,
                      @RequestParam("cvv") String cvv,
                      @RequestParam("total") String total
    ) {
        String phone = phone1 + phone2 + phone3;
        String card = card1 + card2 + card3 + card4;
        String date = date1 + "/" + date2;
        Transaction transaction = transactionService.addNewTransaction(name, phone, email, city, card,
                date, cvv, Integer.valueOf(total.substring(0, total.length()-3)));
        model.addAttribute("transaction", transaction);
        return "success";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);
        return "contact";
    }

    @PostMapping(value = "/contact", params = "form")
    public String filledContactForm(Model model, Authentication authentication,
                                    @RequestParam("fname") String fname,
                                    @RequestParam("lname") String lname,
                                    @RequestParam("email") String email,
                                    @RequestParam("subject") String subject,
                                    @RequestParam("message") String message
    ) {
        getUserPreferences(model, authentication);
        Contact contact = new Contact(fname, lname, email);
        String result = contactService.addContactMessage(contact, subject, message);
        model.addAttribute("result", result);
        return "contact";
    }

    @PostMapping(value = "/contact", params = "subs")
    public String filledEmail(Model model, Authentication authentication,
                              @RequestParam("email") String email) {
        getUserPreferences(model, authentication);
        String result = contactService.subs(email);
        model.addAttribute("result", result);
        return "contact";
    }

    @GetMapping("/help")
    public String getHelpPage(Model model, Authentication authentication) {
        getUserPreferences(model, authentication);
        List<FAQ> faqs = faqService.getFaqs();
        model.addAttribute("faqs", faqs);
        return "help";
    }

    @GetMapping(value = "/addProduct/{id}")
    @ResponseBody
    public Set<Product> addProductToFavorites(Authentication authentication,
                                              @PathVariable("id") Long productId
    ) {
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            user.getFavorite().getFavoriteProducts().add(filterProducts.getProductById(productId));
            userDetailsService.saveUser(user);
            return user.getFavorite().getFavoriteProducts();
        }
        return null;
    }

    @GetMapping(value = "/cleanWishlist")
    @ResponseBody
    public Set<Product> cleanFavorites(Authentication authentication
    ) {
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            user.getFavorite().getFavoriteProducts().clear();
            userDetailsService.saveUser(user);
            return user.getFavorite().getFavoriteProducts();
        }
        return null;
    }

    @GetMapping(value = "/deleteFavorite/{id}")
    @ResponseBody
    public Set<Product> deleteFavorite(Authentication authentication, @PathVariable("id") Long productId
    ) {
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            user.getFavorite().getFavoriteProducts().remove(filterProducts.getProductById(productId));
            userDetailsService.saveUser(user);
            return user.getFavorite().getFavoriteProducts();
        }
        return null;
    }

    @GetMapping(value = "/deleteCartProduct/{id}")
    @ResponseBody
    public Set<CartProduct> deleteCartProduct(Authentication authentication, @PathVariable("id") Long productId
    ) {
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            cartService.deleteProduct(user.getCart(), productId);
            return user.getCart().getCartProducts();
        }
        return null;
    }

    @GetMapping(value = "/addToCart/{id}")
    @ResponseBody
    public Set<CartProduct> addToCart(Authentication authentication, @PathVariable("id") Long productId
    ) {
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            cartService.addProduct(user.getCart(), productId);
            return user.getCart().getCartProducts();
        }
        return null;
    }

    @GetMapping(value = "/addAdditionalProduct/{id}")
    @ResponseBody
    public Set<CartProduct> addAdditionalProduct(Authentication authentication, @PathVariable("id") Long productId){
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            cartService.increaseQuantity(productId, user.getCart());
            return user.getCart().getCartProducts();
        }
        return null;
    }

    @GetMapping(value = "/subtractAdditionalProduct/{id}")
    @ResponseBody
    public Set<CartProduct> subtractAdditionalProduct(Authentication authentication, @PathVariable("id") Long productId){
        if (authentication != null) {
            User user = userDetailsService.getUserByEmail(authentication.getName());
            cartService.decreaseQuantity(productId, user.getCart());
            return user.getCart().getCartProducts();
        }
        return null;
    }

    @PostMapping(value = "/phone", params = "addFavorite")
    public String addFavoritePhone(Model model, Authentication authentication,
                                   @RequestParam(value = "filter-name", required = false) LinkedHashSet<String> filters,
                                   @RequestParam("input-min") Integer minValue, @RequestParam("input-max") Integer maxValue,
                                   @RequestParam("sort") String sortType, @RequestParam("productId") Long productId) {
        getUserPreferences(model, authentication);
        Favorite favorite = favoriteService.getUserProducts(userDetailsService.getUserByEmail(authentication.getName()).getId());
        favoriteService.addProduct(favorite, productId);

        Map<String, List<String>> phoneFilters = filterProducts.getPhoneCharacteristics();
        Set<String> keys = phoneFilters.keySet();
        List<? extends Product> phones = filterProducts.phones(filters, phoneFilters, minValue, maxValue);
        phones = filterProducts.sort(phones, sortType);
        filterPostModel(model, "Phones", phoneFilters, keys, filters, minValue, maxValue, sortType);
        model.addAttribute("products", phones);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("max", utils.max(filterProducts.getAllPhones()).getPrice());
        return "filters";
    }

    private Model filterPostModel(Model model, String category, Map<String, List<String>> mapFilters,
                                  Set<String> keys, Set<String> filters,
                                  Integer minValue, Integer maxValue, String sortType) {
        model.addAttribute("category", category);
        model.addAttribute("filters", mapFilters);
        model.addAttribute("filtersKeys", keys);
        model.addAttribute("filterName", filters);
        model.addAttribute("minValue", minValue);
        model.addAttribute("maxValue", maxValue);
        model.addAttribute("sortType", sortType);
        return model;
    }
}
