package com.articleapp.servlets;

import com.articleapp.dao.ArticleDaoImpl;
import com.articleapp.model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ArticleServlet", value = "/user/article")
public class ArticleServlet extends HttpServlet {
    ArticleDaoImpl articleDao;

    @Override
    public void init() throws ServletException {
        articleDao=new ArticleDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        List<Article> articles = articleDao.selectMyAllArticles(username);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/article.jsp").forward(req, resp);
    }
}
