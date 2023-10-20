/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controllers;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author hachem safae
 */
@WebServlet("/AccueilController")
public class  AccueilController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("categorie")) {
                // Traitez la gestion de catégorie ici
                request.getRequestDispatcher("Categorie.jsp").forward(request, response);
            } else if (action.equals("produit")) {
                // Traitez la gestion de produit ici
                request.getRequestDispatcher("Produit.jsp").forward(request, response);
            } else if (action.equals("commande")) {
                // Traitez la gestion de commande ici
                request.getRequestDispatcher("Commande.jsp").forward(request, response);
            } else {
                // Gérer le cas où l'action est inconnue
                response.sendRedirect("page-d-erreur.jsp");
            }
        }
    }
}

