<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="/css/filters.css">
    <link rel="stylesheet" href="/css/general.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<header>
    <nav class="nav" id="nav">
        <a href="/" id="logo"><p class="logo">SmartShop</p></a>
        <button class="mobile-icon" id="mobile-icon">
            <a href="javascript:void(0);" class="icon">&#9776;</a>
        </button>
        <div class="navigation" id="navigation">
            <a data-langkey="Nav-Our-Work" href="#home">Home</a>
            <!-- <a data-langkey="Nav-Our-Work" href="#categories">Categories</a> -->
            <div class="dropdown">
                <button class="dropbtn">Categories</button>
                <div class="dropdown-content">
                    <a href="#">Computers</a>
                    <a href="#">Phones</a>
                    <a href="#">Tablets</a>
                    <a href="#">Watches</a>
                    <a href="#">Discounts</a>
                    <a href="#">Drones</a>
                </div>
            </div>
            <a data-langkey="Nav-The-Team" href="#about">About</a>
            <a data-langkey="Nav-The-Process" href="#help">Help</a>
            <a data-langkey="Nav-Contact" href="#contact_us">Contact</a>
        </div>
        <div class="signs">
            <div id="search-sign" class="sign">
                <div id="search-wrapper">
                    <input type="text" value="${searchKey}" id="search" autocomplete="off" placeholder="Search device..." />
                    <div id="close-icon"></div>
                </div>
            </div>
            <div class="sign">
                <button onclick="document.getElementById('registration').style.display='block'"
                        class="user"><img src="img/user.png" style="width: 36px; height: 36px;"></button>
            </div>
            <div class="sign">
                <button onclick="document.getElementById('likes').style.display='block'"
                        class="likes">
                    <img src="img/heart (2).png" style="width: 36px; height: 36px;">
                    <span class="wishlist-count">2</span>
                </button>
            </div>
            <div class="sign" id="cart">
                <nav id="main-nav">
                    <a class="cart-button" href="#">
                        <span class="bag-count">3</span>
                        <span class="bag-icon"></span>
                    </a>
                </nav>
            </div>
        </div>
        <!-- <div id='languages'>
            <button id="en" onclick="changePlaceholder()" class='language active' data-lang='britain'>en
            </button>
            <button class='language' onclick="changePlaceholder()" data-lang='ukraine'>ua</button>
        </div> -->
    </nav>
    <div id="registration" class="modal">
        <form class="modal-content" action="#">
            <div class="container">
                <!-- <span onclick="document.getElementById('registration').style.display='none'" class="close">&times;</span> -->
                <button class="up-button" onclick="document.getElementById('registration').style.display='none';
                    document.getElementById('login').style.display='block'">Sign In</button>
                <button class="up-button active">Sign Up</button>
                <input type="email" class="email" placeholder="Enter Email" name="email" required>
                <input type="password" class="password" placeholder="Enter Password" name="psw" required>
                <input type="password" class="password" placeholder="Repeat Password" name="psw-repeat" required>
                <div class="clearfix">
                    <button type="submit" class="signupbtn">Sign Up</button>
                </div>
                <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Conditions</a>.</p>
            </div>
        </form>
    </div>
    <div id="login" class="modal">
        <form class="modal-content" action="#">
            <div class="container">
                <!-- <span onclick="document.getElementById('login').style.display='none'" class="close">&times;</span> -->
                <button class="up-button active">Sign In</button>
                <button class="up-button" onclick="document.getElementById('registration').style.display='block';
                    document.getElementById('login').style.display='none'">Sign Up</button>
                <input class="email" type="email" placeholder="Enter Email" name="email" required>
                <input class="password" type="password" placeholder="Enter Password" name="psw" required>
                <div class="clearfix">
                    <button type="submit" class="signupbtn">Sign In</button>
                </div>
            </div>
        </form>
    </div>
    <div id="likes" class="modal-likes">
        <form class="likes-content" action="#">
            <div class="container-likes">
                <span onclick="document.getElementById('likes').style.display='none'" class="close">&times;</span>
                <h2>Wishlist</h2>
                <div class="wishlist">
                    <div class="wishlist-product">
                        <a href="#"><img width="150px" height="150px" src="https://static.wixstatic.com/media/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.webp"></a>
                        <a href="#">
                            <div class="product-description">
                                <p class="wish-product-name">Samsung Galaxy S21 Ultra 12/128GB Phantom Black</p>
                                <p class="wish-price">14.45$</p>
                                <div class="Stars" style="--rating: 3.5;"></div>
                            </div>
                        </a>
                        <button class="heart">&#10084;</button>
                    </div>
                    <div class="wishlist-product">
                        <a href="#"><img width="150px" height="150px" src="https://static.wixstatic.com/media/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.webp"></a>
                        <a href="#">
                            <div class="product-description">
                                <p class="wish-product-name">Samsung Galaxy S21 Ultra 12/128GB Phantom Black</p>
                                <p class="wish-price">14.45$</p>
                                <div class="Stars" style="--rating: 3.5;"></div>
                            </div>
                        </a>
                        <button class="heart">&#10084;</button>
                    </div>
                    <div class="wishlist-product">
                        <a href="#"><img width="150px" height="150px" src="https://static.wixstatic.com/media/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.webp"></a>
                        <a href="#">
                            <div class="product-description">
                                <p class="wish-product-name">Samsung Galaxy S21 Ultra 12/128GB Phantom Black</p>
                                <p class="wish-price">14.45$</p>
                                <div class="Stars" style="--rating: 3.5;"></div>
                            </div>
                        </a>
                        <button class="heart">&#10084;</button>
                    </div>
                </div>
                <div class="clearfix">
                    <button type="submit" class="clean-button">Clear wishlist</button>
                </div>
            </div>
        </form>
    </div>
    <aside id="menu">
        <div class="menu-logo">
            <p>SmartShop</p>
        </div>
        <div class="menu-choice">
            <a href="#" onclick="document.getElementById('registration').style.display='block'">
                <div class="menu-item menu-user">
                    <img src="img/user-2.svg" style="width: 26px; height: 26px; margin-left: 2px;">
                    <p>Log in profile</p>
                </div>
            </a>
            <a href="#" onclick="document.getElementById('likes').style.display='block'">
                <div class="menu-item">
                    <img src="img/heart-1.png" style="width: 30px; height: 30px;">
                    <p>Favorites</p>
                </div>
            </a>
            <a href="#home">
                <div class="menu-item">
                    <img src="img/home.svg" style="width: 30px; height: 30px;">
                    <p>Home</p>
                </div>
            </a>
            <div id="cat-id">
                <div class="menu-item">
                    <div class="menu-container">
                        <div class="cat-container" id="cat-container">
                            <img src="img/application.png" style="width: 30px; height: 30px;">
                            <p class="menu-coll">Categories</p>
                        </div>
                        <ul class="menu-category" id="menu-category">
                            <a href="/computers">Computers</a>
                            <a href="/phones">Phones</a>
                            <a href="#">Tablets</a>
                            <a href="/watches">Watches</a>
                            <a href="#">Discounts</a>
                            <a href="#">Drones</a>
                        </ul>
                    </div>
                </div>
            </div>
            <a href="#about">
                <div class="menu-item">
                    <img src="img/info.png" style="width: 30px; height: 30px;">
                    <p>About</p>
                </div>
            </a>
            <a href="#help">
                <div class="menu-item">
                    <img src="img/communication.png" style="width: 30px; height: 30px;">
                    <p>Help</p>
                </div>
            </a>
        </div>
    </aside>
    <div id="menu-curtain"></div>
    <aside id="sidebar-cart">
        <main>
            <a href="#" class="close-button"><span class="close-icon">X</span></a>
            <h2>Shopping Bag <span class="count">2</span></h2>
            <ul class="products">
                <li class="product">
                    <a href="#" class="product-link">
                                <span class="product-image">
                                    <img src="https://via.placeholder.com/75x50/ffffff/cccccc?text=PHOTO" alt="Product Photo">
                                </span>
                        <span class="product-details">
                                    <h3>Very Cool Product One</h3>
                                    <span class="qty-price">
                                        <span class="qty">
                                            <button class="minus-button" id="minus-button-1">-</button>
                                            <input type="number" id="qty-input-1" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                                            <button class="plus-button" id="plus-button-1">+</button>
                                            <input type="hidden" name="item-price" id="item-price-1" value="12.00">
                                        </span>
                                        <span class="price">$16.00</span>
                                    </span>
                                </span>
                    </a>
                    <a href="#remove" class="remove-button"><span class="remove-icon">X</span></a>
                </li>
                <li class="product">
                    <a href="#" class="product-link">
                                <span class="product-image">
                                    <img src="https://via.placeholder.com/75x50/ffffff/cccccc?text=PHOTO" alt="Product Photo">
                                </span>
                        <span class="product-details">
                                    <h3>Very Cool Product Two with Long Title</h3>
                                    <span class="qty-price">
                                        <span class="qty">
                                            <button class="minus-button" id="minus-button-2">-</button>
                                            <input type="number" id="qty-input-2" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                                            <button class="plus-button" id="plus-button-2">+</button>
                                            <input type="hidden" name="item-price" id="item-price-2" value="12.00">
                                        </span>
                                        <span class="price">$28.00</span>
                                    </span>
                                </span>
                    </a>
                    <a href="#remove" class="remove-button"><span class="remove-icon">X</span></a>
                </li>
                <li class="product">
                    <a href="#" class="product-link">
                                <span class="product-image">
                                    <img src="https://via.placeholder.com/75x50/ffffff/cccccc?text=PHOTO" alt="Product Photo">
                                </span>
                        <span class="product-details">
                                    <h3>Very Cool Product Three</h3>
                                    <span class="qty-price">
                                        <span class="qty">
                                            <form action="#" name="qty-form" id="qty-form-1">
                                                <button class="minus-button" id="minus-button-3">-</button>
                                                <input type="number" id="qty-input-3" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                                                <button class="plus-button" id="plus-button-3">+</button>
                                                <input type="hidden" name="item-price" id="item-price-3" value="12.00">
                                            </form>
                                        </span>
                                        <span class="price">$12.00</span>
                                    </span>
                                </span>
                    </a>
                    <a href="#remove" class="remove-button"><span class="remove-icon">X</span></a>
                </li>
            </ul>
            <div class="totals">
                <div class="subtotal">
                    <span class="label">Subtotal:</span> <span class="amount">$54.00</span>
                </div>
            </div>
            <div class="action-buttons">
                <a class="checkout-button" href="#">Checkout</a>
            </div>
        </main>
    </aside>
    <div id="sidebar-cart-curtain"></div>
