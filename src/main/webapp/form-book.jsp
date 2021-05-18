<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./create-book">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
    Book title: <input type="text" id="title" name="title">
    <br />
    Book ISBN: <input type="text" id="isbn" name="isbn">
    <br />
    Book GENRE: <input type="text" id="genre" name="genre">
    <br />
    (Default Edition) Edition DESCRIPTION: <input type="text" id="description" name="description">
    <br/>
    Edition RELEASE YEAR: <input type="text" id="releaseyear" name="releaseyear">
    <br/>
    <input type="submit" value="Create book!">
</form>

</body>
</html>
