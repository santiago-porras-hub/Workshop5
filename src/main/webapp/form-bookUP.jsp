<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/05/2021
  Time: 9:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="./update-book">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
    Book title: <input type="text" id="title" name="title">
    <br />
    Book ISBN: <input type="text" id="isbn" name="isbn">
    <br />
    Book GENRE: <input type="text" id="genre" name="genre">
    <br />
    <input type="submit" value="Update book!">
</form>
</body>
</html>
