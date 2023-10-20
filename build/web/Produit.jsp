<%@page import="java.util.List"%>
<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="Style/categorie.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <title>Gestion des Produits</title>

    <!-- Ajouter le CSS pour la boîte modale ici -->
    <style>
            .sidebar {
            position: fixed;
            left: 0;
            top: 0;
            height: 100%;
            width: 250px; /* Largeur du sidebar */
            background-color: #18242F;
            overflow-x: hidden;
            padding-top: 20px;
        }

        /* Style pour les boutons du sidebar */
        .sidebar button {
            width: 100%;
            padding: 10px;
            background-color: #18242F;
            border: none;
            color: white;
            text-align: left;
            font-size: 16px;
        }

        .sidebar button:hover {
            background-color: #444;
        }
        /* Style pour la boîte modale */
        .modal {
            display: none; /* Par défaut, masquez la boîte modale */
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4); /* Fond semi-transparent */
        }

        .modal-content {
            background-color: #fefefe;
            margin: 10% auto;
            padding: 20px;
           height: 35%;
            width: 20%;
        }

        /* Style pour le bouton de fermeture */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
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
        <span class="icon"><i class="fas fa-list"></i></span>   Gestion des catégories <br><br>
    </button>
    <button onclick="navigateTo('produit')">
        <span class="icon"><i class="fas fa-cubes"></i></span> Gestion des produits <br><br>
    </button>
    <button onclick="navigateTo('commande')">
        <span class="icon"><i class="fas fa-shopping-cart"></i></span> Gestion de commande<br><br>
    </button>
</div>
    <div class="container" style="margin-left: 300px; margin-top: 10px">
    <form action="ProduitController" method="post">
        <fieldset>
            <legend>Gestion des produits</legend>
            <table border="0">
                <tr>
                    <td>Reference: </td>
                    <td><input type="text" name="reference" value="" /></td>
                </tr>
                <tr>
                    <td>Prix : </td>
                    <td><input type="number" name="prix" step="0.01" value="" /></td>
                </tr>
                <tr>
                    <td>Categorie : </td>
                    <td>
                        <select name="categorie">
                            <%
                                CategorieService cs = new CategorieService();
                                List<Categorie> categories = cs.findAll();
                                for (Categorie c : categories) {
                            %>
                            <option value="<%= c.getId() %>"><%= c.getLibelle() %></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="hidden" name="op" value="add" />
                        <input type="submit" value="Valider" name="valider" /></td>
                    <td></td>
                </tr>
            </table>
        </fieldset>
    </form>

    <fieldset>
        <legend>Liste des produits</legend>
         <form action="ProduitController" method="get">
            <label for="categoryId">Filtrer par ID de produit : </label>
            <input type="text" id="op" name="op" value="search2" hidden/>
            <input type="text" id="categoryId" name="id" />
            <button type="submit">Recherche</button>
        </form>
        <table border="0">
            <thead>
                <tr>
                     <th>Id</th>
                    <th>Reference</th>
                    <th>Prix</th>
                    <th>Categorie</th>
                    <th>Supprimer</th>
                    <th>Modifier</th>
                </tr>
            </thead>
            <tbody>
                <%
    ProduitService ps = new ProduitService();
    String searchId = request.getParameter("id");
    String errorMessage = ""; // Message d'erreur initialisé à vide

    if (searchId != null && !searchId.isEmpty()) {
        try {
            int productId = Integer.parseInt(searchId);
            boolean productFound = false; // Variable pour vérifier si un produit correspondant a été trouvé

            for (Produit p : ps.findAll()) {
                if (p.getId() == productId) {
                    // Un produit correspondant a été trouvé, affichez-le
%>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getReference() %></td>
                    <td><%= p.getPrix() %></td>
                    <td><%= p.getCategorie().getLibelle() %></td>
                    <td><a href="ProduitController?op=delete&id=<%= p.getId() %>" class="delete-button">Supprimer</a></td>
                    <!-- Modifier le lien pour ouvrir la boîte modale -->
                    <td><a id="edit-link-<%= p.getId() %>" href="javascript:void(0);" onclick="setEditFormValues('<%= p.getId() %>', '<%= p.getReference() %>', <%= p.getPrix() %>, '<%= p.getCategorie().getId() %>')" class="modify-button">Modifier</a></td>

                </tr>
               <%
                    productFound = true;
                }
            }

            if (!productFound) {
                // Aucun produit correspondant n'a été trouvé, affichez le message d'erreur
                errorMessage = "Pas de produit avec cet ID.";
            }
        } catch (NumberFormatException e) {
            // Si la conversion en int échoue, c'est que l'utilisateur a entré autre chose qu'un nombre
            errorMessage = "Veuillez entrer un numéro entier.";
        }
    } else {
                        // Si aucun ID de recherche n'est spécifié, afficher toutes les catégories
                        for (Produit p : ps.findAll()) {

    %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getReference()%></td>
                    <td><%= p.getPrix()%></td>
                    <td><%= p.getCategorie().getLibelle() %></td>
                    <td><a href="ProduitController?op=delete&id=<%=p.getId() %>"  class="delete-button">Supprimer</a></td>
                    <td><a id="edit-link-<%= p.getId() %>" href="javascript:void(0);" onclick="setEditFormValues('<%= p.getId() %>', '<%= p.getReference() %>', <%= p.getPrix() %>, '<%= p.getCategorie().getId() %>')" class="modify-button">Modifier</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
            <tr>
            <td colspan="4"><%= errorMessage %></td>
        </tr>
    </fieldset>
            

    <!-- Formulaire de modification dans une boîte modale -->
    <div id="modal" class="modal">
        <form style="margin-left: 700px;margin-top: 250px;" id="edit-form" action="ProduitController" method="post" class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
         
                <h2>Modifier un produit</h2><br>
                <input type="hidden" name="op" value="update" />
                <input type="hidden" id="edit-id" name="id" value="" />
                Reference: <input type="text" name="reference" id="edit-reference" required /><br><br>
                Prix : <input style="margin-left: 30px;" type="number" name="prix" step="0.01" id="edit-prix" required /><br><br><br>
                Categorie : <select name="categorie" id="edit-categorie" required><br><br>
                    <%
                        for (Categorie c : categories) {
                    %>
                    <option value="<%= c.getId() %>"><%= c.getLibelle() %></option>
                    <%
                        }
                    %>
                </select><br><br>
                <input type="submit" value="Valider" name="valider" />
           
        </form>
    </div>

    <!-- Script JavaScript pour la modification -->
    <script>
        function setEditFormValues(id, reference, prix, categorieId) {
            document.getElementById('edit-id').value = id;
            document.getElementById('edit-reference').value = reference;
            document.getElementById('edit-prix').value = prix;
            document.getElementById('edit-categorie').value = categorieId;
            
            // Afficher la boîte modale 
            document.getElementById('modal').style.display = 'block';
        }

        function closeModal() {
            // Cacher la boîte modale
            document.getElementById('modal').style.display = 'none';
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