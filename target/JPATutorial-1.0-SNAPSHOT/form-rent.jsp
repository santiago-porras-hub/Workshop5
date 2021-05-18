<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 16/05/2021
  Time: 10:34 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="./create-rent">
    <input type="hidden" id="editionId" name="editionId" value ="<%= request.getParameter("editionId") %>">
    Renting Date: <input type="text" id="rentingDate" name="rentingDate">
    <input type="submit" value="Create rent!">
</form>


</body>
</html>
