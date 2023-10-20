<%-- 
    Document   : Categorie
    Created on : 4 oct. 2023, 11:52:10
    Author     : Lachgar
--%>

<%@page import="java.util.List"%>
<%@page import="ma.projet.entities.LigneCommandeProduit"%>
<%@page import="ma.projet.services.CommandeService"%>
<%@page import="ma.projet.entities.Commande"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page import="ma.projet.services.LigneCommandeProduitService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
          <link rel="stylesheet" type="text/css" href="Style/categorie.css">
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <title>Gestion des Commandes</title>
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
        
        
        <div class="container" style="margin-left: 300px; margin-top: 10px">
            <br>          
        <!-- List of Orders with Details -->
        <fieldset>
     
            <legend>Liste des Commandes</legend>
        
            <table border="0" >
            <thead>
                <tr>
                    <th>Commande ID</th>
                    <th>Date</th>
                    <th>Ref</th>
                    <th>Prix Unitaire</th>
                    <th>Quantité</th>
                    <th>Total Commande</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    CommandeService cs = new CommandeService();
                    for (Commande c : cs.findAll()) {
                %>
                <!-- Loop through orders and display order details -->
                <tr>

                    <td rowspan="3"><%= c.getId()%></td>
                    <td rowspan="3"><%= c.getDate()%></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td rowspan="3"> DH</td>
                    <td rowspan="3">
                        <a href="CategorieController?op=delete&id=<%=c.getId() %>" class="delete-button">Supprimer</a>
                    </td>
                </tr>

                <!-- Loop through products for this order -->
                <%
                    ProduitService ps = new ProduitService();

                    List<LigneCommandeProduit> products = ps.findProduitByCommandeObject(cs.getById(c.getId()));
                    for (LigneCommandeProduit lcp : products) {
                %>
                <tr>
                    <td><%= lcp.getProduit().getReference()%></td>
                    <td><%= lcp.getProduit().getPrix()%></td>
                    <td><%= lcp.getQuantite()%></td>
                </tr>
                <%
                    }
                %>

                <!-- Repeat for other orders -->
                <%
                    }
                %>
            </tbody>

        </table>
</fieldset>
            <br>
        <!-- Create New Order Form -->
        <fieldset>
            <legend>Créer une Nouvelle Commande</legend>
      
        <form action="CommandeController" method="POST">
            <table border="0" id="productTable">
                <tr>
                    <td><label for="productSelect">Sélectionner un Produit :</label></td>
                    <td>
                        <select id="selectProduit" name="produit" >
                            <%
                                ProduitService ps = new ProduitService();
                                List<Produit> produits = ps.findAll();
                                for (Produit p : produits) {
                            %>
                            <option value="<%= p.getId()%>"><%= p.getReference()%></option>
                            <% }%>
                        </select>
                    </td>
                    <td><label for="quantityInput">Quantité :</label></td>
                    <td><input type="number" id="quantityInput" name="quantite" min="1" required></td>
                    <td><button type="button" onclick="addToPanier()">Ajouter</button></td>
                </tr>
            </table>
            <button type="submit">Créer la Commande</button>

            <!-- Hidden input fields for panier data -->
            <input type="hidden" id="panierData" name="panierData" value="">
        </form>
  </fieldset>
        <table border="0" id="panier">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Référence</th>
                    <th>Quantité</th>
                    <th>Supprimer</th>
                </tr>
            </thead>
            <tbody>
                <!-- Table rows for panier will be added dynamically here -->
            </tbody>
        </table>

        <script>
                    function addToPanier() {
                    const select = document.getElementById("selectProduit");
                            const selectedOption = select.options[select.selectedIndex];
                            const productId = selectedOption.value;
                            const productReference = selectedOption.text;
                            const quantity = document.getElementById("quantityInput").value;
                            // Create a new row for the panier table
                            const panierTable = document.getElementById("panier").getElementsByTagName('tbody')[0];
                            const newRow = panierTable.insertRow();
                            const cell1 = newRow.insertCell(0);
                            const cell2 = newRow.insertCell(1);
                            const cell3 = newRow.insertCell(2);
                            const cell4 = newRow.insertCell(3);
                            // Fill the new row with data
                            cell1.innerHTML = productId;
                            cell2.innerHTML = productReference;
                            cell3.innerHTML = quantity;
                            cell4.innerHTML = '<button type="button" onclick="removeFromPanier(this)" class="delete-button">Supprimer</button>';
                            // Update hidden input field with panier data
                            const panierData = document.getElementById("panierData");
                            const currentData = panierData.value;
                            const newData = `${currentData}${productId},${quantity}; `;
                            panierData.value = newData;
                    }

            function removeFromPanier(button) {
            const row = button.parentNode.parentNode;
                    row.parentNode.removeChild(row);
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