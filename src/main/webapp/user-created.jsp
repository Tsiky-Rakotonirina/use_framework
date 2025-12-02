<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Created</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #4CAF50;
            border-radius: 5px;
            background-color: #f0f8f0;
        }
        h1 {
            color: #4CAF50;
        }
        .success {
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            color: #155724;
            padding: 10px;
            border-radius: 3px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h1>Utilisateur créé avec succès!</h1>
    <div class="success">
        ${message}
    </div>
    <h2>Informations de l'utilisateur:</h2>
    <p><strong>Nom:</strong> ${user.name}</p>
    <p><strong>Age:</strong> ${user.age}</p>
    <p><strong>Email:</strong> ${user.email}</p>
</body>
</html>
