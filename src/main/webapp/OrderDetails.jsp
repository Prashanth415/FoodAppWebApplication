<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.foodapp.model.OrderItem, com.foodapp.daoimplementation.OrderItemDaoImpl" %>
<%
    String orderIdStr = request.getParameter("orderId");
    int orderId = Integer.parseInt(orderIdStr);
    OrderItemDaoImpl dao = new OrderItemDaoImpl();
    List<OrderItem> orderItems = dao.getItemsByOrderId(orderId);
%>
<html>
<head>
    <title>Order Details</title>
</head>
<body>
    <h2>Your Order Items (Order ID: <%= orderId %>)</h2>
    <table border="1">
        <tr>
            <th>Menu ID</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <%
            float total = 0;
            for (OrderItem item : orderItems) {
                total += item.getTotalamount();
        %>
        <tr>
            <td><%= item.getMenuId() %></td>
            <td><%= item.getQuantity() %></td>
            <td>₹ <%= item.getTotalamount() %></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="2"><b>Grand Total</b></td>
            <td><b>₹ <%= total %></b></td>
        </tr>
    </table>
    <br />
    <a href="HomeServlet">⬅ Back to Home</a>
</body>
</html>