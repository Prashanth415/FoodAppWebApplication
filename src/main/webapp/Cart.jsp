<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.foodapp.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #fefefe;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            font-size: 2rem;
            margin: 30px 0;
            color: #333;
        }

        table {
            width: 85%;
            margin: 0 auto;
            border-collapse: separate;
            border-spacing: 0 15px;
        }

        th {
            background-color: #ff5722;
            color: white;
            padding: 14px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            font-size: 1rem;
        }

        td {
            background-color: white;
            padding: 16px;
            box-shadow: 0 2px 12px rgba(0,0,0,0.06);
            font-size: 15px;
        }

        tr td:first-child {
            border-left: 6px solid #ff7043;
            border-top-left-radius: 10px;
            border-bottom-left-radius: 10px;
        }

        tr td:last-child {
            border-top-right-radius: 10px;
            border-bottom-right-radius: 10px;
        }

        tr.total-row td {
            font-weight: bold;
            background-color: #f9f9f9;
            font-size: 1.1rem;
            border: none;
            box-shadow: none;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 6px 10px;
            font-size: 14px;
            border-radius: 5px;
            cursor: pointer;
            margin: 0 3px;
            transition: background 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #388e3c;
        }

        .empty-cart {
            text-align: center;
            color: #555;
            font-size: 1.2rem;
            margin: 50px auto;
        }

        .action-buttons {
            margin-top: 30px;
            text-align: center;
        }

        .action-buttons form {
            display: inline-block;
            margin: 0 10px;
        }

        .action-buttons button {
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 6px;
            border: none;
            cursor: pointer;
            transition: 0.3s ease;
        }

        .action-buttons .add-btn {
            background-color: #f57c00;
            color: white;
        }

        .action-buttons .add-btn:hover {
            background-color: #ef6c00;
        }

        .action-buttons .order-btn {
            background-color: #388e3c;
            color: white;
        }

        .action-buttons .order-btn:hover {
            background-color: #2e7d32;
        }

        .back-btn {
            background-color: #ff7043;
            color: white;
            font-size: 16px;
            padding: 10px 25px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .back-btn:hover {
            background-color: #f4511e;
        }
    </style>
</head>
<body>

<%
    List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
    float total = 0;
%>

<h2>Your Cart</h2>

<%
    if (cartItems != null && !cartItems.isEmpty()) {
%>
    <table>
        <tr>
            <th>Item</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Actions</th>
        </tr>
    <%
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
    %>
        <tr>
            <td><%= item.getItemname() %></td>
            <td>₹ <%= item.getPrice() %></td>
            <td><%= item.getQuantity() %></td>
            <td>₹ <%= item.getTotalPrice() %></td>
            <td>
                <form action="UpdateCart" method="post">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>" />
                    <input type="submit" name="action" value="+" />
                    <input type="submit" name="action" value="-" />
                </form>
            </td>
        </tr>
    <%
        }
    %>
        <tr class="total-row">
            <td colspan="3">Grand Total</td>
            <td colspan="2">₹ <%= total %></td>
        </tr>
    </table>

    <div class="action-buttons">
        <form action="Menu" method="get">
            <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") != null ? session.getAttribute("restaurantId").toString().trim() : "" %>" />
            <button type="submit" class="add-btn">➕ Add More Items</button>
        </form>

        <form action="PlaceOrderServlet" method="post" onsubmit="return validateBeforeSubmit()">
    <input type="hidden" name="restaurantId" value="${sessionScope.restaurantId}" />
    <button type="submit" class="order-btn">✅ Place Order</button>
</form>

<script>
function validateBeforeSubmit() {
    // Client-side validation
    if(${empty sessionScope.userId}) {
        alert("Please login to place an order");
        window.location.href = "UserLogin.jsp";
        return false;
    }
    return true;
}
</script>
    </div>

<%
    } else {
%>
    <div class="empty-cart">
        <p>🛒 Your cart is empty. Add items to place an order!</p>
        <form action="Menu" method="get" style="margin-top: 20px;">
            <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") != null ? session.getAttribute("restaurantId").toString().trim() : "" %>" />
            <button type="submit" class="back-btn">🔙 Back to Menu</button>
        </form>
    </div>
<%
    }
%>

</body>
</html>
