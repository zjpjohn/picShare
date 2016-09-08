package service.Impl;

import dao.ImageDao;
import entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ImageService;
import utils.FileUtils;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
@Service
public class ImageServiceImpl  implements ImageService {
    @Autowired
    private ImageDao imageDao;
    public List<Image> getImage(int uid) {

        return imageDao.getImages(uid);
    }

    public boolean InsertImage(Image image,InputStream inputStream) {
        FileUtils.upload(inputStream, image.getUrl());//同时完成图片的上传工作
        return  imageDao.insertImage(image)>=1;
    }
    /*
     * 通过图片ID数组和图片URL数组删除图片
     * @param ids 图片ID数组
     * @param
     *  也就在在这个基础之上，增加对图片的实际删除操作
     *
     *
     *
     */
    public boolean deleteImgesByIds(String  id_s,String urls) {
        String ids[]=id_s.split(",");
        int dds[]=new int[ids.length];
        for(int i=0;i<ids.length;i++){
            dds[i]=Integer.valueOf(ids[i]);
        }
        if(urls!=null)
        {
            String[] urlArray = urls.split(",");
            if(!"".equals(urlArray[0])){
                for(int i=0;i<ids.length;i++){
                    FileUtils.delete(urlArray[i]);//同时删除图片的链接
                }
            }
        }
        return imageDao.delImageByIds(dds)>=1;
    }
}
