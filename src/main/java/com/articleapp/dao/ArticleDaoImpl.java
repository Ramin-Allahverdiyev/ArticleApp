package com.articleapp.dao;

import com.articleapp.model.Article;
import com.articleapp.utils.ConnectionUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl extends HttpServlet implements ArticleDao{
    @Override
    public void insertArticle(Article article) {
        String INSERT_TODO_SQL = "INSERT INTO article (title, article_context, username) VALUES (?, ?, ?)";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_TODO_SQL);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getArticleContext());
            statement.setString(3, article.getUsername());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateArticle(Article article) {
        String UPDATE_ARTICLE_SQL = "UPDATE article SET title = ?, article_context = ? WHERE id = ?;";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ARTICLE_SQL);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getArticleContext());
            statement.setInt(3, article.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteArticle(int id) {
        String DELETE_ARTICLE_SQL = "DELETE FROM article WHERE id = ?;";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ARTICLE_SQL);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Article> selectAllArticles() {
        String SELECT_ALL_ARTICLES_SQL = "SELECT id, title, article_context, updated_at, username FROM article ORDER BY updated_at desc";

        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ARTICLES_SQL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticleContext(resultSet.getString("article_context"));
                Timestamp date=resultSet.getTimestamp("updated_at");
                LocalDateTime localDateTime = date.toLocalDateTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDateTime=localDateTime.format(formatter);
                article.setUpdatedAt(formattedDateTime);
                article.setUsername(resultSet.getString("username"));
                articles.add(article);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return articles;
    }

    @Override
    public List<Article> selectMyAllArticles(String username) {
        String SELECT_ALL_ARTICLES_SQL = "SELECT id, title, article_context, updated_at, username FROM article WHERE username = ? ORDER BY updated_at desc";

        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ARTICLES_SQL);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticleContext(resultSet.getString("article_context"));
                Timestamp date=resultSet.getTimestamp("updated_at");
                LocalDateTime localDateTime = date.toLocalDateTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDateTime=localDateTime.format(formatter);
                article.setUpdatedAt(formattedDateTime);
                article.setUsername(resultSet.getString("username"));

                articles.add(article);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return articles;
    }

    @Override
    public Article getArticle(int id) {
        String GET_ARTICLE_SQL = "SELECT id, title, article_context, updated_at,username FROM article WHERE id = ?";

        Article article = null;

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ARTICLE_SQL);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticleContext(resultSet.getString("article_context"));
                Timestamp date=resultSet.getTimestamp("updated_at");
                LocalDateTime localDateTime = date.toLocalDateTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDateTime=localDateTime.format(formatter);
                article.setUpdatedAt(formattedDateTime);
                article.setUsername(resultSet.getString("username"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return article;
    }
}
