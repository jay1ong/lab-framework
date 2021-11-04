package com.im.test.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/1
 */
@RestController
@Api(tags = "keycloak 接口")
@RequestMapping
@RequiredArgsConstructor
public class KeycloakController {

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
