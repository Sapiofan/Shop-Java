<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Smart shop | Technics</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <meta
            name="description"
            content="A project to train with Spring and React frameworks"
    />

    <meta property="og:title" content="Smartshop"/>
    <meta property="og:type" content="website"/>
    <meta
            property="og:description"
            content="A project to try to create qualitative site."
    />
    <link rel="icon"
          href="https://ru.seaicons.com/wp-content/uploads/2015/10/Flat-TV-icon.png">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" href="/css/general.css">
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<jsp:include page="admin-header.jsp"/>
<main class="main">
    <form action="#" method="post">
        <table class="faqs">
            <tr>
                <th style="width: 10%;">First name</th>
                <th style="width: 10%;">Last name</th>
                <th style="width: 15%;">Email</th>
                <th style="width: 15%;">Phone</th>
                <th style="width: 15%;">Position</th>
                <th style="width: 20%;">Link to resume</th>
                <th style="width: 10%;">Date</th>
                <th style="width: 5%;">Delete</th>
            </tr>
            <c:forEach items="${careers}" var="career">
                <tr>
                    <td>${career.first_name}</td>
                    <td>${career.last_name}</td>
                    <td>${career.email}</td>
                    <td>${career.phone}</td>
                    <td>${career.position}</td>
                    <td>${career.link}</td>
                    <td>${career.sent}</td>
                    <td><a href="/admin/career/delete/${career.id}" class="btn btn-danger"
                           onclick="if (!confirm('Are you sure you want to delete the record?')) return false;">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</main>
</body>
</html>