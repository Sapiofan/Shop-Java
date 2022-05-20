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
    <form action="/admin/addProduct" method="post">
        <div class="big-group">
            <div class="input-group">
                <p>Name</p>
                <input name="name" type="text" required>
            </div>
            <div class="input-group">
                <p>Category</p>
                <select name="category" class="categories" id="categories">
                    <option value="Phones" selected>Phones</option>
                    <option value="Laptops">Laptops</option>
                    <option value="Watches">Watches</option>
                </select>
            </div>
            <div class="input-group">
                <p>Brand</p>
                <input name="brand" type="text" required>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <p>Price</p>
                <input name="price" type="text" required>
            </div>
            <div class="input-group">
                <p>Payment</p>
                <input name="payment" type="text" required>
            </div>
            <div class="input-group">
                <p>Warranty</p>
                <input name="warranty" type="number" required>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <label class="container1">
                    <input name="available" type="checkbox">
                    <span class="checkmark"></span>
                    Is available?
                </label>
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <p>Gifts</p>
                <input name="gifts" value="none" type="text">
            </div>
            <div class="input-group">
                <p>Discount (%)</p>
                <input name="discount" value="0" type="number">
            </div>
        </div>
        <div class="big-group">
            <div class="input-group">
                <p>Image link</p>
                <input name="link" type="text" style="width: 34vw" required>
            </div>
        </div>
        <button onclick="history.back()" class="history-back">Back</button>
        <button type="submit" class="add-product-button">Continue</button>
    </form>
</main>
</body>
</html>