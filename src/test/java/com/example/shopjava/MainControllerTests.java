package com.example.shopjava;

import com.example.shopjava.entities.product.Phone;
import com.example.shopjava.entities.product.Product;
import com.example.shopjava.repos.PhoneRepository;
import com.example.shopjava.repos.ProductRepository;
import com.example.shopjava.repos.impl.FilterProductsRepoImpl;
import com.example.shopjava.services.impl.FilterProductsImpl;
import com.example.shopjava.services.impl.PhoneServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTests {
    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private FilterProductsImpl filterProducts;

    @InjectMocks
    private PhoneServiceImpl phoneService;

    @InjectMocks
    private FilterProductsRepoImpl filterProductsImpl;

    @Mock
    ProductRepository productRepository;

    @Mock
    PhoneRepository phoneRepository;

    private static final Logger log = LoggerFactory.getLogger(MainControllerTests.class);

    @Test
    public void loadHomePageTest() throws Exception {
        this.mvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void loadAboutPageTest() throws Exception {
        this.mvc.perform(get("/about"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void searchNegativeTest() throws Exception {
        this.mvc.perform(get("/searching")
                        .param("search", "searchKey"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("products", hasSize(0)))
                .andReturn();
    }

    @Test
    public void getPhonesPageTest() throws Exception {
        this.mvc.perform(get("/phones"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void negativeAndBigPricePostPhonesTest() throws Exception {
        this.mvc.perform(post("/phones")
                        .param("input-min", "100000")
                        .param("input-max", "20000000")
                        .param("sort", "From expensive to cheap"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("products", hasSize(0)));

        this.mvc.perform(post("/phones")
                        .param("input-min", "-500")
                        .param("input-max", "0")
                        .param("sort", "From expensive to cheap"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("products", hasSize(0)));
    }

    @Test
    public void getLaptopsPageTest() throws Exception {
        this.mvc.perform(get("/laptops"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getWatchPageTest() throws Exception {
        this.mvc.perform(get("/watches"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getDiscountPageTest() throws Exception {
        this.mvc.perform(get("/discounts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void sortDiscountPageTest() throws Exception {
        Product product1 = new Product();
        product1.setDiscount(5);

        Product product2 = new Product();
        product2.setDiscount(10);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        when(productRepository.discounts()).thenReturn(products);

//        List<Product> productList = filterProducts.getProductsWithDiscount();

        this.mvc.perform(post("/discounts")
                        .param("sort", "From expensive to cheap"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("products", hasSize(2)));

        verify(productRepository).discounts();
//        Assertions.assertAll(() -> {
//            assertEquals(5, productList.get(0).getDiscount());
//            assertEquals(10, productList.get(1).getDiscount());
//        });
    }

    @Test
    public void getBestsellersPageTest() throws Exception {
        this.mvc.perform(get("/bestsellers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void loadContactPageTest() throws Exception {
        this.mvc.perform(get("/contact"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void loadHelpPageTest() throws Exception {
        this.mvc.perform(get("/help"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
