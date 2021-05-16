<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 16/05/2021
  Time: 5:50 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./create-customer">
    Customer EMAIL:<input type="text" id="email" name="email">
    <br/>
    Customer FIRST NAME: <input type="text" id="first" name="first">
    <br/>
    Customer LASTNAME: <input type="text" id="last" name="last">
    <br/>
    Customer AGE: <input type="text" id="age" name="age">
    <br/>
    Customer GENRE: <input type="text" id="genre" name="genre">
    <br/>
    <input type="submit" value="Create Customer!">
</form>
</body>
</html>
