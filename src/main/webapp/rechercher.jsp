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
        <%@include file="menu.jsp" %>
        <jsp:useBean id="MaRecherche" scope="session" class="devweb.meadiathequeweb.Recherche" />     

        <h1>Rechercher</h1>
        <form action="resultat.jsp" metho="post">
            <label for="titre">Titre 
                <input type="text" name="titre" id="titre" value="<jsp:getProperty name="MaRecherche" property="titre" />" >
            </label>
            <br>
            <label for="auteur">Auteur
                <input type="text" name="auteur" id="auteur" value="<jsp:getProperty name="MaRecherche" property="auteur" />">
            </label>
            <br>
            <label for="type">Type
                <input type="text" name="type" id="type" value="<jsp:getProperty name="MaRecherche" property="type" />">
            </label>
            <br>
            <input type="submit" value="Chercher">
        </form>
        <%@include file="pied.html" %>
    </body>
</html>
