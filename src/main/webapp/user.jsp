<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        h1 {
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <h1>User Profile</h1>
    <p><strong>User ID:</strong> ${userId}</p>
    <p><strong>Message:</strong> ${message}</p>
</body>
</html>
