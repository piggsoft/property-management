package com.piggsoft.dao;

import com.piggsoft.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br>Created by fire pigg on 2015/12/11.
 *
 * @author piggsoft@163.com
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
