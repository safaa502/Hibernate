package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.services.CategorieService;
import ma.projet.entities.Categorie;

public final class Categorie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("          <link rel=\"stylesheet\" type=\"text/css\" href=\"Style/categorie.css\">\n");
      out.write("           <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("    <title>Gestion des catégories</title>\n");
      out.write("    <style>\n");
      out.write("                    .sidebar {\n");
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
      out.write("        /* Styles pour le popup */\n");
      out.write("        #popup {\n");
      out.write("            display: none;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 50%;\n");
      out.write("            left: 50%;\n");
      out.write("            transform: translate(-50%, -50%);\n");
      out.write("            background-color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n");
      out.write("        }\n");
      out.write("           .icon{\n");
      out.write("            margin-right: 15px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
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
      out.write("\n");
      out.write("    <div class=\"container\"  style=\"margin-left: 300px; margin-top: 10px\">\n");
      out.write("    <form action=\"CategorieController\" method=\"post\">\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Gestion des catégories</legend>\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Code: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"code\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Libelle : </td>\n");
      out.write("                    <td><input type=\"text\" name=\"libelle\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" id=\"op\" name=\"op\" value=\"add\" hidden/>\n");
      out.write("                        <input type=\"submit\" value=\"Valider\"  />\n");
      out.write("                    </td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </fieldset>\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("    <fieldset>\n");
      out.write("        <legend>Liste des catégories</legend>\n");
      out.write("        <form action=\"CategorieController\" method=\"get\">\n");
      out.write("            <label for=\"categoryId\">Filtrer par ID de catégorie : </label>\n");
      out.write("            <input type=\"text\" id=\"op\" name=\"op\" value=\"search\" hidden/>\n");
      out.write("            <input type=\"text\" id=\"categoryId\" name=\"id\" />\n");
      out.write("            <button type=\"submit\">Recherche</button>\n");
      out.write("        </form>\n");
      out.write("        <table border=\"0\" width=\"50%\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Id</th>\n");
      out.write("                    <th>Code</th>\n");
      out.write("                    <th>Libelle</th>\n");
      out.write("                    <th>Supprimer</th>\n");
      out.write("                    <th>Modifier</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                     <td>");
      out.print( c.getId() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getCode() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getLibelle() );
      out.write("</td>\n");
      out.write("                    <td><a href=\"CategorieController?op=delete&id=");
      out.print(c.getId() );
      out.write("\" class=\"delete-button\">Supprimer</a></td>\n");
      out.write("                    <td><a href=\"#\" onclick=\"openPopup('");
      out.print(c.getId() );
      out.write("', '");
      out.print(c.getCode() );
      out.write("', '");
      out.print(c.getLibelle() );
      out.write("')\" class=\"modify-button\">Modifier</a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( c.getId() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getCode() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getLibelle() );
      out.write("</td>\n");
      out.write("                    <td><a href=\"CategorieController?op=delete&id=");
      out.print(c.getId() );
      out.write("\"class=\"delete-button\">Supprimer</a></td>\n");
      out.write("                    <td><a href=\"#\" onclick=\"openPopup('");
      out.print(c.getId() );
      out.write("', '");
      out.print(c.getCode() );
      out.write("', '");
      out.print(c.getLibelle() );
      out.write("')\" class=\"modify-button\">Modifier</a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"4\">");
      out.print( errorMessage );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("    </fieldset>\n");
      out.write("\n");
      out.write("    <!-- Popup pour la modification -->\n");
      out.write("    <div style=\"margin-left: 110px;\" id=\"popup\">\n");
      out.write("        <h2>Modifier la catégorie</h2>\n");
      out.write("        <form action=\"CategorieController\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" id=\"updateCategoryId\" name=\"id\" />\n");
      out.write("            Code: <input type=\"text\" id=\"updateCode\" name=\"code\" /><br />\n");
      out.write("            Libelle: <input type=\"text\" id=\"updateLibelle\" name=\"libelle\" /><br />\n");
      out.write("            <input type=\"hidden\" id=\"updateOp\" name=\"op\" value=\"update\" />\n");
      out.write("            <input type=\"submit\" value=\"Enregistrer\" />\n");
      out.write("        </form>\n");
      out.write("        <button  style=\"padding: 8px 16px;background-color: #154C71;color: #fff;border: none;cursor: pointer;margin-right: 0px; \" onclick=\"closePopup()\">Fermer</button>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- JavaScript pour le popup -->\n");
      out.write("    <script>\n");
      out.write("        function openPopup(id, code, libelle) {\n");
      out.write("            document.getElementById(\"updateCategoryId\").value = id;\n");
      out.write("            document.getElementById(\"updateCode\").value = code;\n");
      out.write("            document.getElementById(\"updateLibelle\").value = libelle;\n");
      out.write("            document.getElementById(\"popup\").style.display = \"block\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function closePopup() {\n");
      out.write("            document.getElementById(\"popup\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        function navigateTo(destination) {\n");
      out.write("            if (destination === 'categorie') {\n");
      out.write("                window.location.href = 'Categorie.jsp'; // Remplacez par l'URL de votre page de gestion des catégories\n");
      out.write("            } else if (destination === 'produit') {\n");
      out.write("                window.location.href = 'Produit.jsp'; // Remplacez par l'URL de votre page de gestion des produits\n");
      out.write("            } else if (destination === 'commande') {\n");
      out.write("                window.location.href = 'Commande.jsp'; // Remplacez par l'URL de votre page de gestion des commandes\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("   \n");
      out.write("    </script>\n");
      out.write("   </div> \n");
      out.write("</body>\n");
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
