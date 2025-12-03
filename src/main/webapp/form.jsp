<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Framework Tests</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 900px;
            margin: 20px auto;
            padding: 20px;
        }
        .test-section {
            border: 1px solid #ccc;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .form-section {
            background-color: #f0f8ff;
            border: 2px solid #4CAF50;
        }
        h2 {
            color: #333;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 5px;
        }
        h3 {
            color: #555;
        }
        form {
            margin: 10px 0;
        }
        input, button {
            margin: 5px 0;
            padding: 8px;
            width: 300px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px 20px;
            width: auto;
        }
        button:hover {
            background-color: #45a049;
        }
        .link-test {
            margin: 10px 0;
        }
        .category-entry input {
            width: 280px;
        }
        a {
            color: #2196F3;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Tests du Framework MVC</h1>
    
    <h2>📝 FORMULAIRES DE TEST</h2>
    
    <div class="test-section form-section">
        <h2>FORMULAIRE 1: Map&lt;String, Object&gt; (Sprint 8)</h2>
        <h3>POST /params - Tous les paramètres dans un Map (POST uniquement)</h3>
        <form action="params" method="POST" target="_blank">
            <input type="text" name="param1" placeholder="Paramètre 1" value="value1"><br>
            <input type="text" name="param2" placeholder="Paramètre 2" value="value2"><br>
            <input type="text" name="param3" placeholder="Paramètre 3" value="value3"><br>
            <input type="text" name="param4" placeholder="Paramètre 4" value="value4"><br>
            <button type="submit">📤 Tester Map</button>
        </form>
    </div>
    
    <div class="test-section form-section">
        <h2>FORMULAIRE 2: Double  (Sprint 8 bis)</h2>
        <h3>POST /order - User et Product (2 objets)</h3>
        <form action="order" method="POST" target="_blank">
            <h4>👤 Utilisateur</h4>
            <input type="text" name="user.name" placeholder="Nom" value="Alice Martin" required><br>
            <input type="number" name="user.age" placeholder="Age" value="28" required><br>
            <input type="email" name="user.email" placeholder="Email" value="alice@example.com" required><br>
            <input type="date" name="user.birthDate" placeholder="Date de naissance" value="1994-05-12" required><br>
            <h5>🎭 Genre</h5>
            <input type="text" name="user.genre.id" placeholder="Identifiant Genre" value="G1" required><br>
            <input type="text" name="user.genre.name" placeholder="Nom du Genre" value="Premium" required><br>
            
            <h4>📦 Produit</h4>
            <input type="text" name="product.name" placeholder="Nom du produit" value="Laptop Dell" required><br>
            <input type="number" step="0.01" name="product.price" placeholder="Prix" value="1299.99" required><br>
            <input type="number" name="product.quantity" placeholder="Quantité" value="1" required><br>
            <h5>📁 Catégories (liste de cases à cocher)</h5>
            <div class="category-entry">
                <label><input type="checkbox" name="product.category[].name" value="Informatique" checked> Informatique</label><br>
            </div>
            <div class="category-entry">
                <label><input type="checkbox" name="product.category[].name" value="Accessoires" checked> Accessoires</label><br>
            </div>
            <div class="category-entry">
                <label><input type="checkbox" name="product.category[].name" value="Électronique"> Électronique</label><br>
            </div>
            
            <button type="submit">🛒 Tester Double </button>
        </form>
    </div>
    
    <hr>
    <h2>🔗 TESTS RAPIDES (Liens directs)</h2>
    
    <div class="test-section">
        <h3>TEST 1: GET et POST automatique (Sprint 7)</h3>
        <a href="home" target="_blank">GET /home</a> | 
        <form action="home" method="POST" target="_blank" style="display:inline;">
            <button type="submit">POST /home</button>
        </form>
    </div>
    
    <div class="test-section">
        <h3>TEST 2: GET avec paramètre (Sprint 6)</h3>
        <a href="profile?id=123" target="_blank">GET /profile?id=123</a>
    </div>
    
    <div class="test-section">
        <h3>TEST 3: Path variable (Sprint 6 ter)</h3>
        <a href="user/42" target="_blank">GET /user/42</a>
    </div>
    
    <div class="test-section">
        <h3>TEST 4: @RequestParameter (Sprint 6 bis)</h3>
        <a href="search?query=java&page=1" target="_blank">GET /search?q=java&page=1</a>
    </div>
    
    <hr>
</body>
</html>
