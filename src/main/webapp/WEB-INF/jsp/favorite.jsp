<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="likes" class="modal-likes">
    <form id='favform' class="likes-content" action="updateFavorites" method="post">
        <input type="hidden" value="${pageContext.servletContext.contextPath}" name="path">
        <div class="container-likes">
            <span onclick="document.getElementById('likes').style.display='none'" class="close">&times;</span>
            <h2>Wishlist</h2>
            <div class="wishlist">
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
                        <button type="submit" class="heart" name="heart">&#10084;</button>
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
            </div>
            <div class="clearfix">
                <button type="submit" class="clean-button" name="clean">Clear wishlist</button>
            </div>
        </div>
    </form>
</div>