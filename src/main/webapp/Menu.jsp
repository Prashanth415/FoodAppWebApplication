<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Restaurant Menu</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      margin: 0;
      background-color: #f7f7f7;
    }

    /* Navbar styles */
    nav {
      background-color: #ff4d4d;
      color: white;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 1rem 2rem;
      flex-wrap: wrap;
    }

    .nav-left {
      display: flex;
      align-items: center;
      gap: 1rem;
    }

    .nav-left h1 {
      margin: 0;
      font-size: 1.5rem;
    }

    .search-bar {
      background: white;
      padding: 0.3rem 0.5rem;
      border-radius: 20px;
      display: flex;
      align-items: center;
      gap: 0.5rem;
    }

    .search-bar input {
      border: none;
      outline: none;
      font-size: 1rem;
    }

    .nav-right {
      list-style: none;
      display: flex;
      gap: 1rem;
      margin: 0;
      padding: 0;
      flex-wrap: wrap;
    }

    .nav-right li {
      cursor: pointer;
      transition: color 0.2s;
    }

    .nav-right li:hover {
      color: #ffdada;
    }

    /* Back link */
    .back-link {
      display: inline-block;
      margin: 1rem 2rem 0;
      text-decoration: none;
      color: #ff4d4d;
      font-weight: bold;
      font-size: 1rem;
      transition: color 0.3s ease;
    }

    .back-link:hover {
      color: #e60000;
    }

    .menu-container {
      max-width: 1000px;
      margin: 1rem auto 2rem;
      padding: 0 1rem;
    }

    .restaurant-header {
      text-align: center;
      margin-bottom: 2rem;
    }

    .restaurant-header h2 {
      margin: 0;
      font-size: 2rem;
    }

    .menu-item {
      background-color: white;
      display: flex;
      gap: 1rem;
      padding: 1rem;
      margin-bottom: 1rem;
      border-radius: 10px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.05);
      transition: transform 0.2s;
    }

    .menu-item:hover {
      transform: translateY(-3px);
    }

    .item-img {
      width: 120px;
      height: 100px;
      object-fit: cover;
      border-radius: 8px;
    }

    .item-details {
      flex: 1;
    }

    .item-details h3 {
      margin: 0;
      font-size: 1.2rem;
    }

    .item-details p {
      margin: 0.3rem 0;
      color: #555;
      font-size: 0.9rem;
    }

    .price-rating {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-top: 0.5rem;
    }

    .price {
      font-weight: bold;
      color: #000;
    }

    .rating {
      background-color: #48c479;
      color: white;
      padding: 0.2rem 0.5rem;
      border-radius: 5px;
      font-size: 0.8rem;
    }
    .add-cart-btn {
  margin-top: 0.8rem;
  padding: 0.5rem 1rem;
  background-color: #ff4d4d;
  color: white;
  border: none;
  border-radius: 5px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.add-cart-btn:hover {
  background-color: #e60000;
}
    
  </style>

  <script>
    function filterRestaurants() {
      const input = document.getElementById("searchInput").value.toLowerCase();
      alert("Search function placeholder: " + input);
      // You can hook this with backend filtering or JS filtering logic
    }
  </script>
</head>
<body>

 
  <nav>
  <div class="nav-left">
    <a href="HomeServlet" class="back-link" style="font-size: 1.5rem; color: white; text-decoration: none;">←</a>
    <h1>TastyTrack</h1>
    <div class="search-bar">
      <span class="search-icon">🔍</span>
      <input type="text" id="searchInput" placeholder="Search restaurants..." onkeyup="filterRestaurants()">
    </div>
  </div>
  <ul class="nav-right">
    <li><a href="HomeServlet" style="color: white; text-decoration: none;">Home</a></li>
    <li>Categories</li>
    <li>Cart</li>
    <li>Orders</li>
    <li>Offers</li>
    <li><a href="LoginServlet" style="color: white; text-decoration: none;">Login/Signup</a></li>
    <li>Profile</li>
  </ul>
</nav>
  <%  List<Menu> menus =(List<Menu>)request.getAttribute("allMenusByRestaurant"); 
  		
 		if(menus!=null){
  		for(Menu menu: menus){%>
  

  	<div class="menu-container">
    <div class="menu-item">
      <img src="<%=menu.getImagepath() %>" alt="<%=menu.getItemname() %>" class="item-img" />
      <div class="item-details">
        <h3><%=menu.getItemname() %></h3>
        <p><%=menu.getDescription() %></p>
        <div class="price-rating">
          <span class="price"><%=menu.getPrice() %></span>
          <span class="rating">⭐<%=menu.getRating() %></span>
        </div>
        <form action="${pageContext.request.contextPath}/CartServlet" method="post">
  <input type="hidden" name="menuId" value="<%=menu.getMenuId()%>">
  <input type="hidden" name="itemname" value="<%=menu.getItemname()%>">
  <input type="hidden" name="price" value="<%=menu.getPrice()%>">
  <input type="hidden" name="quantity" value="1"> <!-- default quantity -->
  <input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId()%>">
  <button type="submit" class="add-cart-btn">Add to Cart</button>
</form>
        
        
        
      </div>
    </div>
  </div>
  
  
  
  <%}}%><%else {
%>
    <p>No menu items available.</p>
<%
    }
%>
</body>
</html>
