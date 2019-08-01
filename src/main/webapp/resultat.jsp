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
        <jsp:setProperty name="MaRecherche" property="auteur" param="auteur" />
        <jsp:setProperty name="MaRecherche" property="titre" param="titre" />      
       <jsp:setProperty name="MaRecherche" property="type" param="type" /> 

        <h1>Resultats de la recherche</h1>
        <p>A faire : indiquer les résultats de la recherche</p><br>
        titre : <jsp:getProperty name="MaRecherche" property="titre" /><br>
        auteur : <jsp:getProperty name="MaRecherche" property="auteur" /><br>
        type : <jsp:getProperty name="MaRecherche" property="type" /><br>
        <form action="rechercher.jsp" metho="post">           
            <input type="submit" value="Effectuer une nouvelle recherche">
        </form>
        <%@include file="pied.html" %>
    </body>
</html>
