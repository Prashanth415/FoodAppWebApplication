<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .confirmation-container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            padding: 30px;
            width: 100%;
            max-width: 500px;
            text-align: center;
        }
        .success-icon {
            color: #4CAF50;
            font-size: 50px;
            margin-bottom: 20px;
        }
        .order-details {
            margin: 20px 0;
            text-align: left;
            padding: 15px;
            background-color: #f9f9f9;
            border-radius: 5px;
        }
        .detail-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 8px;
        }
        .detail-label {
            font-weight: bold;
            color: #555;
        }
        .detail-value {
            color: #333;
        }
        .btn-home {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
        .btn-home:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="confirmation-container">
        <div class="success-icon">✓</div>
        <h1>Thank you for your order!</h1>
        
        <p class="info-message">Your delicious meal is being prepared. You'll receive it shortly.</p>
        
        
        <a href="HomeServlet" class="btn-home">Back to Home</a>
    </div>
    
    <%-- Clear session attributes after displaying --%>
    
</body>
</html>