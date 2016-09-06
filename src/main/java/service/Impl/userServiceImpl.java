package service.Impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.userService;

/**
 * Created by Administrator on 2016/9/6.
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    private UserDao userDao;
    public User getUserByName(String name) {
        return userDao.getUserByName(name).get(0);
    }

    public boolean insertUser(User user) {

        return userDao.insertUser(user)>=1;
    }
}
