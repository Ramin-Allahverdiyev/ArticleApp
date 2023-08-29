package com.articleapp.controller;

import com.articleapp.dao.ArticleDaoImpl;
import com.articleapp.model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ArticleController", value ="/user/article/actions")
public class ArticleController extends HttpServlet {
    private ArticleDaoImpl articleDao;

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
        String action = req.getParameter("action");

        if (action == null) {
            req.getRequestDispatcher("/article-form.jsp").forward(req, resp);
        } else {
            try {
                switch (action) {
                    case "new":
                        req.getRequestDispatcher("/article-form.jsp").forward(req, resp);
                        break;
                    case "insert":
                        insertArticle(req, resp);
                        break;
                    case "allart":
                        selectAllOfArticles(req,resp);
                        break;
                    case "edit":
                        showEditArticle(req, resp);
                        break;
                    case "update":
                        updateArticle(req, resp);
                        break;
                    case "delete":
                        deleteArticle(req, resp);
                        break;
                    default:
                        resp.sendRedirect("login.jsp");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void insertArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = (String) req.getSession().getAttribute("username");
        String articleTitle = req.getParameter("articleTitle");
        String articleContext = req.getParameter("articleContext");

        Article article = new Article();
        article.setArticleContext(articleContext);
        article.setTitle(articleTitle);
        article.setUsername(username);

        articleDao.insertArticle(article);
        resp.sendRedirect(req.getContextPath() + "/user/article");
    }

    private void showEditArticle (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Article article = articleDao.getArticle(id);
        req.setAttribute("article", article);
        req.getRequestDispatcher("/article-form.jsp").forward(req, resp);
    }

    private void updateArticle (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String articleTitle = req.getParameter("articleTitle");
        String articleContext = req.getParameter("articleContext");

        Article article = articleDao.getArticle(id);
        article.setTitle(articleTitle);
        article.setArticleContext(articleContext);

        articleDao.updateArticle(article);
        resp.sendRedirect(req.getContextPath() + "/user/article");
    }

    private void deleteArticle (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        articleDao.deleteArticle(id);
        resp.sendRedirect(req.getContextPath() + "/user/article");
    }

    private void selectAllOfArticles (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Article> articles = articleDao.selectAllArticles();
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/article.jsp").forward(req, resp);
    }


}
