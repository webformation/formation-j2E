<%-- 
    Document   : jspUtilisationBean.jsp
    Created on : 31 juil. 2019, 16:56:38
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Utilisation Bean</h1>
        <jsp:useBean id="MaRecherche" scope="session" class="devweb.meadiathequeweb.Recherche" />     
        <jsp:getProperty name="MaRecherche" property="auteur" /><br>
        <jsp:getProperty name="MaRecherche" property="titre" /> <br>     
       <jsp:getProperty name="MaRecherche" property="type"  />
    </body>
</html>
