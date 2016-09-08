package controller;

import entity.Image;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ImageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;
  //主要完成图片的删除和完成上传

  public  void operation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      Integer type = Integer.valueOf(request.getParameter("type"));
      if (type == 1) {    //上传图片
          String imageName = request.getParameter("image_name");
          Part image = request.getPart("image");
          Image img = new Image();
          img.setDate(new Date());
          img.setName(imageName);
          img.setUser((User) request.getSession().getAttribute("user"));
          img.setUrl(img.getUser().getUsername() + "/" + UUID.randomUUID());
          imageService.InsertImage(img, image.getInputStream());
          request.getSession().setAttribute("imageList", imageService.getImage(img.getUser().getId()));
          response.sendRedirect(request.getContextPath() + "/home.jsp");
      } else if (type == 2) {    //删除图片
          String ids = request.getParameter("ids");
          String urls = request.getParameter("urls");
          imageService.deleteImgesByIds(ids, urls);
          request.getSession().setAttribute("imageList", imageService.getImage(((User) request.getSession().getAttribute("user")).getId()));
      }
  }

}
