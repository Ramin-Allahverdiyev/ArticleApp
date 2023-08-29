<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Article APP</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
  <h2 style="text-align: center">Welcome to Article APP</h2>
  <div class="container text-center">
    <a class="btn btn-success" href="login.jsp" style="background: linear-gradient(0deg, green, gray 90%)">Login</a>
    <a class="btn btn-secondary" href="register.jsp" style="background: linear-gradient(0deg, lightslategray,gray 90%)">Signup</a>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>