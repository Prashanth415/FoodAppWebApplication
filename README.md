Food Delivery Web Application is a full-stack Java-based web project that allows users to browse restaurants, view menus, add items to a cart, and place orders — similar to platforms like Swiggy or Zomato. It was developed using Java (Servlets, JSP) for the backend, HTML/CSS for the frontend, and MySQL for database management.
The application supports key e-commerce features such as:
  -> Dynamic restaurant and menu listing
  -> Add to cart with quantity control
  -> Session-based cart management
  -> Order placement and order item storage
  -> Order confirmation with order ID and total amount
This project helped me apply backend logic, database connectivity, and frontend integration — taught at Tap Academy by Ravi Sir.

# 🍽️ Food Delivery Web Application

A complete food ordering web application built using Java Servlets, JSP, HTML, CSS, and MySQL — inspired by real-world platforms like Swiggy and Zomato.

## 🚀 Features

- View list of restaurants
- Display menu items dynamically based on restaurant selection
- Add items to cart with quantity management
- Cart page to review and modify order before placing
- Place order functionality with order confirmation
- Stores order and order items in MySQL database
- Clean UI with HTML/CSS
- Session-based cart management

## 🛠️ Tech Stack

- **Frontend:** HTML, CSS
- **Backend:** Java (Servlets, JSP)
- **Database:** MySQL
- **Server:** Apache Tomcat

## 📁 Project Structure

├── src/
│ ├── servlet/
│ │ ├── HomeServlet.java
│ │ ├── MenuServlet.java
│ │ ├── CartServlet.java
│ │ ├── PlaceOrderServlet.java
│ └── dao/
│ ├── RestaurantDaoImpl.java
│ ├── MenuItemDaoImpl.java
│ ├── OrderDaoImpl.java
│ ├── OrderItemDaoImpl.java
│ └── model/
│ ├── Restaurant.java
│ ├── MenuItem.java
│ ├── CartItem.java
│ ├── Order.java
│ ├── OrderItem.java
├── WebContent/
│ ├── index.jsp
│ ├── home.jsp
│ ├── menu.jsp
│ ├── cart.jsp
│ └── orderConfirmation.jsp


## 💡 How It Works

1. **Home Page:** Displays list of restaurants from DB.
2. **Menu Page:** Shows items for selected restaurant using `MenuServlet`.
3. **Cart Page:** Users can add/remove items and change quantities.
4. **Place Order:** Submits order and saves it to the database using transactions.
5. **Order Confirmation:** Displays Order ID and Total Amount.

## 🧠 Learning Outcome

- MVC architecture using Servlets and JSP
- JDBC-based database interaction
- Web session management
- Full-stack integration of frontend and backend
- Real-time project building experience

## 📷 Demo

👉 https://drive.google.com/file/d/1LPYwRGPlKwSD4T0c5458ea89zLA6ANHj/view?usp=drive_link
👉 https://github.com/Prashanth415/FoodAppWebApplication/

## 📌 Author

- Prashanth A (Prashanth415)

## 🏷️ Tags

`#Java` `#JSP` `#Servlets` `#MySQL` `#WebDevelopment` `#FoodDeliveryApp` `#TapAcademy`
