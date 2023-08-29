package org.springboot.book.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public static final String HELLO_URL = "/hello";
    public static final String HELLO_DTO_URL = "/hello/dto";

    @GetMapping(HELLO_URL)
    public String hello() {
        return "hello";
    }
}
