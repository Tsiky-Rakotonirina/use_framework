<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.models.User" %>
<%@ page import="com.example.models.Product" %>
<%@ page import="com.example.models.Genre" %>
<%@ page import="com.example.models.Category" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat</title>
    <meta charset="UTF-8">
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #4CAF50; }
        .section { border: 1px solid #ccc; padding: 15px; margin: 10px 0; border-radius: 5px; }
        .label { font-weight: bold; color: #555; }
    </style>
</head>
<body>
    <h1>${title}</h1>
    
    <%
        Map<String, Object> params = (Map<String, Object>) request.getAttribute("params");
        if (params != null) {
    %>
    <div class="section">
        <h2>Paramètres reçus (Map)</h2>
        <ul>
        <%
            for (Map.Entry<String, Object> entry : params.entrySet()) {
        %>
            <li><span class="label"><%= entry.getKey() %>:</span> <%= entry.getValue() %></li>
        <%
            }
        %>
        </ul>
    </div>
    <%
        }
        
        User user = (User) request.getAttribute("user");
        if (user != null) {
    %>
    <div class="section">
        <h2>Utilisateur (User POJO)</h2>
        <p><span class="label">Nom:</span> <%= user.getName() %></p>
        <p><span class="label">Age:</span> <%= user.getAge() %></p>
        <p><span class="label">Email:</span> <%= user.getEmail() %></p>
        <p><span class="label">Date de naissance:</span> <%= user.getBirthDate() != null ? user.getBirthDate() : "—" %></p>
        <%
            Genre genre = user.getGenre();
            if (genre != null) {
        %>
        <p><span class="label">Genre:</span> <%= genre.getId() %> - <%= genre.getName() %></p>
        <%
            }
        %>
    </div>
    <%
        }
        
        Product product = (Product) request.getAttribute("product");
        if (product != null) {
    %>
    <div class="section">
        <h2>Produit (Product POJO)</h2>
        <p><span class="label">Nom:</span> <%= product.getName() %></p>
        <p><span class="label">Prix:</span> <%= product.getPrice() %> €</p>
        <p><span class="label">Quantité:</span> <%= product.getQuantity() %></p>
        <%
            List<Category> categories = product.getCategory();
            if (categories != null && !categories.isEmpty()) {
        %>
        <div>
            <p><span class="label">Catégories:</span></p>
            <ul>
            <%
                for (Category cat : categories) {
            %>
                <li><%= cat.getName() %></li>
            <%
                }
            %>
            </ul>
        </div>
        <%
            }
        %>
    </div>
    <%
        }
    %>
    
    <hr>
    <a href="form.jsp">← Retour aux tests</a>
</body>
</html>
