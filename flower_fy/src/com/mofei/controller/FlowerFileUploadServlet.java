package com.mofei.controller;

import com.mofei.pojo.Flower;
import com.mofei.service.FlowerService;
import com.mofei.service.impl.FlowerServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author mofei
 * @create 2021-02-12:56
 */
@WebServlet("/FlowerFileUploadServlet")
public class FlowerFileUploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理中文文件名乱码问题
        req.setCharacterEncoding("utf-8");
        //A:获得文件上传工厂对象
        FileItemFactory factory = new DiskFileItemFactory();
        //获得文件上传组件对象
        ServletFileUpload upload = new ServletFileUpload(factory);

        Flower flower = new Flower();
        try {
            //获得前台表单项数据并且保存到集合中
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem fileItem : list) {
                //System.out.println(fileItem.getName() + "--" + fileItem.getContentType() + "--" + fileItem.getFieldName() + "--" + fileItem.getSize() + "--" + fileItem.isFormField());

                //判断是否是文件表单项
                if (!fileItem.isFormField()) {
                    //证明是文件表单项
                    //判断当前文件的大小
//                    if (fileItem.getSize() > 20*1024) {
//                        req.setAttribute("msg","文件最大为20k");
//                        req.getRequestDispatcher("/add.jsp").forward(req,resp);
//                        return;
//                    }

                    String uuid = UUID.randomUUID().toString();
                    String substring = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));

                    //判断当前文件类型
                    if(!(".jpg".equals(substring) || ".png".equals(substring) || ".gif".equals(substring))){
                        req.setAttribute("msg","请输入*.jpg,*.png,*.gif类型的文件");
                        req.getRequestDispatcher("/add.jsp").forward(req,resp);
                        return;
                    }
                    String filename = uuid + substring;
                    flower.setFilename(filename);
                    flower.setFiletype(fileItem.getContentType());

                    //获得服务器的目录
                    String realPath = req.getServletContext().getRealPath("/imgs");
                    //如果当前目录不存在，会自动建立
                    File file = new File(realPath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    //进行文件的上传即可
                    fileItem.write(new File(file, filename));
                } else {
                    //证明是表单项是普通表单项
                    if ("name".equals(fileItem.getFieldName())){
                        String name = fileItem.getString("utf-8");
                        flower.setName(name);
                    }
                    if ("price".equals(fileItem.getFieldName())){
                        Float price = Float.parseFloat(fileItem.getString("utf-8"));
                        flower.setPrice(price);
                    }
                    if ("production".equals(fileItem.getFieldName())){
                        String production = fileItem.getString("utf-8");
                        flower.setProduction(production);
                    }
                }
            }
            //执行添加操作
            FlowerService flowerService = new FlowerServiceImpl();
            Integer save = flowerService.save(flower);
            if (save > 0){
                resp.sendRedirect(req.getContextPath() + "/FlowerSelectServlet");
            } else {
                req.setAttribute("msg","添加失败");
                req.getRequestDispatcher("/add.jsp").forward(req,resp);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
