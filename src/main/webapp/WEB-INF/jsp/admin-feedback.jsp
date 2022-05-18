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

    <meta property="og:title" content="Robot Genius"/>
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
    <table class="faqs">
        <tr>
            <th style="width: 10%;">First name</th>
            <th style="width: 10%;">Last name</th>
            <th style="width: 10%;">Email</th>
            <th style="width: 15%;">Subject</th>
            <th style="width: 40%;">Message</th>
            <th style="width: 10%;">Date</th>
            <th style="width: 5%;">Delete</th>
        </tr>
        <c:forEach items="${contacts}" var="contact">
            <c:forEach items="${contact.messages}" var="message">
                <tr>
                    <td>${contact.first_name}</td>
                    <td>${contact.last_name}</td>
                    <td>${contact.email}</td>
                    <td style="text-align: left;">${message.subject}</td>
                    <td style="text-align: left;">${message.message}</td>
                    <td>${message.sent}</td>
                    <td><a href="/admin/feedback/delete/${message.id}" class="btn btn-danger"
                           onclick="if (!confirm('Are you sure you want to delete the message?')) return false;">Delete</a></td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</main>
</body>
</html>