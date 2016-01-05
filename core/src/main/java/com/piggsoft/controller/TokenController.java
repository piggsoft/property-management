package com.piggsoft.controller;

import com.piggsoft.constants.Constants;
import com.piggsoft.context.TokenManager;
import com.piggsoft.model.User;
import com.piggsoft.response.TokenRsp;
import com.piggsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>Created by fire pigg on 2016/01/05.
 *
 * @author piggsoft@163.com
 */
@RestController
@RequestMapping(Constants.TOKEN_URL)
public class TokenController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public TokenRsp token(String username, String password) {
        User user = userService.login(username, password);
        String token = TokenManager.add(user);
        return new TokenRsp(token);
    }

}
