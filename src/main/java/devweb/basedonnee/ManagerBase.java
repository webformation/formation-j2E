/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devweb.basedonnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class ManagerBase {

    static final String user = "root";
    static final String password = "";
    static final String url = "jdbc:mysql://localhost:3306/mediatheque?useUnicode=true&zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Paris";
    static final String driver = "com.mysql.jdbc.Driver";

    static private ManagerBase mb = null;
    private Connection c;

    public Connection getConnection() {
        return c;
    }

    private ManagerBase() {
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public ManagerBase getManagerBase() {
        if (mb == null) {
            mb = new ManagerBase();
        }
        return mb;
    }
}
