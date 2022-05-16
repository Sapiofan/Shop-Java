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
            content="A project to try to create qualitative site."
    />
    <link rel="icon"
          href="https://ru.seaicons.com/wp-content/uploads/2015/10/Flat-TV-icon.png">

    <link rel="stylesheet" href="/css/general.css">
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/home.css">
</head>
<body>
<jsp:include page="admin-header.jsp"/>
<main class="main">

    <form action="#" method="post">
        <div class="footnote-buttons">
            <button type="submit" class="reload">See changes</button>
            <button type="submit" class="footnote-save">Save changes</button>
        </div>
        <section id="banners">
            <div class="banner" style="margin-right: 50px;">
                <img class="banner-img"
                     src="https://static.wixstatic.com/media/c22c23_e140bfa8cd6f4cb2ac5ee6e204f64073~mv2.jpg/v1/fill/w_851,h_585,al_t,q_85,usm_0.66_1.00_0.01,enc_auto/c22c23_e140bfa8cd6f4cb2ac5ee6e204f64073~mv2.jpg">
                <div class="banner-text">
                    <p>Holiday Deals</p>
                    <h1>Up to 30% off</h1>
                    <p>Selected Smartphone Brands</p>
                    <button class="b-button">Shop</button>
                </div>
            </div>
            <div class="banner">
                <img class="banner-img"
                     src="https://static.wixstatic.com/media/c837a6_d84a631864a442a496670bc2d787c6a0~mv2.jpg/v1/fill/w_851,h_585,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/c837a6_d84a631864a442a496670bc2d787c6a0~mv2.jpg">
                <div class="banner-text">
                    <p>Just In</p>
                    <h1>Take Your Sound Anywhere</h1>
                    <p>Top Headphone Brands</p>
                    <button class="b-button">Shop</button>
                </div>
            </div>
        </section>
        <div class="footnote-banners">
            <div class="block1">
                <input type="text" class="footnote-input footnote-link"
                       value="https://static.wixstatic.com/media/c22c23_e140bfa8cd6f4cb2ac5ee6e204f64073~mv2.jpg/v1/fill/w_851,h_585,al_t,q_85,usm_0.66_1.00_0.01,enc_auto/c22c23_e140bfa8cd6f4cb2ac5ee6e204f64073~mv2.jpg">
                <input type="text" class="footnote-input" value="Holiday Deals"><br>
                <input type="text" class="footnote-input" value="Up to 30% off"><br>
                <input type="text" class="footnote-input" value="Selected Smartphone Brands">
            </div>
            <div class="block2">
                <input type="text" class="footnote-input footnote-link"
                       value="https://static.wixstatic.com/media/c837a6_d84a631864a442a496670bc2d787c6a0~mv2.jpg/v1/fill/w_851,h_585,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/c837a6_d84a631864a442a496670bc2d787c6a0~mv2.jpg">
                <input type="text" class="footnote-input" value="Just in"><br>
                <input type="text" class="footnote-input" value="Take Your Sound Anywhere"><br>
                <input type="text" class="footnote-input" value="Top Headphone Brands">
            </div>
        </div>
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
                <img class="special-img"
                     src="https://static.wixstatic.com/media/c837a6_ecf32c7284d4430582fcc90f60a1b4e6~mv2.png/v1/fill/w_1753,h_750,al_c,q_90,usm_0.66_1.00_0.01/c837a6_ecf32c7284d4430582fcc90f60a1b4e6~mv2.webp">
            </div>
        </section>
        <div class="footnote-offer">
            <div class="block3">
                <input type="text" class="footnote-input footnote-link"
                       value="https://static.wixstatic.com/media/c837a6_ecf32c7284d4430582fcc90f60a1b4e6~mv2.png/v1/fill/w_1753,h_750,al_c,q_90,usm_0.66_1.00_0.01/c837a6_ecf32c7284d4430582fcc90f60a1b4e6~mv2.webp">
                <br>
                <input type="text" class="footnote-input" value="Today's special"><br>
                <input type="text" class="footnote-input" value="Best Arial View in Town"><br>
                <input type="text" class="footnote-input" value="30%"><br>
                <input type="text" class="footnote-input" value="OFF"><br>
                <input type="text" class="footnote-input" value="on professional camera drones"><br>
                <input type="text" class="footnote-input" value="Limited quantities."><br>
                <input type="text" class="footnote-input" value="See product detail pages for availability.">
            </div>
        </div>
    </form>
</main>
</body>
</html>