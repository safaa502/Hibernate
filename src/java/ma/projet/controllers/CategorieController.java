/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.entities.Categorie;
import ma.projet.services.CategorieService;

/**
 *
 * @author Lachgar
 */
@WebServlet(name = "CategorieController", urlPatterns = {"/CategorieController"})
public class CategorieController extends HttpServlet {

    private CategorieService cs;

    @Override
    public void init() throws ServletException {
        super.init();
        cs = new CategorieService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("op") != null) {
            String op = request.getParameter("op");

            if (op.equals("search")) {
                String searchId = request.getParameter("id");
                List<Categorie> categories = new ArrayList<>();
                String errorMessage = null;

                if (searchId != null && !searchId.isEmpty()) {
                    try {
                        int categoryId = Integer.parseInt(searchId);
                        Categorie categorie = cs.getById(categoryId);

                        if (categorie != null) {
                            // Catégorie trouvée, ajoutez-la à la liste des catégories à afficher
                            categories.add(categorie);
                        } else {
                            errorMessage = "Aucune catégorie avec cet ID.";
                        }
                    } catch (NumberFormatException e) {
                        errorMessage = "Veuillez entrer un numéro entier.";
                    }
                } else {
                    errorMessage = "L'ID de recherche est vide.";
                }

                request.setAttribute("categories", categories);
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("Categorie.jsp").forward(request, response);
            } else if (op.equals("delete")) {
                cs.delete(cs.getById(Integer.parseInt(request.getParameter("id"))));
                response.sendRedirect("Categorie.jsp");

            } else if (op.equals("update")) {
                int categoryId = Integer.parseInt(request.getParameter("id"));
                String code = request.getParameter("code");
                String libelle = request.getParameter("libelle");

                // Mettre à jour la catégorie
                CategorieService cs = new CategorieService(); 
                Categorie categorie = cs.getById(categoryId); 
                categorie.setCode(code); 
                categorie.setLibelle(libelle); 

                boolean updated = cs.update(categorie); 

                if (updated) {
                    response.sendRedirect("Categorie.jsp"); 
                } else {
        // Gérer l'erreur de mise à jour, par exemple en affichant un message d'erreur
                    // Vous pouvez également rediriger vers une page d'erreur
                    // ou afficher un message d'erreur sur la page de modification.
                    // Exemple : request.setAttribute("errorMessage", "Erreur de mise à jour");
                    //          request.getRequestDispatcher("Erreur.jsp").forward(request, response);
                }
            } else if (op.equals("add")) {
                String code = request.getParameter("code");
                String libelle = request.getParameter("libelle");
                cs.create(new Categorie(code, libelle));
                response.sendRedirect("Categorie.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}