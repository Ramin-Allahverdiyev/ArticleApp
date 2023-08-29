<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login Form</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <style>
    .form-container {
      display: flex;

      align-items: center;
    }
  </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
  <h1 style="text-align: center">Login Form</h1>
  <br>
  <br>
  <h4 style="text-align: center; color: red">${loginError}</h4>
  <div class="row">
    <div class="col-3"></div>
    <div class="col-6">
      <form action="<%=request.getContextPath()%>/login" method="post">

        <div class="form-group">
          <b><label for="username">User Name:</label></b>
          <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required style="text-align: center">
        </div>

        <div class="form-group">
          <b><label for="password">Password:</label></b>
          <input type="password" class="form-control" id="password" placeholder="Password" name="password" required style="text-align: center">
        </div>

        <button type="submit" class="btn btn-success" style="width: 130px;background: linear-gradient(0deg, limegreen, lightgray 90%)">Submit</button>
        <a class="btn btn-secondary" href="register.jsp" style="margin: auto;width: 130px;background: linear-gradient(0deg, lightslategray,lightgray 90%)">Signup</a>
      </form>
    </div>
    <div class="col-3"></div>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
