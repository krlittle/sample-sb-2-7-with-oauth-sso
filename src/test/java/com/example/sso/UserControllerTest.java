package com.example.sso;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void redirectsAnonymousUsersToLogin() throws Exception {
        mvc.perform(get("/user")).andExpect(status().is3xxRedirection());
    }

    @Test
    void showsTheLoggedInUsersName() throws Exception {
        mvc.perform(get("/user").with(oauth2Login().attributes(attributes -> attributes.put("login", "alice"))))
                .andExpect(content().string("alice"));
    }
}
