<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function ajax() {
        $.ajax({
            type: "GET",
            url: "cleanWishlist",
            dataType: "json",
            complete: [
                function (response) {
                    $("#wishlist").remove();
                    $("#header-heart-n").remove();
                    htmlTable = `<div id="wishlist" class="wishlist">`;
                    var data = ``;
                    var obj = $.parseJSON(response.responseText);
                    number = obj.length;
                    for (var i = 0; i < obj.length; i++) {
                        data += `<div class="wishlist-product"> <a href="/product/`+obj[i].id+`"><img width="150px" height="150px" src="`+obj[i].image+`"></a>`;
                        data += `<a href="/product/`+obj[i].id+`"><div class="product-description">
                                        <p class="wish-product-name">`+obj[i].name+`</p>
                                        <p class="wish-price">`+obj[i].price+`$</p>
                                        <div class="Stars" style="--rating: `+obj[i].rating+`"></div>
                                    </div>
                                </a>
                                <button class="heart" name="heart">&#10084;</button>
                            </div>`;
                    }
                    htmlTable += data + `<div class="clearfix">
                    <button type="button" onclick="ajax()" class="clean-button" id="clean-button" name="clean">Clear wishlist</button>
                    </div></div>`;
                    counter = `<span id="header-heart-n" class="wishlist-count">`+ number +`</span>`;
                    $("#w").append(htmlTable);
                    $("#header-heart").append(counter);
                }
            ]
        });
    }

    function productChanges(url) {
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            complete: [
                function (response) {
                    $("#wishlist").remove();
                    $("#header-heart-n").remove();
                    htmlTable = `<div id="wishlist" class="wishlist">`;
                    var data = ``;
                    var obj = $.parseJSON(response.responseText);
                    number = obj.length;
                    for (var i = 0; i < obj.length; i++) {
                        data += `<div class="wishlist-product"> <a href="/product/`+obj[i].id+`"><img width="150px" height="150px" src="`+obj[i].image+`"></a>`;
                        data += `<a href="/product/`+obj[i].id+`"><div class="product-description">
                                        <p class="wish-product-name">`+obj[i].name+`</p>
                                        <p class="wish-price">`+obj[i].price+`$</p>
                                        <div class="Stars" style="--rating: `+obj[i].rating+`"></div>
                                    </div>
                                </a>
                                <button type="button" onclick="productChanges('/deleteFavorite/`+ obj[i].id +`')" class="heart" name="heart">&#10084;</button>
                            </div>`;
                    }
                    htmlTable += data + `<div class="clearfix">
                    <button type="button" onclick="ajax()" class="clean-button" id="clean-button" name="clean">Clear wishlist</button>
                    </div></div>`;
                    counter = `<span id="header-heart-n" class="wishlist-count">`+ number +`</span>`;
                    $("#w").append(htmlTable);
                    $("#header-heart").append(counter);
                }
            ]
        });
    }
</script>
<div id="likes" class="modal-likes">
    <form id='favform' class="likes-content" action="/updateFavorites" method="get">
        <input type="hidden" value="${pageContext.servletContext.contextPath}" name="path">
        <div class="container-likes">
            <span onclick="document.getElementById('likes').style.display='none'" class="close">&times;</span>
            <h2>Wishlist</h2>
            <div id="w">

            <div id="wishlist" class="wishlist">
                <c:forEach items="${favoriteProducts}" var="product">
                    <input type="hidden" value="${product.id}" name="productId">
                    <div class="wishlist-product">
                        <a href="/product/${product.id}"><img width="150px" height="150px" src="${product.image}"></a>
                        <a href="/product/${product.id}">
                            <div class="product-description">
                                <p class="wish-product-name">${product.name}</p>
                                <p class="wish-price">${product.price}$</p>
                                <div class="Stars" style="--rating: ${product.rating};"></div>
                            </div>
                        </a>
                        <button type="button" onclick="productChanges('/deleteFavorite/${product.id}')" class="heart" name="heart">&#10084;</button>
                    </div>
                </c:forEach>
<%--                <div class="wishlist-product">--%>
<%--                    <a href="#"><img width="150px" height="150px" src="https://static.wixstatic.com/media/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.webp"></a>--%>
<%--                    <a href="#">--%>
<%--                        <div class="product-description">--%>
<%--                            <p class="wish-product-name">Samsung Galaxy S21 Ultra 12/128GB Phantom Black</p>--%>
<%--                            <p class="wish-price">14.45$</p>--%>
<%--                            <div class="Stars" style="--rating: 3.5;"></div>--%>
<%--                        </div>--%>
<%--                    </a>--%>
<%--                    <button class="heart">&#10084;</button>--%>
<%--                </div>--%>
<%--                <div class="wishlist-product">--%>
<%--                    <a href="#"><img width="150px" height="150px" src="https://static.wixstatic.com/media/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.jpg/v1/fill/w_343,h_343,al_c,q_80,usm_0.66_1.00_0.01/c22c23_77a52a8e6f8b4879a6548e11a3df3613~mv2.webp"></a>--%>
<%--                    <a href="#">--%>
<%--                        <div class="product-description">--%>
<%--                            <p class="wish-product-name">Samsung Galaxy S21 Ultra 12/128GB Phantom Black</p>--%>
<%--                            <p class="wish-price">14.45$</p>--%>
<%--                            <div class="Stars" style="--rating: 3.5;"></div>--%>
<%--                        </div>--%>
<%--                    </a>--%>
<%--                    <button class="heart">&#10084;</button>--%>
<%--                </div>--%>
<%--            </div>--%>
                <div class="clearfix">
                    <button type="button" onclick="ajax()" class="clean-button" id="clean-button" name="clean">Clear wishlist</button>
                </div>
            </div>
        </div>
        </div>
    </form>
</div>