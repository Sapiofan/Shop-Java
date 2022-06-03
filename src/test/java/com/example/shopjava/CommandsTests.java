package com.example.shopjava;

import com.example.shopjava.controllers.MainController;
import com.example.shopjava.entities.user.cart.CartProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "somemail@gmail.com", password = "somePassword")
public class CommandsTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void cleanWishlistTest() throws Exception {
        MvcResult result = this.mvc.perform(get("/cleanWishlist"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andReturn();
        int contentLen = result.getResponse().getContentLength();
        String content = result.getResponse().getContentAsString();
        Assertions.assertNotNull(content);
        Assertions.assertEquals(0, contentLen);
    }
}
