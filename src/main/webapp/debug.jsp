<%-- 
    Document   : debug
    Created on : 7 août 2019, 11:27:58
    Author     : Administrateur
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Debug - affichage des médias</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Liste succincte des media</h1>

        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
                           url="jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Paris"  
                           user="root"  password=""/> 


        <sql:query var="medias" dataSource="${db}">
            SELECT type,titre, auteur FROM media
        </sql:query>
        <table>
            <thead>
                <tr><th></th><th> Type</th><th>Titre</th><th>Auteur</th></tr>
            </thead>
            <tbody>
                
                <c:forEach var="x" items="${medias.rows}" varStatus="etat">                  
                    <tr><td>${etat.count}</td><td> ${x.type}</td><td>${x.titre}</td><td>${x.auteur}</td></tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
