package service;

import entity.User;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface userService {
    public User getUserByName(String name);
    public boolean insertUser(User user);
}
