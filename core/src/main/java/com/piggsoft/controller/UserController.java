package com.piggsoft.controller;

import com.piggsoft.model.User;
import com.piggsoft.response.Response;
import com.piggsoft.response.SuccessResponse;
import com.piggsoft.service.UserService;
import net.sf.ehcache.Ehcache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
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

    @Autowired
    private Cache cache;

    @RequestMapping(value = "/create")
    public Response create(User user) {
        userService.create(user);
        return new SuccessResponse();
    }

    @RequestMapping(value = "/login")
    public Response login(String username, String password) {
        userService.login(username, password);
        System.out.println(cache == null);
        return new SuccessResponse();
    }

    @RequestMapping(value = "/test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        return map;
    }

}
