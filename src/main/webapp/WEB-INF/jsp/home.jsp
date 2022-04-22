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
            content="A joint project to create qualitative site."
    />
    <link rel="icon"
          href="https://ru.seaicons.com/wp-content/uploads/2015/10/Flat-TV-icon.png">

    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script crossorigin src="https://unpkg.com/react@16.13.1/umd/react.development.js"></script>
    <script crossorigin src="https://unpkg.com/react-dom@16.13.1/umd/react-dom.development.js"></script>
    <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
    <script type="text/babel" src="/js/components/Component.jsx"></script>
    <script src="/js/home.js"></script>

    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/general.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="air-slider.min.css">

    <script src="air-slider.min.js"></script>

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
            <a data-langkey="Nav-Our-Work" href="#home"><span class="active-nav">Home</span></a>
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
                <form action="/filters" method="get">
                    <div id="search-wrapper">
                        <input type="text" name="search" id="search" autocomplete="off" placeholder="Search device..." />
                        <div id="close-icon"></div>
                        <input type="submit" style="display:none"/>
                    </div>
                </form>
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
                            <a href="#">Computers</a>
                            <a href="#">Phones</a>
                            <a href="#">Tablets</a>
                            <a href="#">Watches</a>
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
<main>
    <section>
        <div class="slideshow-container">
            <div class="mySlides fade">
                <img src="/img/laptop.PNG">
            </div>
            <div class="mySlides fade">
                <img src="https://static.wixstatic.com/media/c837a6_f58829a26e594ca3aa72383e19cf39b9~mv2.png/v1/fill/w_1309,h_706,al_r,usm_0.66_1.00_0.01,enc_auto/c837a6_f58829a26e594ca3aa72383e19cf39b9~mv2.png">
            </div>
            <div class="mySlides fade">
                <img src="https://static.wixstatic.com/media/c837a6_837f9cd4f59146c3ad47a2bd882fedfd~mv2.png/v1/fill/w_1309,h_706,al_r,usm_0.66_1.00_0.01,enc_auto/c837a6_837f9cd4f59146c3ad47a2bd882fedfd~mv2.png">
            </div>
            <div class="text">
                <div class="red-benefit">
                    Best prices
                </div>
                <h1>
                    Incredible Prices On All Your Favorite Items
                </h1>
                <p class="desc-benefit">Get more for less on selected brands</p>
                <button class="slider-button">Shop now</button>
            </div>
        </div>
        <br>
        <!-- <div style="text-align:center">
          <span class="dot" onclick="currentSlide(1)"></span>
          <span class="dot" onclick="currentSlide(2)"></span>
          <span class="dot" onclick="currentSlide(3)"></span>
        </div> -->
    </section>
    <!-- <section id="carousel">
        <div class="center">
            <div class="wrapper">
              <div class="inner">
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/keshbek-2500-na-televizor-300х460.jpg">
                </div>
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/S22_W-XXL_300x460.jpg">
                </div>
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/11t_W-XL-300x460_1.png">
                </div>
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/S22_W-XXL_300x460.jpg">
                </div>
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/keshbek-2500-na-televizor-300х460.jpg">
                </div>
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/S22_W-XXL_300x460.jpg">
                </div>
                      <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/S22_W-XXL_300x460.jpg">
                </div>
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/keshbek-2500-na-televizor-300х460.jpg">
                </div>
                <div class="card">
                  <img src="https://i.allo.ua/media/homepage/topbanner/S22_W-XXL_300x460.jpg">
                </div>
                <div class="card">
                    <img src="https://i.allo.ua/media/homepage/topbanner/keshbek-2500-na-televizor-300х460.jpg">
                </div>
                <div class="card">
                    <img src="https://i.allo.ua/media/homepage/topbanner/S22_W-XXL_300x460.jpg">
                </div>
                <div class="card">
                    <img src="https://i.allo.ua/media/homepage/topbanner/S22_W-XXL_300x460.jpg">
                </div>
                <div class="card">
                    <img src="https://i.allo.ua/media/homepage/topbanner/keshbek-2500-na-televizor-300х460.jpg">
                </div>
              </div>
            </div>

            <div class="map">
              <button class="active first"></button>
              <button class="second"></button>
              <button class="third"></button>
            </div>
          </div>
    </section> -->
    <section id="banners">
        <div class="banner" style="margin-right: 50px;">
            <img class="banner-img" src="https://static.wixstatic.com/media/c22c23_e140bfa8cd6f4cb2ac5ee6e204f64073~mv2.jpg/v1/fill/w_851,h_585,al_t,q_85,usm_0.66_1.00_0.01,enc_auto/c22c23_e140bfa8cd6f4cb2ac5ee6e204f64073~mv2.jpg">
            <div class="banner-text">
                <p>Holiday Deals</p>
                <h1>Up to 30% off</h1>
                <p>Selected Smartphone Brands</p>
                <button class="b-button">Shop</button>
            </div>
        </div>
        <div class="banner">
            <img class="banner-img" src="https://static.wixstatic.com/media/c837a6_d84a631864a442a496670bc2d787c6a0~mv2.jpg/v1/fill/w_851,h_585,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/c837a6_d84a631864a442a496670bc2d787c6a0~mv2.jpg">
            <div class="banner-text">
                <p>Just In</p>
                <h1>Take Your Sound Anywhere</h1>
                <p>Top Headphone Brands</p>
                <button class="b-button">Shop</button>
            </div>
        </div>
    </section>

    <section id="best-sellers">
        <div class="sellers-padding">
            <h1>Best sellers</h1>
            <div class="products">
                <div class="product">
                    <div class="img-container">
                        <img class="zoom" src="https://static.wixstatic.com/media/c22c23_75059a72af5e4949aecdfbda8746f4ef~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_75059a72af5e4949aecdfbda8746f4ef~mv2.webp">
                    </div>
                    <div class="description">
                        <p>Fitboot Inspire Fitness Tracker With Heart Rate Tracking</p>
                    </div>
                    <div class="prices">
                        <p class="crossed-out">$85.00</p>
                        <p>$70.00</p>
                    </div>
                </div>
                <div class="product">
                    <div class="img-container">
                        <img class="zoom" src="https://static.wixstatic.com/media/c22c23_3ab3d3acd73843deba1dece7b2254e2f~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_3ab3d3acd73843deba1dece7b2254e2f~mv2.webp">
                    </div>
                    <div class="description">
                        <p>JP Gaming Laptop 15.6" Laptop 256GB</p>
                    </div>
                    <div class="prices">
                        <p class="crossed-out">$85.00</p>
                        <p>$70.00</p>
                    </div>
                </div>
                <div class="product">
                    <div class="img-container">
                        <img class="zoom" src="https://static.wixstatic.com/media/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.webp">
                    </div>
                    <div class="description">
                        <p>HKI Tech Quadcopter Drone With 360 Camera & Controller</p>
                    </div>
                    <div class="prices">
                        <p>$85.00</p>
                    </div>
                </div>
                <div class="product">
                    <div class="img-container">
                        <img class="zoom" src="https://static.wixstatic.com/media/c22c23_75059a72af5e4949aecdfbda8746f4ef~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_75059a72af5e4949aecdfbda8746f4ef~mv2.webp">
                    </div>
                    <div class="description">
                        <p>Smartphone Z Pixel Max 128GB Unlocked</p>
                    </div>
                    <div class="prices">
                        <p class="crossed-out">$85.00</p>
                        <p>$70.00</p>
                    </div>
                </div>
                <div class="product">
                    <div class="img-container">
                        <img class="zoom" src="https://static.wixstatic.com/media/c22c23_3ab3d3acd73843deba1dece7b2254e2f~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_3ab3d3acd73843deba1dece7b2254e2f~mv2.webp">
                    </div>
                    <div class="description">
                        <p>In-ear Noise Cancelling & Isolating Wireless Earbuds</p>
                    </div>
                    <div class="prices">
                        <p>$85.00</p>
                    </div>
                </div>
            </div>
            <button class="view-all">View All</button>
        </div>
    </section>
    <section id="special-offer">
        <div class="offer-text">
            <h3>Today's special</h3>
            <h2>Best Arial View in Town</h2>
            <h1><span style="color: blueviolet;">30%</span> OFF</h1>
            <h2>on professional camera drones</h2>
            <p>Limited quantities.<br>
                See product detail pages for availability.</p>
            <button class="shop">Shop</button>
        </div>
        <div class="offer-image">
            <img class="special-img" src="https://static.wixstatic.com/media/c837a6_ecf32c7284d4430582fcc90f60a1b4e6~mv2.png/v1/fill/w_1753,h_750,al_c,q_90,usm_0.66_1.00_0.01/c837a6_ecf32c7284d4430582fcc90f60a1b4e6~mv2.webp">
        </div>
    </section>
    <section id="advantages">
        <div class="advantages-padding">
            <div class="advantage">
                <div class="advantage-icon">
                    <img src="img/logistics-delivery.png" style="width: 64px; height: 64px;">
                </div>
                <p class="advantage-text">Fast delivery anywhere in the country</p>
            </div>
            <div class="advantage">
                <div class="advantage-icon">
                    <img src="img/delivery.png" style="width: 64px; height: 64px;">
                </div>
                <p class="advantage-text">Free shipping on orders over $50</p>
            </div>
            <div class="advantage">
                <div class="advantage-icon">
                    <img src="img/discount.png" style="width: 64px; height: 64px;">
                </div>
                <p class="advantage-text">Low prices guaranteed</p>
            </div>
            <div class="advantage">
                <div class="advantage-icon">
                    <img src="img/clock.png" style="width: 64px; height: 64px;">
                </div>
                <p class="advantage-text">Available to you 24/7</p>
            </div>
        </div>
    </section>
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
<script src="/js/home.js"></script>
</body>
</html>