package com.mofei.controller;

import com.mofei.pojo.Flower;
import com.mofei.service.FlowerService;
import com.mofei.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author mofei
 * @create 2021-02-23:33
 */
@WebServlet("/FlowerSelectServlet")
public class FlowerSelectServlet extends HttpServlet {
    FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flower> flowers = flowerService.find();
        req.setAttribute("flowers",flowers);
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}
