<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<body>

<h2>Product List</h2>

<c:forEach var="p" items="${products}">
    <form action="addToCart" method="post">

        ${p.name} - ₹${p.price}

        <input type="hidden" name="product.id" value="${p.id}" />

        Quantity:
        <input type="number" name="quantity" value="1" min="1"/>

        <button type="submit">Add to Cart</button>
    </form>
    <br/>
</c:forEach>

<a href="viewCart">View Cart</a>

</body>
</html>