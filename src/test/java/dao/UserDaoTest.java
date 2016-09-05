package dao;


import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by Administrator on 2016/9/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;
    @Test
    public void getUserByName() throws Exception {
     List<User> list= userDao.getUserByName("ddd");
        System.out.println("***********");
    }

    @Test
    public void insertUser() throws Exception {

    }

}