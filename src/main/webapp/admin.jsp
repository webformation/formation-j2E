<%-- 
    Document   : admin
    Created on : 6 août 2019, 12:14:53
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
        <%@include file="menu.jsp" %>
        <h1>Administration</h1>
        <a href="<%= getServletConfig().getServletContext().getContextPath()%>/ExporterBDD">Créer Base de données</a><br>
        <a href="<%= application.getContextPath()%>/debug.jsp">Voir Media</a><br>
        <a href="<%= application.getContextPath()%>/listeLecteur">Liste des lecteurs</a>

    </body>
</html>
