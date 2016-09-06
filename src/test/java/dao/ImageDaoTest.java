package dao;

import entity.Image;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class ImageDaoTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ImageDao imageDao;
    @Test
    public void getImages() throws Exception {
        //System.out.println(imageDao.getImages(1)+"*********************");
         int [] ids={5};
         imageDao.delImageByIds(ids);
    }

    @Test
    public void insertImage() throws Exception {
        Image image=new Image();
        image.setName("迷ee途");
        image.setDate(new Date());
        image.setUrl("www.bawwwidu.com");
        User user=new User();
        user.setId(2);
        image.setUser(user);
        System.out.println(imageDao.insertImage(image));
    }

}