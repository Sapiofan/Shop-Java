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
</head>
<body>
<jsp:include page="admin-header.jsp"/>
<main class="main">
    <form action="#" method="post">
        <div class="search-group">
            <input type="submit" class="add-product" value="Add product">
            <input type="search" class="search-input" placeholder="Find a product by id or name...">
            <input type="submit" class="search-button" value="Search">
        </div>
        <table class="faqs">
            <tr>
                <th style="width: 5%;">Id</th>
                <th style="width: 15%;">Name</th>
                <th style="width: 5%;">Category</th>
                <th style="width: 5%;">Brand</th>
                <th style="width: 10%;">Price</th>
                <th style="width: 5%;">Rating</th>
                <th style="width: 5%;">Available</th>
                <th style="width: 15%;">Payment</th>
                <th style="width: 15%;">Gifts</th>
                <th style="width: 5%;">Discount(%)</th>
                <th style="width: 5%;">Warranty(Months)</th>
                <th style="width: 5%;">Edit</th>
                <th style="width: 5%;">Delete</th>
            </tr>
            <tr>
                <td>1</td>
                <td>Name</td>
                <td>Phones</td>
                <td>Apple</td>
                <td>42400</td>
                <td>4.5</td>
                <td>true</td>
                <td>Visa, Mastercard, cash</td>
                <td>Earphones iPods</td>
                <td>15</td>
                <td>12</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Name</td>
                <td>Phones</td>
                <td>Apple</td>
                <td>42400</td>
                <td>4.5</td>
                <td>true</td>
                <td>Visa, Mastercard, cash</td>
                <td>Earphones iPods</td>
                <td>15</td>
                <td>12</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
        </table>
    </form>
</main>
</body>
</html>