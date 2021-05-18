<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/05/2021
  Time: 8:46 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./update-customer">
    <input type="hidden" id="email" name="email" value ="<%= request.getParameter("email") %>">
    <br/>
    Customer FIRST NAME: <input type="text" id="first_name" name="first_name">
    <br/>
    Customer LASTNAME: <input type="text" id="last_name" name="last_name">
    <br/>
    Customer AGE: <input type="text" id="age" name="age">
    <br/>
    Customer GENRE: <input type="text" id="genre" name="genre">
    <br/>
    <input type="submit" value="Update Customer!">
</form>

</body>
</html>
