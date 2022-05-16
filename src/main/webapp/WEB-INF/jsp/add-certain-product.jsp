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

    <link rel="stylesheet" href="/css/general.css">
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/add-product.css">
</head>
<body>
<jsp:include page="admin-header.jsp"/>
<main class="main">
    <form action="#" method="post">
        <div class="big-group">
            <div class="input-group">
                <p>Ram</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Color</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Cores</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Device type</p>
                <input type="text" required>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <p>Ram</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Color</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Cores</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Device type</p>
                <input type="text" required>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <p>Ram</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Color</p>
                <input type="text" required>
            </div>
            <div class="check-group">
                <label class="container1">
                    <input type="checkbox">
                    <span class="checkmark"></span>
                    Is available?
                </label>
            </div>
            <div class="input-group">
                <p>Device type</p>
                <input type="text" required>
            </div>
        </div>
        <button onclick="history.back()" class="history-back">Back</button>
        <button type="submit" class="add-product-button">Save</button>
    </form>
</main>
</body>
</html>