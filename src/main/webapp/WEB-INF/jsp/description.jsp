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
    <link rel="stylesheet" href="/css/general.css">
    <link rel="stylesheet" href="/css/description.css">
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
                    <input type="text" id="search" autocomplete="off" placeholder="Search device..." />
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
<main class="main" id="main">
    <header id="chars-header" class="">
        <div class="product-chars">
            <div class="product-image">
                <img src="https://unsplash.it/800?random">
            </div>
            <div class="full-product">
                <p>Samsung Galaxy S21 Ultra 12/128GB Phantom Black</p>
                <nav class="chars-nav sticky">
                    <a href="#carousel">About</a>
                    <a href="#chars">Characteristics</a>
                    <a href="#reviews">Reviews</a>
                </nav>
            </div>
            <div class="user-rating">
                <p class="u-rating">User rating: </p>
                <div class="one-line">
                    <div class="Stars" style="--rating: 4.4;"></div>
                    <p class="rating">4.4</p>
                    <a href="#" class="reviews-link">
                        <img src="img/chat-bubble.png" width="16px" height="16px">
                        <p>45 review(s)</p>
                    </a>
                </div>
            </div>
            <div class="signs-desc">
                <div class="header-price">
                    29 000$
                </div>
                <button class="header-buy" id="header-buy">Buy</button>
                <div class="header-like">
                    <img src="/img/heart (2).png">
                </div>
            </div>
        </div>
        <nav class="chars-nav">
            <a href="#carousel">About</a>
            <a href="#chars">Characteristics</a>
            <a href="#reviews">Reviews</a>
        </nav>
    </header>
    <section id="carousel">
        <div class="carousel-container">
            <ul class="carousel my-carousel carousel--thumb">
                <input class="carousel__activator" type="radio" id="K" name="thumb" checked="checked"/>
                <input class="carousel__activator" type="radio" id="L" name="thumb"/>
                <input class="carousel__activator" type="radio" id="M" name="thumb"/>
                <input class="carousel__activator" type="radio" id="N" name="thumb"/>
                <input class="carousel__activator" type="radio" id="O" name="thumb"/>
                <div class="carousel__controls">
                    <label class="carousel__control carousel__control--backward" for="O"></label>
                    <label class="carousel__control carousel__control--forward" for="L"></label>
                </div>
                <div class="carousel__controls">
                    <label class="carousel__control carousel__control--backward" for="K"></label>
                    <label class="carousel__control carousel__control--forward" for="M"></label>
                </div>
                <div class="carousel__controls">
                    <label class="carousel__control carousel__control--backward" for="L"></label>
                    <label class="carousel__control carousel__control--forward" for="N"></label>
                </div>
                <div class="carousel__controls">
                    <label class="carousel__control carousel__control--backward" for="M"></label>
                    <label class="carousel__control carousel__control--forward" for="O"></label>
                </div>
                <div class="carousel__controls">
                    <label class="carousel__control carousel__control--backward" for="N"></label>
                    <label class="carousel__control carousel__control--forward" for="K"></label>
                </div>
                <li class="carousel__slide" style="background-image: url('https://unsplash.it/800?random');"></li>
                <li class="carousel__slide"></li>
                <li class="carousel__slide"></li>
                <li class="carousel__slide"></li>
                <li class="carousel__slide"></li>
                <div class="carousel__indicators">
                    <label class="carousel__indicator" style="background-image: url('https://unsplash.it/800?random');" for="K"></label>
                    <label class="carousel__indicator" for="L"></label>
                    <label class="carousel__indicator" for="M"></label>
                    <label class="carousel__indicator" for="N"></label>
                    <label class="carousel__indicator" for="O"></label>
                </div>
            </ul>
        </div>
        <div class="about-product">
            <div class="general-info">
                <div class="general-info-text">
                    <p>Are available</p>
                    <div class="discount-price">
                        <p class="old-price">37 000</p>
                        <p class="profit">-8000</p>
                    </div>
                    <div class="price-now">
                        29 000$
                    </div>
                </div>
                <button class="add-to-cart">Buy</button>
                <div class="like-container">
                    <img src="img/heart.png" style="width: 32px; height: 32px;">
                </div>
            </div>
            <div class="discounts">
                <h6>Discounts and Stocks</h6>
                <div class="discount-type">
                    <img src="/img/badge.png" width="30px" height="30px">
                    <p><span class="bold-text">Discount</span> Benefit up to 8000 UAH</p>
                </div>
                <div class="discount-type">
                    <img src="img/shipping.png" width="30px" height="30px">
                    <p><span class="bold-text">Gifts</span> Earphones as a gift</p>
                </div>
            </div>
            <div class="payment">
                <h6>Payment</h6>
                <p>Cash, Non-cash, VISA/Mastercard</p>
            </div>
            <div class="exchange">
                <h6>Exchange/Return</h6>
                <p>Exchange and return of goods is carried out within 14 days after the purchase,
                    in accordance with the law of Ukraine "On the Protection of Consumer Rights of Ukraine"</p>
                <p>Warranty: 12 months</p>
            </div>
        </div>
    </section>
    <section id="chars" class="">
        <h3>Characteristics</h3>
        <h5>Screen</h5>
        <table class="screen-table">
            <col style="width: 50%;" />
            <tr>
                <td>Screen size</td>
                <td>6.8'</td>
            </tr>
            <tr>
                <td>Screen resolution</td>
                <td>3200x1440</td>
            </tr>
            <tr>
                <td>Screen refresh rate</td>
                <td>120 Hz</td>
            </tr>
            <tr>
                <td>Number of colors</td>
                <td>16 millions</td>
            </tr>
        </table>
        <h5>Memory</h5>
        <table class="memory-table">
            <col style="width: 50%;" />
            <tr>
                <td>Internal memory</td>
                <td>128 GB</td>
            </tr>
            <tr>
                <td>RAM</td>
                <td>12 GB</td>
            </tr>
            <tr>
                <td>Memory card slot</td>
                <td>No</td>
            </tr>
        </table>
        <h5>Processor</h5>
        <table class="processor-table">
            <col style="width: 50%;" />
            <tr>
                <td>Processor</td>
                <td>Exynos 2100</td>
            </tr>
            <tr>
                <td>Number of cores</td>
                <td>8</td>
            </tr>
            <tr>
                <td>Processor frequency</td>
                <td>1 x 2.9 GHz + 3 x 2.8 GHz + 4 x 2.2 GHz</td>
            </tr>
            <tr>
                <td>GPU</td>
                <td>Mali-G78 MP14</td>
            </tr>
        </table>
    </section>
    <section id="reviews" class="">
        <h3>Reviews: <span class="reviews-num">45</span></h3>
        <div class="general-rev-info">
            <div class="statistics-block">
                <div class="user-rating-block">
                    <p class="user-rating-r">User rating:</p>
                    <div class="star-rating-cont">
                        <p>4.4</p>
                        <div class="Stars star-r" style="--rating: 4.4;"></div>
                    </div>
                </div>
                <div class="recommended-circle">
                    <div class="single-chart">
                        <svg viewBox="0 0 36 36" class="circular-chart green">
                            <path class="circle-bg"
                                  d="M18 2.0845
                                      a 15.9155 15.9155 0 0 1 0 31.831
                                      a 15.9155 15.9155 0 0 1 0 -31.831"
                            />
                            <path class="circle"
                                  stroke-dasharray="90, 100"
                                  d="M18 2.0845
                                      a 15.9155 15.9155 0 0 1 0 31.831
                                      a 15.9155 15.9155 0 0 1 0 -31.831"
                            />
                            <text x="18" y="20.35" class="percentage">90%</text>
                        </svg>
                    </div>
                    <p>Recommended</p>
                </div>
            </div>
            <div class="feedback-but-cont">
                <button class="feedback-but" onclick="document.getElementById('feedback').style.display='block'">
                    Leave feedback</button>
            </div>
        </div>
        <div class="rewiews-container">
            <div class="review-container">
                <div class="name">
                    <p>Alexey</p>
                    <div class="Stars" style="--rating: 3;"></div>
                </div>
                <div class="comment-container">
                    <div class="date-check">
                        <p class="date">March 4, 2022</p>
                        <div class="recommend">
                            <img src="/img/check.png" width="16px" height="16px">
                            <p>Recommended</p>
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                    <p class="rev-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Maecenas porttitor nec est sed auctor. Cras ultrices blandit sapien et tempor. Praesent ipsum lectus,
                        tempus at bibendum nec, sollicitudin id arcu. Nam bibendum eget lacus at imperdiet.
                        Quisque ac blandit felis. Suspendisse aliquam lacus et arcu sagittis,
                        vel vehicula odio imperdiet. Nunc a lorem vehicula, convallis libero ut, vestibulum tellus. </p>
                </div>
            </div>
            <div class="review-container">
                <div class="name">
                    <p>Alexey</p>
                    <div class="Stars" style="--rating: 3;"></div>
                </div>
                <div class="comment-container">
                    <div class="date-check">
                        <p class="date">March 4, 2022</p>
                        <div class="recommend">
                            <img src="/img/check.png" width="16px" height="16px">
                            <p>Recommended</p>
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                    <p class="rev-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Maecenas porttitor nec est sed auctor. Cras ultrices blandit sapien et tempor. Praesent ipsum lectus,
                        tempus at bibendum nec, sollicitudin id arcu. Nam bibendum eget lacus at imperdiet.
                        Quisque ac blandit felis. Suspendisse aliquam lacus et arcu sagittis,
                        vel vehicula odio imperdiet. Nunc a lorem vehicula, convallis libero ut, vestibulum tellus.
                        Cras ultrices blandit sapien et tempor. Praesent ipsum lectus,
                        tempus at bibendum nec, sollicitudin id arcu. Nam bibendum eget lacus at imperdiet.  </p>
                </div>
            </div>
        </div>
        <div id="feedback" class="modal-feed">
            <form class="modal-feed-content" action="#">
                <div class="container">
                    <span onclick="document.getElementById('feedback').style.display='none'" class="close">&times;</span>
                    <div class="rate-product">
                        <p>Rate this product:</p>
                        <div class="rate">
                            <input type="radio" id="star5" name="rate" value="5" />
                            <label for="star5" title="text">5 stars</label>
                            <input type="radio" id="star4" name="rate" value="4" />
                            <label for="star4" title="text">4 stars</label>
                            <input type="radio" id="star3" name="rate" value="3" />
                            <label for="star3" title="text">3 stars</label>
                            <input type="radio" id="star2" name="rate" value="2" />
                            <label for="star2" title="text">2 stars</label>
                            <input type="radio" id="star1" name="rate" value="1" />
                            <label for="star1" title="text">1 star</label>
                        </div>
                    </div>
                    <textarea class="rev-input" type="text" placeholder="Your review" required></textarea>
                    <label class="container1">I recommend this product
                        <input type="checkbox" checked>
                        <span class="checkmark"></span>
                    </label>

                    <div class="clearfix">
                        <button type="submit" class="send-rev">Send</button>
                    </div>
                </div>
            </form>
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
<script src="/js/description.js"></script>
<script src="/js/general.js"></script>
</body>
</html>