</header>
<main class="main">
    <h1>Tablets</h1>
    <article>
        <div class="aside" id="filters">
            <div class="head-filters">
                <p>Filters</p>
                <span onclick="document.getElementById('filters').style.display='none';
                        document.body.style.overflowY = 'auto';" class="close close-f">&times;</span>
                <hr>
            </div>
            <form action="/filters" method="post" class="filters-blocks">
                <div id="price" class="dropdown-check-list">
                    <span class="anchor">Price</span>
                    <div class="wrapper">
                        <div class="price-input">
                            <div class="field">
                                <input type="number" class="input-min" value="0">
                            </div>
                            <div class="separator">-</div>
                            <div class="field">
                                <input type="number" class="input-max" value="10000">
                            </div>
                        </div>
                        <div class="slider">
                            <div class="progress"></div>
                        </div>
                        <div class="range-input">
                            <input type="range" class="range-min" min="0" max="10000" value="0" step="100">
                            <input type="range" class="range-max" min="0" max="10000" value="10000" step="100">
                        </div>
                    </div>
                </div>
                <c:forEach var="filter" items="${filtersKeys}">
                    <div id="${filter}" class="dropdown-check-list">
                        <span class="anchor"><c:out value="${filter}"/></span>
                        <ul class="items">
                            <c:forEach items="${filters[filter]}" var="item">
                                <li>
                                    <label class="container1">${item}
