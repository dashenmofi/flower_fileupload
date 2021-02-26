package com.mofei.controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author mofei
 * @create 2021-02-23:53
 */
@WebServlet("/FlowerDownload")
public class FlowerDownload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1，把文件从服务器读过来
        String filename = req.getParameter("filename");
        //获得服务器的目录
        String realPath = req.getServletContext().getRealPath("/imgs");
        File file = new File(realPath + "/" + filename);
        FileInputStream input = new FileInputStream(file);

        //2,把读取的文件写到本地
        ServletOutputStream output = resp.getOutputStream();

        //告诉浏览器下载的文件不需要解析 直接下载到本地即可
        resp.setContentLength((int)file.length());
        resp.setContentType(req.getParameter("filetype"));
        resp.setHeader("Content-Disposition","attachment;filename="+filename);

        IOUtils.copy(input,output);

        output.close();
        input.close();

    }
}
