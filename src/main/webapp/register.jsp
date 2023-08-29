<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Register Form</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <style>
    .btnclr{
      font-size: 13px;
      color:black;
      display: initial ;
      justify-content: center;
      align-items: center;
    }
    .container input{
      text-align: center;
    }
  </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
  <br>
  <h2 style="text-align: center">User Register Form</h2>

  <br>
  <div class="row">
    <div class="col-3"></div>
    <div class="col-6">
      <form action="<%=request.getContextPath()%>/register" method="post">

        <div class="form-group">
          <b><label for="name">First Name:</label></b>
          <input type="text" class="form-control" id="name" placeholder="First Name" name="name" required>
        </div>

        <div class="form-group">
          <b><label for="surname">Last Name:</label></b>
          <input type="text" class="form-control" id="surname" placeholder="Last Name" name="surname" required>
        </div>

        <div class="form-group">
          <b><label for="username">User Name:</label></b>
          <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
        </div>

        <div class="form-group">
          <b><label for="password">Password:</label></b>
          <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
        </div>

        <button type="submit" class="btn btn-success btnclr" style="width: 130px; background: linear-gradient(0deg, limegreen, lightgray 90%)">Submit</button><br>
        If you already have an account, just <a href="login.jsp" style="width: 130px;font-family: cursive;font-size: 20px">Login</a>
      </form>
    </div>
    <div class="col-3"></div>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
