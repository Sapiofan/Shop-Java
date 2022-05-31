<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="menu">
    <div class="menu-logo">
        <p>SmartShop</p>
    </div>
    <div class="menu-choice">
<%--        <a href="#" onclick="document.getElementById('login').style.display='block'">--%>
<%--            <div class="menu-item menu-user">--%>
<%--                <img src="img/user-2.svg" style="width: 26px; height: 26px; margin-left: 2px;">--%>
<%--                <p>Log in profile</p>--%>
<%--            </div>--%>
<%--        </a>--%>
<%--        <a href="#" onclick="document.getElementById('likes').style.display='block'">--%>
<%--            <div class="menu-item">--%>
<%--                <img src="img/heart-1.png" style="width: 30px; height: 30px;">--%>
<%--                <p>Favorites</p>--%>
<%--            </div>--%>
<%--        </a>--%>
        <c:if test="${isAuthenticated}">
            <form action="/" method="post">
                <div class="dropdown-user">
                    <button type="button" class="dropbtn-user user"><img src="/img/user.png"
                                                                         style="width: 36px; height: 36px;"></button>
                    <div class="dropdown-content-user">
                        <a href="#">SmartShop money</a>
                        <a href="#">My orders</a>
                        <a><button type="submit" class="logout" name="logout">Logout</button></a>
                    </div>
                </div>
            </form>
        </c:if>
        <c:if test="${!isAuthenticated}">
            <button onclick="document.getElementById('login').style.display='block'"
                    class="user"><img src="/img/user.png" style="width: 36px; height: 36px;"></button>
        </c:if>
        <c:if test="${isAuthenticated}">
            <button id="header-heart" onclick="document.getElementById('likes').style.display='block'"
                    class="likes">
                <img src="/img/heart (2).png" style="width: 36px; height: 36px;">
                <span id="header-heart-n" class="wishlist-count">${favoriteProducts.size()}</span>
            </button>
        </c:if>
        <c:if test="${!isAuthenticated}">
            <button onclick="document.getElementById('login').style.display='block'"
                    class="likes">
                <img src="/img/heart (2).png" style="width: 36px; height: 36px;">
            </button>
        </c:if>
        <a href="/">
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
                        <a href="/phones">Phones</a>
                        <a href="/laptops">Laptops</a>
                        <a href="/watches">Watches</a>
                        <a href="/discounts">Discounts</a>
                        <a href="#">Bestsellers</a>
                        <a href="#">Computers</a>
                        <a href="#">Drones</a>
                    </ul>
                </div>
            </div>
        </div>
        <a href="/about">
            <div class="menu-item">
                <img src="img/info.png" style="width: 30px; height: 30px;">
                <p>About</p>
            </div>
        </a>
        <a href="/help">
            <div class="menu-item">
                <img src="img/communication.png" style="width: 30px; height: 30px;">
                <p>Help</p>
            </div>
        </a>
    </div>
</aside>