<%-- 
    Document   : connexion
    Created on : 7 août 2019, 13:57:27
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div style="width: 800px;margin-left:auto; margin-right:auto;font-size:30px">
            <form method="POST"  action="<%= application.getContextPath() %>/Authentifier">
                <label for="identifiant">Identifiant 
                    <input type="text" name="identifiant" id="identifiant">
                </label>
                <br>
                <label for="mdp">Mot de passe 
                    <input type="password" name="mdp" id="mdp">
                </label>
                <br>
                <input type="submit" value="Ok">
            </form>
        </div>
    </body>
</html>
