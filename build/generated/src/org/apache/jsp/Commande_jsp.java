package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.services.CommandeService;
import ma.projet.entities.Commande;
import ma.projet.entities.Produit;
import ma.projet.services.ProduitService;
import ma.projet.services.LigneCommandeProduitService;

public final class Commande_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("          <link rel=\"stylesheet\" type=\"text/css\" href=\"Style/categorie.css\">\n");
      out.write("           <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("        <title>Gestion des Commandes</title>\n");
      out.write("        <style>\n");
      out.write("                .sidebar {\n");
      out.write("            position: fixed;\n");
      out.write("            left: 0;\n");
      out.write("            top: 0;\n");
      out.write("            height: 100%;\n");
      out.write("            width: 250px; /* Largeur du sidebar */\n");
      out.write("            background-color:#18242F; /* Fond noir */\n");
      out.write("            overflow-x: hidden;\n");
      out.write("            padding-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Style pour les boutons du sidebar */\n");
      out.write("        .sidebar button {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            background-color:#18242F;\n");
      out.write("            border: none;\n");
      out.write("            color: white;\n");
      out.write("            text-align: left;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar button:hover {\n");
      out.write("            background-color: #444;\n");
      out.write("        }\n");
      out.write("                 .icon{\n");
      out.write("            margin-right: 15px;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          \n");
      out.write("     <div class=\"sidebar\">\n");
      out.write("         <img src=\"Image/icone.png\" width=\"30%\" height=\"10%\"/>\n");
      out.write("\n");
      out.write("          <br><br><br>\n");
      out.write("    <button onclick=\"navigateTo('categorie')\">\n");
      out.write("        <span class=\"icon\"><i class=\"fas fa-list\"></i></span> Gestion des catégories <br><br>\n");
      out.write("    </button>\n");
      out.write("    <button onclick=\"navigateTo('produit')\">\n");
      out.write("        <span class=\"icon\"><i class=\"fas fa-cubes\"></i></span> Gestion des produits <br><br>\n");
      out.write("    </button>\n");
      out.write("    <button onclick=\"navigateTo('commande')\">\n");
      out.write("        <span class=\"icon\"><i class=\"fas fa-shopping-cart\"></i></span> Gestion de commande<br><br>\n");
      out.write("    </button>\n");
      out.write("</div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"container\" style=\"margin-left: 300px; margin-top: 10px\">\n");
      out.write("            <br>          \n");
      out.write("        <!-- List of Orders with Details -->\n");
      out.write("        <fieldset>\n");
      out.write("     \n");
      out.write("            <legend>Liste des Commandes</legend>\n");
      out.write("        \n");
      out.write("            <table border=\"0\" >\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Commande ID</th>\n");
      out.write("                    <th>Date</th>\n");
      out.write("                    <th>Ref</th>\n");
      out.write("                    <th>Prix Unitaire</th>\n");
      out.write("                    <th>Quantité</th>\n");
      out.write("                    <th>Total Commande</th>\n");
      out.write("                    <th>Actions</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    CommandeService cs = new CommandeService();
                    for (Commande c : cs.findAll()) {
                
      out.write("\n");
      out.write("                <!-- Loop through orders and display order details -->\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <td rowspan=\"3\">");
      out.print( c.getId());
      out.write("</td>\n");
      out.write("                    <td rowspan=\"3\">");
      out.print( c.getDate());
      out.write("</td>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td rowspan=\"3\"> DH</td>\n");
      out.write("                    <td rowspan=\"3\">\n");
      out.write("                        <a href=\"CategorieController?op=delete&id=");
      out.print(c.getId() );
      out.write("\" class=\"delete-button\">Supprimer</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <!-- Loop through products for this order -->\n");
      out.write("                ");

                    ProduitService ps = new ProduitService();

                    List<LigneCommandeProduit> products = ps.findProduitByCommandeObject(cs.getById(c.getId()));
                    for (LigneCommandeProduit lcp : products) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( lcp.getProduit().getReference());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( lcp.getProduit().getPrix());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( lcp.getQuantite());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Repeat for other orders -->\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("</fieldset>\n");
      out.write("            <br>\n");
      out.write("        <!-- Create New Order Form -->\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Créer une Nouvelle Commande</legend>\n");
      out.write("      \n");
      out.write("        <form action=\"CommandeController\" method=\"POST\">\n");
      out.write("            <table border=\"0\" id=\"productTable\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"productSelect\">Sélectionner un Produit :</label></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select id=\"selectProduit\" name=\"produit\" >\n");
      out.write("                            ");

                                ProduitService ps = new ProduitService();
                                List<Produit> produits = ps.findAll();
                                for (Produit p : produits) {
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( p.getId());
      out.write('"');
      out.write('>');
      out.print( p.getReference());
      out.write("</option>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td><label for=\"quantityInput\">Quantité :</label></td>\n");
      out.write("                    <td><input type=\"number\" id=\"quantityInput\" name=\"quantite\" min=\"1\" required></td>\n");
      out.write("                    <td><button type=\"button\" onclick=\"addToPanier()\">Ajouter</button></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <button type=\"submit\">Créer la Commande</button>\n");
      out.write("\n");
      out.write("            <!-- Hidden input fields for panier data -->\n");
      out.write("            <input type=\"hidden\" id=\"panierData\" name=\"panierData\" value=\"\">\n");
      out.write("        </form>\n");
      out.write("  </fieldset>\n");
      out.write("        <table border=\"0\" id=\"panier\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>Référence</th>\n");
      out.write("                    <th>Quantité</th>\n");
      out.write("                    <th>Supprimer</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <!-- Table rows for panier will be added dynamically here -->\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("                    function addToPanier() {\n");
      out.write("                    const select = document.getElementById(\"selectProduit\");\n");
      out.write("                            const selectedOption = select.options[select.selectedIndex];\n");
      out.write("                            const productId = selectedOption.value;\n");
      out.write("                            const productReference = selectedOption.text;\n");
      out.write("                            const quantity = document.getElementById(\"quantityInput\").value;\n");
      out.write("                            // Create a new row for the panier table\n");
      out.write("                            const panierTable = document.getElementById(\"panier\").getElementsByTagName('tbody')[0];\n");
      out.write("                            const newRow = panierTable.insertRow();\n");
      out.write("                            const cell1 = newRow.insertCell(0);\n");
      out.write("                            const cell2 = newRow.insertCell(1);\n");
      out.write("                            const cell3 = newRow.insertCell(2);\n");
      out.write("                            const cell4 = newRow.insertCell(3);\n");
      out.write("                            // Fill the new row with data\n");
      out.write("                            cell1.innerHTML = productId;\n");
      out.write("                            cell2.innerHTML = productReference;\n");
      out.write("                            cell3.innerHTML = quantity;\n");
      out.write("                            cell4.innerHTML = '<button type=\"button\" onclick=\"removeFromPanier(this)\" class=\"delete-button\">Supprimer</button>';\n");
      out.write("                            // Update hidden input field with panier data\n");
      out.write("                            const panierData = document.getElementById(\"panierData\");\n");
      out.write("                            const currentData = panierData.value;\n");
      out.write("                            const newData = `");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentData}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${productId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(',');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("; `;\n");
      out.write("                            panierData.value = newData;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("            function removeFromPanier(button) {\n");
      out.write("            const row = button.parentNode.parentNode;\n");
      out.write("                    row.parentNode.removeChild(row);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("                    function navigateTo(destination) {\n");
      out.write("            if (destination === 'categorie') {\n");
      out.write("                window.location.href = 'Categorie.jsp'; // Remplacez par l'URL de votre page de gestion des catégories\n");
      out.write("            } else if (destination === 'produit') {\n");
      out.write("                window.location.href = 'Produit.jsp'; // Remplacez par l'URL de votre page de gestion des produits\n");
      out.write("            } else if (destination === 'commande') {\n");
      out.write("                window.location.href = 'Commande.jsp'; // Remplacez par l'URL de votre page de gestion des commandes\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
