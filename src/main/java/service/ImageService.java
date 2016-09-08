package service;

import entity.Image;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface ImageService {
    public List<Image> getImage(int uid);
    public boolean InsertImage(Image image,InputStream inputStream);
    public boolean deleteImgesByIds(String ids,String urls);
}
