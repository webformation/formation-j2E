package devweb.meadiathequeweb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import authentification.AuthentifLecteur;

/**
 *
 * @author Administrateur
 */
public class Authentifier extends HttpServlet {

    ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sc = config.getServletContext();
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
        response.sendRedirect(sc.getContextPath() + "/connexion.html");
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String idSaisi = request.getParameter("identifiant");
        String mdpSaisi = request.getParameter("mdp");
        if (idSaisi != null && mdpSaisi != null) {
            // TODO : faire un controle de validité
            if (AuthentifLecteur.isLecteur(idSaisi, mdpSaisi)) {
                session.setAttribute("id", idSaisi);
                response.sendRedirect(sc.getContextPath() + "/Emprunter");
                return;
            }
        }
        response.sendRedirect(sc.getContextPath() + "/connexion.html");
        return;
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
