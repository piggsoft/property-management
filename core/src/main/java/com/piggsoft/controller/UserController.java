package com.piggsoft.controller;

import com.piggsoft.context.TokenManager;
import com.piggsoft.model.User;
import com.piggsoft.response.Rsp;
import com.piggsoft.response.SuccessRsp;
import com.piggsoft.response.TokenRsp;
import com.piggsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <br>Created by fire pigg on 2015/12/30.
 *
 * @author piggsoft@163.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create")
    public Rsp create(User user) {
        userService.create(user);
        return new SuccessRsp();
    }

    @RequestMapping(value = "/test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        return map;
    }

}
