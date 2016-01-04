package com.piggsoft.service;

import com.piggsoft.constants.Constants;
import com.piggsoft.mapper.UserMapper;
import com.piggsoft.model.User;
import com.piggsoft.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <br>Created by fire pigg on 2015/12/30.
 *
 * @author piggsoft@163.com
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User create(User user) {
        if (StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(Constants.DEFAULT_PASSWORD);
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
        return user;
    }

    public User findUser(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public User login(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(DigestUtils.md5DigestAsHex(password.getBytes()));
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }


}
