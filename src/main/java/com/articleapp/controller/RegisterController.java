package com.articleapp.controller;

import com.articleapp.dao.UserDaoImpl;
import com.articleapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private UserDaoImpl userDao;

    @Override
    public void init(){
        userDao=new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        register(req,resp);
    }
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            user.setPassword(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);


        try {
            userDao.register(user);
            req.getSession().setAttribute("name", name);
            req.getSession().setAttribute("username", username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        resp.sendRedirect("user/article");
    }

}
