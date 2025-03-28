<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!-- Coding By CodingNepal - www.codingnepalweb.com -->
<html>
<head>
  <title>Glassmorphism Login Form | CodingNepal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
</head>
<body>

  <% String message = (String) request.getAttribute("message"); %>
  <%
    if (message == null) {
  %>

  <div class="wrapper">
    <form action method="post">
      <h2>Login</h2>
        <div class="input-field">
        <input type="text" name="username">
        <label>Enter your username</label>
      </div>
      <div class="input-field">
        <input type="password" name="password">
        <label>Enter your password</label>
      </div>
      <div class="forget">
        <label for="remember">
          <input type="checkbox" id="remember">
          <p>Remember me</p>
        </label>
        <a href="#">Forgot password?</a>
      </div>
      <button type="submit">Log In</button>
      <div class="register">
        <p>Don't have an account? <a href="join">Register</a></p>
      </div>
    </form>
  </div>
  <%
  } else {
  %>
  <h1><%= request.getAttribute("message")%></h1>
  <%
    }
  %>
</body>
</html>