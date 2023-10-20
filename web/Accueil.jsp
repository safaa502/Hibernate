<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Menu de Gestion</title>
</head>
<body>
    <h1>Application de gestion de stock </h1>
    <form method="get" action="GestionController">
        <button type="submit" name="action" value="categorie">Gestion de catégorie</button>
        <br>
        <button type="submit" name="action" value="produit">Gestion des produits</button>
        <br>
        <button type="submit" name="action" value="commande">Gestion de commande</button>
    </form>
</body>
</html>
