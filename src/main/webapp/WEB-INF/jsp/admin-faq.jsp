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
            content="A project try to to create qualitative site."
    />
    <link rel="icon"
          href="https://ru.seaicons.com/wp-content/uploads/2015/10/Flat-TV-icon.png">

    <link rel="stylesheet" href="/css/general.css">
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/faq.css">
</head>
<body>
<jsp:include page="admin-header.jsp"/>
<main class="main">
    <form action="#" method="post" class="faq-section">
        <button type="submit" class="save-button">Save changes</button>
        <table class="faqs">
            <tr>
                <th style="width: 20%;">Question</th>
                <th>Answer</th>
                <th style="width: 10%;">Delete</th>
            </tr>
            <tr>
                <td><textarea rows="6">Some question that doesn't have matter and something else bla bla?</textarea>
                </td>
                <td><textarea rows="6">Some answer that doesn't have matter and something else bla bla but it a bit longer than question because question is always smaller</textarea>
                </td>
                <td>Delete</td>
            </tr>
            <tr>
                <td><textarea rows="6">Some question that doesn't have matter and something else bla bla?</textarea>
                </td>
                <td><textarea rows="6">Some answer that doesn't have matter and something else bla bla but it a bit longer than question because question is always smaller and something else bla bla but it a bit longer and something</textarea>
                </td>
                <td>Delete</td>
            </tr>
        </table>
        <div class="question-adding">
            <textarea rows="4" placeholder="Your new question..."></textarea><br>
            <textarea rows="6" placeholder="Your answer..."></textarea><br>
            <button type="submit" class="save-button add-button">Add question</button>
        </div>
    </form>
</main>
</body>
</html>