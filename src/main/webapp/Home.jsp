<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.Restaurant, java.util.*, java.time.LocalDate" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Restaurant Search - TastyTrack</title>
  <style>
    body {
      margin: 0;
      font-family: 'Segoe UI', sans-serif;
      background-color: #f8f9fa;
    }

    nav {
      background-color: #ff4d4d;
      color: white;
      padding: 1rem 2rem;
      display: flex;
      justify-content: space-between;
      align-items: center;
      flex-wrap: wrap;
      position: sticky;
      top: 0;
      z-index: 1000;
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
      background-color: white;
      border-radius: 20px;
      display: flex;
      align-items: center;
      padding: 0 0.7rem;
    }

    .search-icon {
      font-size: 1rem;
      color: #888;
      margin-right: 0.4rem;
    }

    .search-bar input {
      border: none;
      padding: 0.5rem;
      outline: none;
      font-size: 0.9rem;
      flex: 1;
    }

    .nav-right {
      display: flex;
      gap: 1.5rem;
      align-items: center;
      font-weight: 500;
      font-size: 0.95rem;
    }

    .nav-right li {
      list-style: none;
      cursor: pointer;
    }

    .container {
      padding: 2rem;
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 1.5rem;
    }

    .card {
      background-color: white;
      border-radius: 12px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      overflow: hidden;
      transition: transform 0.3s ease;
    }

    .card:hover {
      transform: translateY(-5px);
    }

    .card img {
      width: 100%;
      height: 180px;
      object-fit: cover;
    }

    .card-content {
      padding: 1rem;
    }

    .card-content h2 {
      font-size: 1.2rem;
      margin: 0 0 0.5rem 0;
    }

    .info {
      font-size: 0.9rem;
      color: #555;
      margin: 0.3rem 0;
    }

    .rating {
      display: flex;
      justify-content: space-between;
      margin-top: 0.5rem;
    }

    .rating span {
      background-color: #48c479;
      color: white;
      padding: 0.2rem 0.5rem;
      border-radius: 6px;
      font-size: 0.8rem;
    }

    .footer {
      background-color: #2e2e2e;
      color: #fff;
      padding: 3rem 2rem 2rem 2rem;
      margin-top: 3rem;
    }

    .footer-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      gap: 2rem;
      max-width: 1200px;
      margin: auto;
    }

    .footer-box {
      flex: 1 1 50px;
    }

    .left-align {
      flex: 1.3 1 300px;
      margin-left: -110px;
    }

    .footer-brand {
      margin-bottom: 1rem;
    }

    .footer-text {
      color: #ccc;
      line-height: 1.6;
    }

    .footer-list {
      list-style: none;
      padding: 0;
    }

    .footer-list li {
      margin-bottom: 0.5rem;
    }

    .footer-list a, .footer-box a {
      color: #ccc;
      text-decoration: none;
      transition: color 0.3s;
    }

    .footer-list a:hover, .footer-box a:hover {
      color: #fff;
    }

    .footer-bottom {
      text-align: center;
      margin-top: 2rem;
      color: #aaa;
      font-size: 0.9rem;
    }
  </style>
</head>
<body>

<nav>
  <div class="nav-left">
    <h1>TastyTrack</h1>
    <div class="search-bar">
      <span class="search-icon">🔍</span>
      <input type="text" id="searchInput" placeholder="Search restaurants..." onkeyup="filterRestaurants()">
    </div>
  </div>
  <ul class="nav-right">
    <li>Home</li>
    <li>Categories</li>
    <li>Cart</li>
    <li>Orders</li>
    <li>Offers</li>
    <li>Help</li>
    <li>Login/Signup</li>
    <li>Profile</li>
  </ul>
</nav>

<!-- Restaurant cards -->
<div class="container" id="restaurantList">
  <%
    List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("allRestaurants");
    if (restaurants == null) restaurants = new ArrayList<>();

    if (!restaurants.isEmpty()) {
      for (Restaurant restaurant : restaurants) {
        java.sql.Time deliveryTimeObj = restaurant.getDeliveryTime();
        int deliveryTime = (deliveryTimeObj != null) 
          ? Math.max((int) (deliveryTimeObj.toLocalTime().toSecondOfDay() / 60), 1)
          : 30;

        String formattedETA = (deliveryTime >= 60) 
          ? (deliveryTime / 60) + " hr" + ((deliveryTime % 60 > 0) ? " " + (deliveryTime % 60) + " min" : "")
          : deliveryTime + " min";
  %>
    <a href="Menu?restaurantId=<%= restaurant.getRestaurantId() %>" style="text-decoration: none; color: inherit;">
      <div class="card">
        <img src="<%= restaurant.getImagepath() %>" alt="<%= restaurant.getName() %>">
        <div class="card-content">
          <h2><%= restaurant.getName() %></h2>
          <p class="info"><%= restaurant.getCuisineType() %></p>
          <div class="rating">
            <span>⭐ <%= restaurant.getRating() %></span>
            <span>🚚 <%= formattedETA %></span>
          </div>
        </div>
      </div>
    </a>
  <% 
      }
    } else {
  %>
    <p style="text-align:center; font-size:18px; color:#888;">❌ No restaurants found.</p>
  <% } %>
</div>

<!-- Footer -->
<footer class="footer">
  <div class="footer-container">
    <div class="footer-box left-align">
      <h2 class="footer-brand">TastyTrack</h2>
      <p class="footer-text">
        Bringing your favorite food from top restaurants<br>at lightning speed. Explore new cuisines and tasty deals daily.
      </p>
    </div>

    <div class="footer-box">
      <h4>Quick Links</h4>
      <ul class="footer-list">
        <li><a href="#">Home</a></li>
        <li><a href="#">Offers</a></li>
        <li><a href="#">Help</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </div>

    <div class="footer-box">
      <h4>Contact Us</h4>
      <p>📞 +91 6303088415</p>
      <p>✉️ Prashanth@tastytrack.in</p>
      <p>📍 Bengaluru, India</p>
    </div>

    <div class="footer-box">
      <h4>Follow Us</h4>
      <p><a href="#">🐦 Twitter</a></p>
      <p><a href="#">📘 Facebook</a></p>
      <p><a href="#">📸 Instagram</a></p>
    </div>
  </div>

  <div class="footer-bottom">
    © <%= LocalDate.now().getYear() %> TastyTrack. All rights reserved.
  </div>
</footer>

<script>
  function filterRestaurants() {
    const input = document.getElementById('searchInput').value.toLowerCase();
    const cards = document.querySelectorAll('.card');

    cards.forEach(card => {
      const name = card.querySelector('h2').innerText.toLowerCase();
      const cuisine = card.querySelector('.info').innerText.toLowerCase();
      card.style.display = (name.includes(input) || cuisine.includes(input)) ? 'block' : 'none';
    });
  }
</script>

</body>
</html>
