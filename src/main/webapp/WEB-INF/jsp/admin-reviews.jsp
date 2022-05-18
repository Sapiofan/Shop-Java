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
    <form action="/admin/reviews" method="post">
        <div class="search-group" style="width: 30%">
            <input type="search" name="search" class="search-input" placeholder="Find a review by user email or product id...">
            <input type="submit" class="search-button" value="Search">
        </div>
        <table class="faqs">
            <tr>
                <th style="width: 10%;">Name</th>
                <th style="width: 5%;">Rate</th>
                <th style="width: 15%;">Date</th>
                <th style="width: 10%;">Recommended</th>
                <th style="width: 55%;">Review</th>
                <th style="width: 5%;">Delete</th>
            </tr>
            <c:forEach items="${reviews}" var="review">
                <tr>
                    <td>${review.user.name}</td>
                    <td>${review.rating}</td>
                    <td>${review.date}</td>
                    <td>${review.recommended}</td>
                    <td>${review.review}</td>
                    <td><a href="/admin/reviews/delete/${review.id}" class="btn btn-danger"
                           onclick="if (!confirm('Are you sure you want to delete the review?')) return false;">Delete</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td>Name</td>
                <td>4</td>
                <td>04.10.2022 17:22:15</td>
                <td>true</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas porttitor
                    nec est sed auctor. Cras ultrices blandit sapien et tempor. Praesent ipsum lectus, tempus at
                    bibendum
                    nec, sollicitudin id arcu. Nam bibendum eget lacus at imperdiet. Quisque ac blandit felis.
                    Suspendisse
                    aliquam lacus et arcu sagittis,
                    vel vehicula odio imperdiet. Nunc a lorem vehicula, convallis libero ut, vestibulum tellus.
                </td>
                <td>Delete</td>
            </tr>
        </table>
    </form>
</main>
</body>
</html>