package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface UserDao {

    public List<User> getUserByName(@Param("username") String username);//获取用户信息 包括图片信息
    public int insertUser(User user);
}
