package org.springboot.book.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("hello가 리턴된다")
    public void returnHello() throws Exception {
        String hello = "hello";

        mockMvc.perform(get(HelloController.HELLO_URL)) //
                .andExpect(status().isOk()) //
                .andExpect(content().string(hello));
    }

    @Test
    @DisplayName("hello Dto가 리턴된다")
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(get(HelloController.HELLO_DTO_URL) //
                        .param("name", name)//
                        .param("amount", String.valueOf(amount))) //
                .andExpect(status().isOk()) //
                .andExpect((ResultMatcher) jsonPath("$.name", is(name))) //
                .andExpect((ResultMatcher) jsonPath("$.amount", is(amount)));
    }
}
