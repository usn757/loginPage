<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <% String message = (String) request.getAttribute("message"); %>
  <%
      if (message == null) {
  %>

  <h1>Login</h1>
  <form action method="post">
    <label>
      username : <input type="text" name="username" /><br/>
    </label>
    <label>
      password : <input type="password" name="password" /><br/>
    </label>
    <button>login</button>
  </form>
  <header>
    <nav>
      <ul>
        <li>
          <a href="join">가입하쉴?</a>
        </li>
      </ul>
    </nav>
  </header>

  <%
    } else {
  %>
  <h1><%= request.getAttribute("message")%></h1>
  <%
    }
  %>

</body>
</html>