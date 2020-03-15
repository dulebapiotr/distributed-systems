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
  <title>City Facts</title>
</head>
<body>
<form action="rest/cityInfo" method="POST">
  <label for="city">Enter city name: </label>
  <input name="city" />

  <br/>
  <input type="submit" value="Submit" />
</form>
</body>
</html>
