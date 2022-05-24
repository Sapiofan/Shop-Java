<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu-curtain"></div>
<script>
    function cartChanges(url) {
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            complete: [
                function (response) {
                    $("#products").remove();
                    $("#cart-counter").remove();
                    $("#cart-count-top").remove();
                    htmlTable = `<ul id="products" class="products">`;
                    var data = ``;
                    var obj = $.parseJSON(response.responseText);
                    number = obj.length;
                    for (var i = 0; i < obj.length; i++) {
                        data += `<li class="product">
                        <a href="/product/`+obj[i].id+`">
                        <span class="product-image">
                            <img src="`+obj[i].image+`" alt="Product Photo" width="60" height="120">
                        </span>
                        </a>
                        <span class="product-details">
                            <a href="/product/`+obj[i].id+`">
                                <h3>`+obj[i].name+`</h3>
                            </a>
                                <span class="qty-price">
                                    <span class="qty">
                                        <button class="minus-button" id="minus-button-`+obj[i].id+`">-</button>
                                        <input type="number" id="qty-`+obj[i].id+`" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                                        <button class="plus-button" id="plus-button-`+obj[i].id+`">+</button>
                                    </span>
                                    <span class="price">`+obj[i].price+`</span>
                                </span>
                            </span>
                        </a>
                        <button type="button" onclick="cartChanges('deleteCartProduct/`+obj[i].id+`')" class="remove-button"><span class="remove-icon">X</span></button>
                    </li>`;
                    }
                    htmlTable += data + `</ul>`;
                    counter = `<span id="cart-counter" class="bag-count">`+ number +`</span>`;
                    counter2 = `<span id="cart-count-top" class="count">`+ number +`</span>`;
                    $("#pr").append(htmlTable);
                    $("#main-nav a").append(counter);
                    $("#cart-count-h2").append(counter2);
                }
            ]
        });
    }
</script>
<aside id="sidebar-cart">
    <main>
        <a href="" class="close-button"><span class="close-icon">X</span></a>
        <h2 id="cart-count-h2">Shopping Bag <span id="cart-count-top" class="count">${cartProducts.size()}</span></h2>
        <div id="pr">
            <ul id="products" class="products">
                <c:forEach items="${cartProducts}" var="product">
                    <li class="product">
                        <a href="/product/${product.id}">
                        <span class="product-image">
                            <img src="${product.image}" alt="Product Photo" width="60" height="120">
                        </span>
                        </a>
                        <span class="product-details">
                            <a href="/product/${product.id}">
                                <h3>${product.name}</h3>
                            </a>
                                <span class="qty-price">
                                    <span class="qty">
                                        <button onclick="subtractTotal(${product.price}, 'qty-${product.id}')" class="minus-button" id="minus-button-${product.id}">-</button>
                                        <input onclick="disableInput('qty-${product.id}')" type="number" id="qty-${product.id}" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                                        <button onclick="addTotal(${product.price}, 'qty-${product.id}')" class="plus-button" id="plus-button-${product.id}">+</button>
                                    </span>
                                    <span class="price">${product.price}</span>
                                </span>
                            </span>
                        </a>
                        <button type="button" onclick="cartChanges('deleteCartProduct/${product.id}')" class="remove-button"><span class="remove-icon">X</span></button>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="totals">
            <div class="subtotal">
                <span class="label">Subtotal:</span> <span id="subtotal" class="amount">${total}$</span>
            </div>
        </div>
        <div class="action-buttons">
            <a class="checkout-button" href="#">Checkout</a>
        </div>
    </main>
</aside>
<div id="sidebar-cart-curtain"></div>