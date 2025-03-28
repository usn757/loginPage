<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 28.
  Time: 오후 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>가입? (평문 저장하는데...)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
</head>
<body>

<div class="wrapper">
    <form action method="post">
        <h2>Sign up</h2>
        <div class="input-field">
            <input type="text" name="username">
            <label>input your username</label>
        </div>
        <div class="input-field">
            <input type="password" name="password">
            <label>input your password</label>
        </div>

        <button>register</button>
    </form>
</div>
</body>
</html>