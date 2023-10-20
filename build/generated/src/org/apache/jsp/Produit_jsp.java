package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import ma.projet.services.CategorieService;
import ma.projet.services.ProduitService;
import ma.projet.entities.Produit;
import ma.projet.entities.Categorie;

public final class Produit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Gestion des Produits</title>\n");
      out.write("\n");
      out.write("    <!-- Ajouter le CSS pour la boîte modale ici -->\n");
      out.write("    <style>\n");
      out.write("        /* Style pour la boîte modale */\n");
      out.write("        .modal {\n");
      out.write("            display: none; /* Par défaut, masquez la boîte modale */\n");
      out.write("            position: fixed;\n");
      out.write("            z-index: 1;\n");
      out.write("            left: 0;\n");
      out.write("            top: 0;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100%;\n");
      out.write("            overflow: auto;\n");
      out.write("            background-color: rgba(0, 0, 0, 0.4); /* Fond semi-transparent */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .modal-content {\n");
      out.write("            background-color: #fefefe;\n");
      out.write("            margin: 10% auto;\n");
      out.write("            padding: 20px;\n");
      out.write("            border: 1px solid #888;\n");
      out.write("            width: 80%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Style pour le bouton de fermeture */\n");
      out.write("        .close {\n");
      out.write("            color: #aaa;\n");
      out.write("            float: right;\n");
      out.write("            font-size: 28px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .close:hover,\n");
      out.write("        .close:focus {\n");
      out.write("            color: black;\n");
      out.write("            text-decoration: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <form action=\"ProduitController\" method=\"post\">\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Gestion des produits</legend>\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Reference: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"reference\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Prix : </td>\n");
      out.write("                    <td><input type=\"number\" name=\"prix\" step=\"0.01\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Categorie : </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"categorie\">\n");
      out.write("                            ");

                                CategorieService cs = new CategorieService();
                                List<Categorie> categories = cs.findAll();
                                for (Categorie c : categories) {
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( c.getId() );
      out.write('"');
      out.write('>');
      out.print( c.getLibelle() );
      out.write("</option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"hidden\" name=\"op\" value=\"add\" />\n");
      out.write("                        <input type=\"submit\" value=\"Valider\" name=\"valider\" /></td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </fieldset>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <fieldset>\n");
      out.write("        <legend>Liste des produits</legend>\n");
      out.write("         <form action=\"ProduitController\" method=\"get\">\n");
      out.write("            <label for=\"categoryId\">Filtrer par ID de produit : </label>\n");
      out.write("            <input type=\"text\" id=\"op\" name=\"op\" value=\"search2\" hidden/>\n");
      out.write("            <input type=\"text\" id=\"categoryId\" name=\"id\" />\n");
      out.write("            <button type=\"submit\">Recherche</button>\n");
      out.write("        </form>\n");
      out.write("        <table border=\"0\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Reference</th>\n");
      out.write("                    <th>Prix</th>\n");
      out.write("                    <th>Categorie</th>\n");
      out.write("                    <th>Supprimer</th>\n");
      out.write("                    <th>Modifier</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

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

      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( p.getReference() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getPrix() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getCategorie().getLibelle() );
      out.write("</td>\n");
      out.write("                    <td><a href=\"ProduitController?op=delete&id=");
      out.print( p.getId() );
      out.write("\">Supprimer</a></td>\n");
      out.write("                    <!-- Modifier le lien pour ouvrir la boîte modale -->\n");
      out.write("                    <td><a id=\"edit-link-");
      out.print( p.getId() );
      out.write("\" href=\"javascript:void(0);\" onclick=\"setEditFormValues('");
      out.print( p.getId() );
      out.write("', '");
      out.print( p.getReference() );
      out.write("', ");
      out.print( p.getPrix() );
      out.write(", '");
      out.print( p.getCategorie().getId() );
      out.write("')\">Modifier</a></td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("               ");

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

    
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( p.getReference());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getPrix());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getCategorie().getLibelle() );
      out.write("</td>\n");
      out.write("                    <td><a href=\"ProduitController?op=delete&id=");
      out.print(p.getId() );
      out.write("\">Supprimer</a></td>\n");
      out.write("                    <td><a id=\"edit-link-");
      out.print( p.getId() );
      out.write("\" href=\"javascript:void(0);\" onclick=\"setEditFormValues('");
      out.print( p.getId() );
      out.write("', '");
      out.print( p.getReference() );
      out.write("', ");
      out.print( p.getPrix() );
      out.write(", '");
      out.print( p.getCategorie().getId() );
      out.write("')\">Modifier</a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("            <tr>\n");
      out.write("            <td colspan=\"4\">");
      out.print( errorMessage );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("    </fieldset>\n");
      out.write("            \n");
      out.write("\n");
      out.write("    <!-- Formulaire de modification dans une boîte modale -->\n");
      out.write("    <div id=\"modal\" class=\"modal\">\n");
      out.write("        <form id=\"edit-form\" action=\"ProduitController\" method=\"post\" class=\"modal-content\">\n");
      out.write("            <span class=\"close\" onclick=\"closeModal()\">&times;</span>\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Modifier un produit</legend>\n");
      out.write("                <input type=\"hidden\" name=\"op\" value=\"update\" />\n");
      out.write("                <input type=\"hidden\" id=\"edit-id\" name=\"id\" value=\"\" />\n");
      out.write("                Reference: <input type=\"text\" name=\"reference\" id=\"edit-reference\" required /><br>\n");
      out.write("                Prix : <input type=\"number\" name=\"prix\" step=\"0.01\" id=\"edit-prix\" required /><br>\n");
      out.write("                Categorie : <select name=\"categorie\" id=\"edit-categorie\" required>\n");
      out.write("                    ");

                        for (Categorie c : categories) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print( c.getId() );
      out.write('"');
      out.write('>');
      out.print( c.getLibelle() );
      out.write("</option>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </select><br>\n");
      out.write("                <input type=\"submit\" value=\"Valider\" name=\"valider\" />\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Script JavaScript pour la modification -->\n");
      out.write("    <script>\n");
      out.write("        function setEditFormValues(id, reference, prix, categorieId) {\n");
      out.write("            document.getElementById('edit-id').value = id;\n");
      out.write("            document.getElementById('edit-reference').value = reference;\n");
      out.write("            document.getElementById('edit-prix').value = prix;\n");
      out.write("            document.getElementById('edit-categorie').value = categorieId;\n");
      out.write("            \n");
      out.write("            // Afficher la boîte modale\n");
      out.write("            document.getElementById('modal').style.display = 'block';\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function closeModal() {\n");
      out.write("            // Cacher la boîte modale\n");
      out.write("            document.getElementById('modal').style.display = 'none';\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
