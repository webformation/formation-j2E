package devweb.meadiathequeweb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrateur
 */
public class Emprunter extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        String id = (String) session.getAttribute("id");
        if (id == null) {
            response.sendRedirect(sc.getContextPath() + "/connexion.jsp");
            return;
        }
        response.setContentType("text/html");
        PrintWriter p = response.getWriter();
        p.println("<!DOCTYPE html>");
        p.println("<html>");
        p.println("<head>");
        sc.getRequestDispatcher("/menu.jsp").include(request, response);
        p.println("<title>Emprunter</title>");
        p.println("</head>");
        p.println("<body>");
        p.println("<h1 style='text-align:center'>Emprunts</h1>");
        p.println("</body>");
        p.println("</html>");
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
