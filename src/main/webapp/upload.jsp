<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tests Upload de Fichiers</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .test-form { border: 1px solid #ccc; padding: 15px; margin: 15px 0; border-radius: 5px; }
        h2 { color: #333; }
        input, textarea { padding: 8px; margin: 5px 0; width: 300px; }
        button { padding: 10px 20px; background: #007bff; color: white; border: none; border-radius: 3px; cursor: pointer; }
        button:hover { background: #0056b3; }
    </style>
</head>
<body>
    <h1>Tests Upload de Fichiers - Sprint 10</h1>
    
    <!-- TEST 1: Upload simple avec byte[] parameter -->
    <div class="test-form">
        <h2>TEST 1: Upload Simple (byte[] parameter)</h2>
        <form action="upload/single" method="POST" enctype="multipart/form-data">
            <input type="file" name="file" required>
            <button type="submit">Envoyer</button>
        </form>
    </div>
    
    <!-- TEST 2: Upload multiple avec Map -->
    <div class="test-form">
        <h2>TEST 2: Upload Multiple (Map parameter)</h2>
        <form action="upload/multi" method="POST" enctype="multipart/form-data">
            <input type="file" name="document1" required>
            <input type="file" name="document2">
            <input type="file" name="document3">
            <button type="submit">Envoyer</button>
        </form>
    </div>
    
    <!-- TEST 3: Upload avec POJO -->
    <div class="test-form">
        <h2>TEST 3: Upload Profile (POJO avec byte[])</h2>
        <form action="upload/profile" method="POST" enctype="multipart/form-data">
            <input type="text" name="uploadProfile.name" placeholder="Nom" required>
            <input type="file" name="photo" required>
            <button type="submit">Envoyer</button>
        </form>
    </div>
    
    <hr>
    <p><a href="index.html">Retour</a></p>
</body>
</html>