<%--                                        <c:forEach items="${filterName}" var="name">--%>
<%--                                            <c:choose>--%>
<%--                                                <c:when test="${name == item}">--%>
<%--                                                    <input name="filter-name" type="checkbox" checked>--%>
<%--                                                    <span class="checkmark"></span>--%>
<%--                                                </c:when>--%>
<%--                                                <c:when test="${loop.last && name != item}">--%>
                                                    <input name="filter-name" type="checkbox">
                                                    <span class="checkmark"></span>
<%--                                                </c:when>--%>
<%--                                            </c:choose>--%>
<%--                                        </c:forEach>--%>
                                    </label>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <br>
                </c:forEach>

<%--                <c:forEach var="value" items="${filters.values()}">--%>
<%--                    Map value: ${value}<br/>--%>
<%--                </c:forEach>--%>

<%--                        <label class="container1">Apple--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">Samsung--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">Asus--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">Acer--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">HP--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">Dell--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                <br>--%>
<%--                <div id="price" class="dropdown-check-list">--%>
<%--                    <span class="anchor">Price</span>--%>
<%--                    <div class="wrapper">--%>
<%--                        <div class="price-input">--%>
<%--                            <div class="field">--%>
<%--                                <input type="number" class="input-min" value="0">--%>
<%--                            </div>--%>
<%--                            <div class="separator">-</div>--%>
<%--                            <div class="field">--%>
<%--                                <input type="number" class="input-max" value="10000">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="slider">--%>
<%--                            <div class="progress"></div>--%>
<%--                        </div>--%>
<%--                        <div class="range-input">--%>
<%--                            <input type="range" class="range-min" min="0" max="10000" value="0" step="100">--%>
<%--                            <input type="range" class="range-max" min="0" max="10000" value="10000" step="100">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <br>--%>
<%--                <div id="list2" class="dropdown-check-list">--%>
<%--                    <span class="anchor">Display diagonal</span>--%>
<%--                    <ul class="items">--%>
<%--                        <label class="container1">10-12"--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">13-13.9"--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">14-14.9--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">15-15.9--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">16-16.9--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">17-17.9--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--                <br>--%>
<%--                <div id="list3" class="dropdown-check-list">--%>
<%--                    <span class="anchor">RAM</span>--%>
<%--                    <ul class="items">--%>
<%--                        <label class="container1">4 GB--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">8 GB--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">16 GB--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                        <label class="container1">32 GB--%>
<%--                            <input type="checkbox">--%>
<%--                            <span class="checkmark"></span>--%>
<%--                        </label>--%>
<%--                    </ul>--%>
<%--                </div>--%>
                <input type="submit" class="filters-button" value="Show">
            </form>
        </div>
        <section id="products">
            <div class="sort-part">
                <p class="sort-text">Show:</p>
                <select id="sort" class="sort">
                    <option class="sort-choose">By popularity</option>
                    <option class="sort-choose">From cheap to expensive</option>
                    <option class="sort-choose">From expensive to cheap</option>
                    <option class="sort-choose">Novelties</option>
                    <option class="sort-choose">By name</option>
                </select>
                <div class="filters-icon">
                    <button onclick="document.getElementById('filters').style.display='block';
                            document.body.style.overflowY = 'hidden';">
                        <img src="/img/filter-_2_.svg">
                    </button>
                </div>
            </div>
            <div class="product-list">
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
                <div class="product-card">
                    <div class="card-image">
                        <img src="https://i.allo.ua/media/catalog/product/cache/1/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/g/p/gpbhkuvzj61_1.jpg" class="product-img">
                    </div>
                    <div class="right-desc">
                        <div class="product-name">
                            <p>Xiaomi RedmiBookPro 14 i5/16/512/2.5К</p>
                        </div>
                        <div class="card-signs">
                            <div class="Stars" style="--rating: 3.5;"></div>
                            <img src="img/chat-bubble.png" style="width: 20px; height: 20px; margin-right: 10px;">
                            <img src="img/heart.png" style="width: 20px; height: 20px; margin-right: 10px;">
                        </div>
                        <div class="buy-elements">
                            <div class="price">
                                <div class="pre-price">950$</div>
                                <div class="cur-price">900$</div>
                            </div>
                            <button class="add-product">Buy</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </article>
