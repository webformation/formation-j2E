<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%! ArrayList<Media> catalogue;%>
<%
    catalogue = Catalogue.get(application.getRealPath("/data/export.csv"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consutlation</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <jsp:useBean id="MaRecherche" scope="session" class="devweb.meadiathequeweb.Recherche" />     
        <%--<jsp:setProperty name="MaRecherche" property="titre" value='<%= request.getParameter("titre")%>' />        <jsp:setProperty name="MaRecherche" property="auteur" param="auteur" />
        <jsp:setProperty name="MaRecherche" property="titre" param="titre" />--%>  
        <jsp:setProperty name="MaRecherche" property="titre" value='<%= request.getParameter("titre")%>' />
        <jsp:setProperty name="MaRecherche" property="auteur" value='<%= request.getParameter("auteur")%>' />
        <jsp:setProperty name="MaRecherche" property="type" param="type" /> 

        <h1>Resultats de la recherche</h1>
        <jsp:include   page="/filtrerCatalogue" />
        <table>
        <c:forEach var="x" items="${sessionScope.resultat}">
            <tr><td>${x.titre}</td><td> ${x.getAuteur()}</td>
        </c:forEach>
        </table>
        <%--
            ArrayList<Media> liste = (ArrayList<Media>) session.getAttribute("resultat");
            if (liste != null) {
                for (Media x : liste) {
                    out.println(x.getTitre());

                }
            }
        --%>
        <form action="rechercher.jsp" method="post">           
            <input type="submit" value="Effectuer une nouvelle recherche">
        </form>
        <%@include file="pied.html" %>
    </body>
</html>
