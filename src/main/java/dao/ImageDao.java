package dao;

import entity.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface ImageDao {
    public List<Image> getImages(int uid);//根据用户id获得图片
    public int insertImage(Image image);//插入图片，，根据用户id插入
    //根据图片id数组删除图片
    public int delImageByIds(@Param("ids") int ids[]);
}
