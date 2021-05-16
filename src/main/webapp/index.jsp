<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>JSP Tutorial</title>

        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>

        <h1>Library Manager</h1>

        <button onclick="location.href='./form-library.jsp';">Create library</button>
        <button onclick="location.href='./form-author.jsp';">Create author</button>

        <h3>Libraries</h3>

        <table id="librariesTbl">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <h3>Authors</h3>

        <table id="authorsTbl">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Country</th>
                <th># Books</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <h3>Books</h3>
        <table id="booksTbl">
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Isbn</th>
                <th>AuthorId</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <h3>Editions</h3>
        <table id="editionsTbl">
            <thead>
            <tr>
                <th>EditionId</th>
                <th>Description</th>
                <th>Release Year</th>
                <th>BookId</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>


        <script>

            function printTable(elementId, servlet, columns, actions = []) {

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4) {
                        var data = JSON.parse(xhr.responseText);

                        var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];

                        data.map(d => {

                            var newRow = tbodyRef.insertRow();

                            columns.map(c => {
                                var cell = newRow.insertCell();
                                var text = document.createTextNode(d[c]);
                                cell.appendChild(text);
                            });

                            if (actions.includes('delete-author')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Delete author');
                                action.appendChild(text);
                                cell.appendChild(action);

                            }
                            if (actions.includes('delete-edition')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-edition?editionId=' + d['editionId'] + '";');
                                var text = document.createTextNode('Delete edition');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('create-book')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Create book');
                                action.appendChild(text);
                                cell.appendChild(action);
                                printTable(elementId = 'booksTbl', servlet = 'list-books', columns = ['bookId', 'title','isbnId','authorId'],actions = ['create-edition','delete-book']);
                            }

                            if(actions.includes('create-edition')){
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-edition.jsp?bookId=' + d['bookId'] + '";');
                                var text = document.createTextNode('Create Edition');
                                action.appendChild(text);
                                cell.appendChild(action);
                                printTable(elementId = 'editionsTbl', servlet = 'list-editions', columns = ['editionId', 'description','releaseyear','bookId'],actions = ['rent-edition','delete-edition']);
                            }
                        });

                    }
                }
                xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
                xhr.send(null);

            }

            // Printing libraries
            printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name']);

            // Printing authors
            printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name','country', 'numBooks'], actions = ['create-book','delete-author']);

        </script>

    </body>
</html>