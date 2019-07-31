<%-- 
    Document   : jspEssaiBean
    Created on : 31 juil. 2019, 16:24:24
    Author     : Administrateur
--%>

<%@page import="devweb.meadiathequeweb.Recherche"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Création du Bean</h1>
        <jsp:useBean id="MaRecherche" scope="session" class="devweb.meadiathequeweb.Recherche" />
        <jsp:setProperty name="MaRecherche" property="auteur" value="Stendhal" />
        <jsp:setProperty name="MaRecherche" property="titre" value="Le rouge et le noir" />      
       <jsp:setProperty name="MaRecherche" property="type" value="L" />      
        <jsp:forward page="jspUtilisationBean.jsp"/>
    </body>
</html>
