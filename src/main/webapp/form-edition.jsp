<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 15/05/2021
  Time: 6:42 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edition</title>
</head>
<body>

<form action="./create-edition">
    <input type="hidden" id="bookId" name="bookId" value="<%= request.getParameter("bookId") %>">
    Edition DESCRIPTION: <input type="text" id="description" name="description">
    <br/>
    Edition RELEASE YEAR: <input type="text" id="releaseyear" name="releaseyear">
    <br/>
    <input type="submit" value="Create edition!">
</form>
</body>
</html>
