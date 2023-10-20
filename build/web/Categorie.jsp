<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="Style/categorie.css">
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <title>Gestion des catégories</title>
    <style>
                    .sidebar {
            position: fixed;
            left: 0;
            top: 0;
            height: 100%;
            width: 250px; /* Largeur du sidebar */
            background-color:#18242F; /* Fond noir */
            overflow-x: hidden;
            padding-top: 20px;
        }

        /* Style pour les boutons du sidebar */
        .sidebar button {
            width: 100%;
            padding: 10px;
            background-color:#18242F;
            border: none;
            color: white;
            text-align: left;
            font-size: 16px;
        }

        .sidebar button:hover {
            background-color: #444;
        }
        /* Styles pour le popup */
        #popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        }
           .icon{
            margin-right: 15px;
        }
    </style>
</head>
<body>
    
     <div class="sidebar">
         <img src="Image/icone.png" width="30%" height="10%"/>

          <br><br><br>
    <button onclick="navigateTo('categorie')">
        <span class="icon"><i class="fas fa-list"></i></span> Gestion des catégories <br><br>
    </button>
    <button onclick="navigateTo('produit')">
        <span class="icon"><i class="fas fa-cubes"></i></span> Gestion des produits <br><br>
    </button>
    <button onclick="navigateTo('commande')">
        <span class="icon"><i class="fas fa-shopping-cart"></i></span> Gestion de commande<br><br>
    </button>
</div>

    <div class="container"  style="margin-left: 300px; margin-top: 10px">
    <form action="CategorieController" method="post">
        <fieldset>
            <legend>Gestion des catégories</legend>
            <table border="0">
                <tr>
                    <td>Code: </td>
                    <td><input type="text" name="code" value="" /></td>
                </tr>
                <tr>
                    <td>Libelle : </td>
                    <td><input type="text" name="libelle" value="" /></td>
                </tr>
                <tr>
                    <td>
                        <input type="text" id="op" name="op" value="add" hidden/>
                        <input type="submit" value="Valider"  />
                    </td>
                    <td></td>
                </tr>
            </table>
        </fieldset>
    </form>
    
    <fieldset>
        <legend>Liste des catégories</legend>
        <form action="CategorieController" method="get">
            <label for="categoryId">Filtrer par ID de catégorie : </label>
            <input type="text" id="op" name="op" value="search" hidden/>
            <input type="text" id="categoryId" name="id" />
            <button type="submit">Recherche</button>
        </form>
        <table border="0" width="50%">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Code</th>
                    <th>Libelle</th>
                    <th>Supprimer</th>
                    <th>Modifier</th>
                </tr>
            </thead>
            <tbody>
                <%
                    CategorieService cs = new CategorieService();
                    String searchId = request.getParameter("id");
                    String errorMessage = ""; // Message d'erreur initialisé à vide

                    if (searchId != null && !searchId.isEmpty()) {
                        try {
                            int categoryId = Integer.parseInt(searchId);
                            boolean categoryFound = false; // Variable pour vérifier si une catégorie correspondante a été trouvée

                            for (Categorie c : cs.findAll()) {
                                if (c.getId() == categoryId) {
                                    // Une catégorie correspondante a été trouvée, affichez-la
                %>
                <tr>
                     <td><%= c.getId() %></td>
                    <td><%= c.getCode() %></td>
                    <td><%= c.getLibelle() %></td>
                    <td><a href="CategorieController?op=delete&id=<%=c.getId() %>" class="delete-button">Supprimer</a></td>
                    <td><a href="#" onclick="openPopup('<%=c.getId() %>', '<%=c.getCode() %>', '<%=c.getLibelle() %>')" class="modify-button">Modifier</a></td>
                </tr>
                <%
                                    categoryFound = true;
                                }
                            }

                            if (!categoryFound) {
                                // Aucune catégorie correspondante n'a été trouvée, affichez le message d'erreur
                                errorMessage = "Pas de catégorie avec cet ID.";
                            }
                        } catch (NumberFormatException e) {
                            // Si la conversion en int échoue, c'est que l'utilisateur a entré autre chose qu'un nombre
                            errorMessage = "Veuillez entrer un numéro entier.";
                        }
                    } else {
                        // Si aucun ID de recherche n'est spécifié, afficher toutes les catégories
                        for (Categorie c : cs.findAll()) {
                %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getCode() %></td>
                    <td><%= c.getLibelle() %></td>
                    <td><a href="CategorieController?op=delete&id=<%=c.getId() %>"class="delete-button">Supprimer</a></td>
                    <td><a href="#" onclick="openPopup('<%=c.getId() %>', '<%=c.getCode() %>', '<%=c.getLibelle() %>')" class="modify-button">Modifier</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        
        <%-- Afficher le message d'erreur s'il existe --%>
        <tr>
            <td colspan="4"><%= errorMessage %></td>
        </tr>
    </fieldset>

    <!-- Popup pour la modification -->
    <div style="margin-left: 110px;" id="popup">
        <h2>Modifier la catégorie</h2>
        <form action="CategorieController" method="post">
            <input type="hidden" id="updateCategoryId" name="id" />
            Code: <input type="text" id="updateCode" name="code" /><br />
            Libelle: <input type="text" id="updateLibelle" name="libelle" /><br />
            <input type="hidden" id="updateOp" name="op" value="update" />
            <input type="submit" value="Enregistrer" />
        </form>
        <button  style="padding: 8px 16px;background-color: #154C71;color: #fff;border: none;cursor: pointer;margin-right: 0px; " onclick="closePopup()">Fermer</button>

    </div>

    <!-- JavaScript pour le popup -->
    <script>
        function openPopup(id, code, libelle) {
            document.getElementById("updateCategoryId").value = id;
            document.getElementById("updateCode").value = code;
            document.getElementById("updateLibelle").value = libelle;
            document.getElementById("popup").style.display = "block";
        }

        function closePopup() {
            document.getElementById("popup").style.display = "none";
        }
        
        
        function navigateTo(destination) {
            if (destination === 'categorie') {
                window.location.href = 'Categorie.jsp'; // Remplacez par l'URL de votre page de gestion des catégories
            } else if (destination === 'produit') {
                window.location.href = 'Produit.jsp'; // Remplacez par l'URL de votre page de gestion des produits
            } else if (destination === 'commande') {
                window.location.href = 'Commande.jsp'; // Remplacez par l'URL de votre page de gestion des commandes
            }
        }
   
    </script>
   </div> 
</body>
</html>