package dao;

import entity.Image;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface ImageDao {
    public List<Image> getImages(int uid);
    public int insertImage(Image image);//插入图片，，根据用户id插入
}
