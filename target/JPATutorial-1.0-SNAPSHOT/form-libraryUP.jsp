<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/05/2021
  Time: 9:20 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="./update-library">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">
    Library name: <input type="text" id="name" name="name">
    <input type="submit" value="Update library!">
</form>
</body>
</html>
