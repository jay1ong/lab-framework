package com.im.test.controller;

import com.im.web.OriginResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@RestController
@OriginResponse
public class TestController {


    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("test1")
    public String test1() {
        return "test1";
    }

}
