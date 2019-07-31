<%-- 
    Document   : index.jsp
    Created on : 30 juil. 2019, 17:00:11
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Accueil</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                font-size:16px;
            }
            h1 {
                font-size: 20px;
                text-align: center;    
            }
            nav {
                width: 50%;
                margin-left:auto;margin-right:auto;
            }
        </style>
    </head>
    <body>
        <h1>Bienvenue à la Médiatheque</h1>
        <%@include file="menu.html" %>  
        <%@include file="pied.html" %>    
    </body>
</html>

