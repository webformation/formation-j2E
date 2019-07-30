package devweb.meadiathequeweb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import devweb.meadiathequeweb.Media;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
public class Consulter extends HttpServlet {
ArrayList<Media> catalogue;
ServletContext sc;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        catalogue = new ArrayList<>();
        Importe();
        sc = config.getServletContext();
        sc.log("Catalogue importe");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("t");
        if (type == null) type="";
        resp.setContentType("text/html");
        PrintWriter p = resp.getWriter();
        for (Media x: catalogue) {
            if (type.equals("l") && ! (x instanceof Livre))  continue;
            if (type.equals("d") && ! (x instanceof DVD))  continue;
            p.println(x + "<br>");
        }
    }

    public void Importe() {
        try {
            FileInputStream f = new FileInputStream("./data/export.csv");
            Scanner sc = new Scanner(f);
            String ligne;
            while (sc.hasNextLine()) {
                ligne = sc.nextLine();
                String[] e = ligne.split(";");
                if (e.length == 0) {
                    continue;
                }

                try {
                    Media m;
                    switch (e[0]) {
                        case "D":
                            m = new DVD(e[1], e[2], Integer.parseInt(e[3].strip()));
                            break;
                        case "L":
                            m = new Livre(e[1], e[2], Integer.parseInt(e[3].strip()));
                            break;
                        default:
                            continue;
                    }
                    if (!catalogue.contains(m)) {
                        catalogue.add(m);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            f.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Consulter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Consulter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}