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
                <p>Name</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Category</p>
                <select class="categories" id="categories">
                    <option value="in-store-sales" selected>Phones</option>
                    <option value="store-leadership">Laptops</option>
                    <option value="in-store-operations">Watches</option>
                </select>
            </div>
            <div class="input-group">
                <p>Brand</p>
                <input type="text" required>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <p>Price</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Payment</p>
                <input type="text" required>
            </div>
            <div class="input-group">
                <p>Warranty</p>
                <input type="number" required>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <label class="container1">
                    <input type="checkbox">
                    <span class="checkmark"></span>
                    Is available?
                </label>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <p>Gifts</p>
                <input type="text">
            </div>
            <div class="input-group">
                <p>Discounts (%)</p>
                <input type="number">
            </div>
        </div>
        <button onclick="history.back()" class="history-back">Back</button>
        <button type="submit" class="add-product-button">Continue</button>
    </form>
</main>
</body>
</html>