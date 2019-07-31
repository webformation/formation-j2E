<%-- 
    Document   : consulter
    Created on : 31 juil. 2019, 12:20:17
    Author     : Administrateur
--%>

<%@page import="devweb.meadiathequeweb.Catalogue"%>
<%@page import="devweb.meadiathequeweb.Livre"%>
<%@page import="devweb.meadiathequeweb.DVD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="devweb.meadiathequeweb.Media"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ArrayList<Media> catalogue = Catalogue.get();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consutlation</title>
    </head>
    <body>
        <%@include file="menu.html" %>
        <h1>Catalogue</h1>
        <table>
            <%
                String type = request.getParameter("t");
                for (Media x : catalogue) {
                    if (type.equals("l") && (x instanceof Livre)) {
                        Livre l = (Livre) x;
            %>
            <tr><td><%= l.getTitre()%></td><td><%= l.getAuteur()%></td><td><%= l.getNbPage()%></td></tr>
            <%
                }
                if (type.equals("d") && (x instanceof DVD)) {
                    DVD d = (DVD) x;
            %>
            <tr><td><%= d.getTitre()%></td><td><%= d.getAuteur()%></td><td><%= d.getDuree()%></td></tr>
            <%
                    }
                }
            %>
        </table>
        <%@include file="pied.html" %>
    </body>
</html>
