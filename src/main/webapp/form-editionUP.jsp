<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 18/05/2021
  Time: 10:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./update-edition">
    <input type="hidden" id="editionId" name="editionId" value="<%= request.getParameter("editionId") %>">
    Edition DESCRIPTION: <input type="text" id="description" name="description">
    <br/>
    Edition RELEASE YEAR: <input type="text" id="releaseYear" name="releaseYear">
    <br/>
    <input type="submit" value="Update edition!">
</form>

</body>
</html>
