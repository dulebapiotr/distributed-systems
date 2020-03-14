<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 12.03.2020
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<form action="rest/todos" method="POST">
  <label for="id">ID</label>
  <input name="id" />
  <br/>
  <label for="summary">Summary</label>
  <input name="summary" />
  <br/>
  Description:
  <TEXTAREA NAME="description" COLS=40 ROWS=6></TEXTAREA>
  <br/>
  <input type="submit" value="Submit" />
</form>
</body>
</html>
