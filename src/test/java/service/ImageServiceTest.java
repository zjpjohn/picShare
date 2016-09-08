package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class ImageServiceTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ImageService imageService;

    @Test
    public void getImage() throws Exception {

    }

    @Test
    public void insertImage() throws Exception {

    }

    @Test
    public void deleteImgesByIds() throws Exception {
     //重点测试 删除
        String ids="4,6";
        String urls="";
        imageService.deleteImgesByIds(ids,null);
    }

}