</main>
<footer>
    <div class="footer-padding">
        <div class="footer-block">
            <h2>Store Location</h2>
            <ul class="footer-info">
                <li>500 Terry Francois Street</li>
                <li>San Francisco, CA 94158</li>
                <li>info@mysite.com</li>
                <li>123-456-7890</li>
            </ul>
            <div class="socials">
                <a href="#" class="fa fa-facebook"></a>
                <a href="#" class="fa fa-instagram"></a>
                <a href="#" class="fa fa-twitter"></a>
                <a href="#" class="fa fa-youtube-play"></a>
            </div>
        </div>
        <div class="footer-block">
            <h2 class="collapsible">Shop</h2>
            <ul class="footer-links content">
                <a href="#"><li>Shop all</li></a>
                <a href="#"><li>Computers</li></a>
                <a href="#"><li>Phones</li></a>
                <a href="#"><li>Tablets</li></a>
                <a href="#"><li>Phones</li></a>
                <a href="#"><li>Watches</li></a>
                <a href="#"><li>Discounts</li></a>
            </ul>
        </div>
        <div class="footer-block">
            <h2 class="collapsible">Customer support</h2>
            <ul class="footer-links content">
                <a href="#"><li>Contact us</li></a>
                <a href="#"><li>FAQ</li></a>
                <a href="#"><li>About</li></a>
            </ul>
        </div>
        <div class="footer-block">
            <h2 class="collapsible">Policy</h2>
            <ul class="footer-links content">
                <a href="#"><li>Shipping & Returns</li></a>
                <a href="#"><li>Terms & Conditions</li></a>
                <a href="#"><li>Payment Methods</li></a>
            </ul>
        </div>
    </div>
    <div class="copyright">
        <p>2022 © by SmartShop. Proudly created by Alexey Lytovchenko.</p>
    </div>
</footer>
<script src="/js/general.js"></script>
<script src="/js/filters.js"></script>
</body>
</html>