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

    <meta property="og:title" content="Smart shop"/>
    <meta property="og:type" content="website"/>
    <meta
            property="og:description"
            content="A joint project to create qualitative site."
    />
    <link rel="icon"
          href="https://ru.seaicons.com/wp-content/uploads/2015/10/Flat-TV-icon.png">
    <link rel="stylesheet" href="/css/checkout.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

    <script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>
    <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react/16.6.3/umd/react.production.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react-dom/16.6.3/umd/react-dom.production.min.js"></script>


    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

    <script type="text/babel" src="/js/checkout.jsx"></script>

    <script src="/js/checkout.js"></script>

</head>
<body>
<header>
    <nav>
        <a href="/" id="logo"><p class="logo">SmartShop</p></a>
        <p>Questions by phone:<br><span class="phone">0 800 800 800</span></p>
    </nav>
</header>
<main>
    <div class="form">
        <h2>Ordering</h2>
        <div id="checkout-form"></div>
    </div>
    <div class="cart-container">
        <h3>Cart</h3>
        <div class="products">
            <div class="product">
                <img src="https://i.allo.ua/media/catalog/product/cache/1/thumbnail/48x48/9df78eab33525d08d6e5fb8d27136e95/1/1/11_451_5_1.jpg" width="64px" height="64px">
                <p class="prod-name">Xiaomi 11T 8/128GB Meteorite Gray</p>
                <div class="input-group">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="minus" data-field="quantity">
                            <i class="fa fa-minus" aria-hidden="true"></i>
                        </button>
                    </div>
                    <input class="input-group-field quantity" min="1" max="1000" type="number" name="quantity" value="1">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="plus" data-field="quantity" >
                            <i class="fa fa-plus" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
                <p class="price">9000$</p>
                <button id="close111">&#10006;</button>
            </div>
            <div class="product">
                <img src="https://i.allo.ua/media/catalog/product/cache/1/thumbnail/48x48/9df78eab33525d08d6e5fb8d27136e95/1/1/11_451_5_1.jpg" width="64px" height="64px">
                <p class="prod-name">Xiaomi 11T 8/128GB Meteorite Gray</p>
                <div class="input-group">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="minus" data-field="quantity1">
                            <i class="fa fa-minus" aria-hidden="true"></i>
                        </button>
                    </div>
                    <input class="input-group-field quantity" min="1" max="1000" type="number" name="quantity1" value="1">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="plus" data-field="quantity1" >
                            <i class="fa fa-plus" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
                <p class="price">9000$</p>
                <button id="close1">&#10006;</button>
            </div>
            <div class="product">
                <img src="https://i.allo.ua/media/catalog/product/cache/1/thumbnail/48x48/9df78eab33525d08d6e5fb8d27136e95/1/1/11_451_5_1.jpg" width="64px" height="64px">
                <p class="prod-name">Xiaomi 11T 8/128GB Meteorite Gray</p>
                <div class="input-group">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="minus" data-field="quantity2">
                            <i class="fa fa-minus" aria-hidden="true"></i>
                        </button>
                    </div>
                    <input class="input-group-field quantity" min="1" max="1000" type="number" name="quantity2" value="1">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="plus" data-field="quantity2" >
                            <i class="fa fa-plus" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
                <p class="price">9000$</p>
                <button id="close11">&#10006;</button>
            </div>
            <div class="product">
                <img src="https://i.allo.ua/media/catalog/product/cache/1/thumbnail/48x48/9df78eab33525d08d6e5fb8d27136e95/1/1/11_451_5_1.jpg" width="64px" height="64px">
                <p class="prod-name">Xiaomi 11T 8/128GB Meteorite Gray</p>
                <div class="input-group">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="minus" data-field="quantity3">
                            <i class="fa fa-minus" aria-hidden="true"></i>
                        </button>
                    </div>
                    <input class="input-group-field quantity" min="1" max="1000" type="number" name="quantity3" value="1">
                    <div class="input-group-button">
                        <button type="button" class="op" data-quantity="plus" data-field="quantity3" >
                            <i class="fa fa-plus" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
                <p class="price">9000$</p>
                <button id="close">&#10006;</button>
            </div>
        </div>
        <div class="sum">
            <p>Sum:</p>
            <p class="total-price">18 000$</p>
        </div>
    </div>
</main>
<footer>
    <div class="copyright">
        <p>2022 © by SmartShop. All rights are reserved</p>
    </div>
</footer>
</body>
</html>