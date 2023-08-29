<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>Article APP</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
  <h2 style="text-align: center">List of Articles</h2>
  <div class="container text-center">
    <a href="<%=request.getContextPath()%>/user/article" class="btn btn-success" style="color: black;border-color: whitesmoke;background: linear-gradient(0deg, cornflowerblue, lightgray 80%)">My Articles</a>
    <a href="<%=request.getContextPath()%>/user/article/actions?action=allart" class="btn btn-success" style="color: black;border-color: whitesmoke;background: linear-gradient(0deg, cornflowerblue, lightgray 80%)">All Articles</a>
    <a href="<%=request.getContextPath()%>/user/article/actions?action=new" class="btn btn-success" style="color: black;border-color: whitesmoke;background: linear-gradient(0deg, gold, blanchedalmond 80%)">Add Article</a>
    <hr style="border: 2px solid black;">
  </div>
  <c:forEach var="article" items="${articles}">
  <b><span class="underlined" style="border-bottom: 1px solid black;"><c:out value="${article.title}" /></span></b><br><br>

      <p style="border-style: double;width: 80%;margin: 10px;padding: 10px"><c:out value="${article.articleContext}" /></p>

      <c:if test="${article.username ne sessionScope.username }">
        <b><span class="underlined" style="border-bottom: 1px solid black;">Created by <c:out value="${article.username}" /> on <c:out value="${article.updatedAt}" /></span></b>
    </c:if>
    <c:if test="${article.username eq sessionScope.username }">
        <b><span class="underlined" style="border-bottom: 1px solid black;"><c:out value="${article.updatedAt}" /></span></b>
    </c:if>
    <c:if test="${article.username eq sessionScope.username }">
        <div style="display: inline-block;margin-left: 50%;">
        <a href="<%=request.getContextPath()%>/user/article/actions?action=edit&id=<c:out value='${article.id}'/>" class="btn btn-success" style="color: black;border-color: whitesmoke;background: linear-gradient(0deg, darkorange, gold 80%)">Edit</a>
        &nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/user/article/actions?action=delete&id=<c:out value='${article.id}'/>" class="btn btn-success" style="color: black;border-color: whitesmoke;background: linear-gradient(0deg, orangered, tomato 80%)">Delete</a>
        </div>
    </c:if>
  <hr style="border: 1px solid black;">
    <br>
    <br>
  </c:forEach>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
