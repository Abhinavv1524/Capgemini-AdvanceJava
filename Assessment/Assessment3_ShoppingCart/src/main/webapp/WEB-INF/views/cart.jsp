<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<h2>Your Cart</h2>

<c:forEach var="item" items="${cartItems}">
    <p>
        ${item.product.name} |
        Quantity: ${item.quantity} |
        Total: ₹${item.totalPrice}
    </p>
</c:forEach>

<h3>Grand Total: ₹${total}</h3>

<a href="products">Back to Products</a>

</body>
</html>