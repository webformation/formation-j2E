package devweb.meadiathequeweb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
public class FiltrerCatalogue extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Recherche r = (Recherche) request.getSession().getAttribute("MaRecherche");
                
        ArrayList<Media> ResultatRecherche = Catalogue.get();; 
        // nom auteur
        if (r.getAuteur().trim().length() != 0) {
            ArrayList<Media> c =  new ArrayList<Media>();
            for (Media x : ResultatRecherche) {
                if (x.getAuteur().equalsIgnoreCase(r.getAuteur())) {
                    c.add(x);
                }
            }
            ResultatRecherche = c;
        }
       // nom titre
        if (r.getTitre().trim().length() != 0) {
            ArrayList<Media> c =  new ArrayList<Media>();
            for (Media x : ResultatRecherche) {
                if (x.getTitre().equalsIgnoreCase(r.getTitre())) {
                    c.add(x);
                }
            }
            ResultatRecherche = c;
        }
        request.getSession().setAttribute("resultat", ResultatRecherche);
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
