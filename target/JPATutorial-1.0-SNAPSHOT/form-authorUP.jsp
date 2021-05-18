<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/05/2021
  Time: 8:28 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="./update-author">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    Author name: <input type="text" id="name" name="name">
    <br>
    Country: <input type="text" id="country" name="country">
    <input type="submit" value="Update author!">

</form>



</body>
</html>
