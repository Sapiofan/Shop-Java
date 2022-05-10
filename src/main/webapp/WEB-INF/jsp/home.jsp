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
<body id="body">
<jsp:include page="header.jsp"/>
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
    </section>
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
<jsp:include page="footer.jsp" />
<script src="/js/general.js"></script>
<script src="/js/home.js"></script>
</body>
<script>
    window.onload = ev => {
        let res = ${userExist};
        if(res !== ""){
            alert(res);
        }
    }
</script>
</html>