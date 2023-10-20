package ma.projet.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.entities.Categorie;
import ma.projet.entities.Produit;
import ma.projet.services.CategorieService;
import ma.projet.services.ProduitService;

@WebServlet(name = "ProduitController", urlPatterns = {"/ProduitController"})
public class ProduitController extends HttpServlet {
    private ProduitService produitService;
    private CategorieService categorieService;
    @Override
    public void init() throws ServletException {
        super.init();
        categorieService = new CategorieService();
        produitService = new ProduitService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op == null || op.isEmpty() || op.equals("list")) {
            List<Produit> produits = produitService.findAll();
            request.setAttribute("produits", produits);
 
        } else if (op.equals("add")) {
            // Ajoutez un nouveau produit
            String reference = request.getParameter("reference");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int categorieId = Integer.parseInt(request.getParameter("categorie"));

            Categorie categorie = categorieService.getById(categorieId);
            Produit produit = new Produit(reference, prix, categorie);

            if (produitService.create(produit)) {
                // Redirigez vers la liste des produits après l'ajout
                response.sendRedirect("Produit.jsp");
                return;
            } else {
                // Gérer les erreurs d'ajout ici, par exemple, afficher un message d'erreur
                request.setAttribute("error", true);
            }
        } else if (op.equals("edit")) {
            // Éditez un produit existant
            int produitId = Integer.parseInt(request.getParameter("id"));
            Produit produit = produitService.getById(produitId);

            // Stockez le produit dans un attribut de la requête
            request.setAttribute("produit", produit);
                    request.getRequestDispatcher("Produit.jsp").forward(request, response);

            
        } else if (op.equals("update")) {
            // Mettez à jour un produit existant
            int produitId = Integer.parseInt(request.getParameter("id"));
            Produit produit = produitService.getById(produitId);

            String reference = request.getParameter("reference");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int categorieId = Integer.parseInt(request.getParameter("categorie"));

            Categorie categorie = categorieService.getById(categorieId);

            produit.setReference(reference);
            produit.setPrix(prix);
            produit.setCategorie(categorie);

            if (produitService.update(produit)) {
                // Redirigez vers la liste des produits après la mise à jour
                response.sendRedirect("Produit.jsp");
                return;
            } else {
                // Gérer les erreurs de mise à jour ici, par exemple, afficher un message d'erreur
                request.setAttribute("error", true);
            }
        } else if (op.equals("delete")) {
            // Supprimez un produit existant
            int produitId = Integer.parseInt(request.getParameter("id"));
            produitService.delete(produitService.getById(produitId));
            // Redirigez vers la liste des produits après la suppression
           response.sendRedirect("Produit.jsp");
            
        } else if (op.equals("search2")) {
            String searchId = request.getParameter("id");
            List<Produit> produits = new ArrayList<>();
            String errorMessage = null;

            if (searchId != null && !searchId.isEmpty()) {
                try {
                    int produitId = Integer.parseInt(searchId);
                    Produit produit = produitService.getById(produitId);

                    if (produit != null) {
                        // Produit trouvé, ajoutez-le à la liste des produits à afficher
                        produits.add(produit);
                    } else {
                        errorMessage = "Aucun produit avec cet ID.";
                    }
                } catch (NumberFormatException e) {
                    errorMessage = "Veuillez entrer un numéro entier.";
                }
            } else {
                                    response.sendRedirect("Produit.jsp"); 
                                    return;
            }

            request.setAttribute("produits", produits);
            request.setAttribute("errorMessage", errorMessage);
                    request.getRequestDispatcher("Produit.jsp").forward(request, response);
        }

        // Redirigez vers la page produits.jsp avec les données mises à jour
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Gestion des produits";
    }
}