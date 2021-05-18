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

        <button onclick="location.href='./form-library.jsp';">Create Library</button>
        <button onclick="location.href='./form-author.jsp';">Create Author</button>
        <button onclick="location.href='./form-customer.jsp';">Create Customer</button>

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

        <h3>Customers</h3>
        <table id="customersTbl">
            <thead>
            <tr>
                <th>Email</th>
                <th>Full Name</th>
                <th>Genre</th>
                <th>Age</th>
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
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <h3>Rents</h3>
        <table id="rentsTbl">
            <thead>
            <tr>
                <th>RentId</th>
                <th>Email</th>
                <th>Renting Date</th>
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

                            if (actions.includes('create-book')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Create book');
                                action.appendChild(text);
                                cell.appendChild(action);


                            }

                            if (actions.includes('create-rent')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-rent.jsp?email=' + d['email'] + '";');
                                var text = document.createTextNode('Create rent');
                                action.appendChild(text);
                                cell.appendChild(action);


                            }
                            if(actions.includes('create-edition')){
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-edition.jsp?bookId=' + d['bookId'] + '";');
                                var text = document.createTextNode('Create Edition');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }
                            if (actions.includes('delete-author')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Delete author');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('delete-customer')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-customer?email=' + d['email'] + '";');
                                var text = document.createTextNode('Delete customer');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('delete-book')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-book?bookId=' + d['bookId'] + '";');
                                var text = document.createTextNode('Delete Book');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('delete-library')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-library?libraryId=' + d['libraryId'] + '";');
                                var text = document.createTextNode('Delete Library');
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

                            if (actions.includes('update-author')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-authorUP.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Update Author');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('update-customer')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-customerUP.jsp?email=' + d['email'] + '";');
                                var text = document.createTextNode('Update Customer');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('update-book')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-bookUP.jsp?bookId=' + d['bookId'] + '";');
                                var text = document.createTextNode('Update Book');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('update-library')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-libraryUP.jsp?libraryId=' + d['libraryId'] + '";');
                                var text = document.createTextNode('Update Library');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                        });

                    }
                }
                xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
                xhr.send(null);

            }

            // Printing libraries
            printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name'], actions =['delete-library','update-library']);

            //Printing Books
            printTable(elementId = 'booksTbl', servlet = 'list-books', columns = ['bookId', 'title','isbnId','authorId'],actions = ['create-edition','delete-book','update-book']);
            // Printing authors
            printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name','country', 'numBooks'], actions = ['create-book','delete-author','update-author']);

            // Printing Customers
            printTable(elementId = 'customersTbl', servlet = 'list-customers', columns = ['email', 'fullName','genre', 'age'], actions = ['delete-customer','update-customer']);

            //Printing Rents
            printTable(elementId = 'rentsTbl', servlet = 'list-rents', columns = ['rentId', 'email','rentingDate']);

            //Printing Editions
           printTable(elementId = 'editionsTbl', servlet = 'list-editions', columns = ['editionId', 'description','releaseYear'],actions = ['rent-edition','delete-edition']);

        </script>

    </body>
</html>