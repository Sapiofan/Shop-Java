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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <header>
        <nav>
            <a data-langkey="Nav-Our-Work" href="#home">Home</a>
            <a data-langkey="Nav-Our-Work" href="#categories">Categories</a>
            <a data-langkey="Nav-The-Team" href="#about">About</a>
            <a data-langkey="Nav-The-Process" href="#help">Help</a>
            <a data-langkey="Nav-Contact" href="#contact_us">Contact</a>
<%--            <div id='languages'>--%>
<%--                <button id="en" onclick="changePlaceholder()" class='language active' data-lang='britain'>en--%>
<%--                </button>--%>
<%--                <button class='language' onclick="changePlaceholder()" data-lang='ukraine'>ua</button>--%>
<%--            </div>--%>
        </nav>
    </header>
    <main>
        <section id="advantages">
            <div class="advantages-padding">
                <div class="advantage">
                    <div class="advantage-icon">
                        <img src="img/logistics-delivery.png">
                    </div>
                    <p class="advantage-text">Fast delivery anywhere in the country</p>
                </div>
                <div class="advantage">
                    <div class="advantage-icon">
                        <img src="img/delivery.png">
                    </div>
                    <p class="advantage-text">Free shipping on orders over $50</p>
                </div>
                <div class="advantage">
                    <div class="advantage-icon">
                        <img src="img/discount.png">
                    </div>
                    <p class="advantage-text">Low prices guaranteed</p>
                </div>
                <div class="advantage">
                    <div class="advantage-icon">
                        <img src="img/clock.png">
                    </div>
                    <p class="advantage-text">Available to you 24/7</p>
                </div>
            </div>
        </section>
        <section id="send-email">
            <div class="email-padding">
                <h1>Newsletter</h1>
                <h3>Sign up to receive updates on new arrivals and special offers</h3>
<%--                email-input--%>
            </div>

        </section>
    </main>
    <footer>
        <div class="footer-padding">
            <div class="footer-block">
                <h2>Store Location</h2>
                <ul>
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
<%--                    <a href="#"><img class='social-icon' src="/store/src/interface/home/img/instagram.svg"></a>--%>
<%--                    <a href="#"><img class='social-icon' src="/store/src/interface/home/img/telegram.svg"></a>--%>
<%--                    <a href="#"><img class='social-icon' src="/store/src/interface/home/img/whatsapp.svg"></a>--%>
                </div>
            </div>
            <div class="footer-block">
                <h2>Shop</h2>
                <ul>
                    <a href="#"><li>Shop all</li></a>
                    <a href="#"><li>Computers</li></a>
                    <a href="#"><li>Phones</li></a>
                    <a href="#"><li>TV</li></a>
                    <a href="#"><li>Discounts</li></a>
                </ul>
            </div>
            <div class="footer-block">
                <h2>Customer support</h2>
                <ul>
                    <a href="#"><li>Contact us</li></a>
                    <a href="#"><li>FAQ</li></a>
                    <a href="#"><li>About</li></a>
                </ul>
            </div>
            <div class="footer-block">
                <h2>Policy</h2>
                <ul>
                    <a href="#"><li>Shipping & Returns</li></a>
                    <a href="#"><li>Terms & Conditions</li></a>
                    <a href="#"><li>Payment Methods</li></a>
                </ul>
            </div>
        </div>
    </footer>
<%--    <div id="mydiv"></div>--%>
<%--    <script type="text/babel">--%>
<%--        $( document ).ready(function() {--%>
<%--            console.log( "ready!" );--%>
<%--            ReactDOM.render( <Component/>, document.getElementById('mydiv'));--%>
<%--        });--%>
<%--    </script>--%>
</body>
</html>