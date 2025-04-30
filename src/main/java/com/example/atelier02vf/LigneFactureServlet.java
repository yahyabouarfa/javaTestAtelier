package com.example.atelier02vf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LigneFactureServlet", urlPatterns = {"/ligneFacture"})
public class LigneFactureServlet extends HttpServlet {

    // Méthode GET (affiche un formulaire simple ou message de test)
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Formulaire Ligne Facture</h2>");
        out.println("<form method='post' action='ligneFacture'>");
        out.println("Produit: <input type='text' name='produit'><br>");
        out.println("Quantité: <input type='number' name='quantite'><br>");
        out.println("Prix: <input type='number' step='0.01' name='prix'><br>");
        out.println("<input type='submit' value='Envoyer'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // Méthode POST (traite les données du formulaire)
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lecture des paramètres
        String produit = request.getParameter("produit");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        double prix = Double.parseDouble(request.getParameter("prix"));

        // Calcul du total
        double total = quantite * prix;

        // Envoi de la réponse JSON
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{");
        out.println("\"message\": \"LigneFacture ajoutée avec succès\",");
        out.println("\"produit\": \"" + produit + "\",");
        out.println("\"quantite\": " + quantite + ",");
        out.println("\"prix\": " + prix + ",");
        out.println("\"total\": " + total);
        out.println("}");
    }
}
