package com.piggsoft.service;

import com.piggsoft.constants.Constants;
import com.piggsoft.dao.UserDao;
import com.piggsoft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * <br>Created by fire pigg on 2015/12/30.
 *
 * @author piggsoft@163.com
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public User create(User user) {
        if (StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(Constants.DEFAULT_PASSWORD);
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userDao.save(user);
    }

    public User findUser(int userId) {
        return userDao.findOne(userId);
    }

    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, DigestUtils.md5DigestAsHex(password.getBytes()));
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
