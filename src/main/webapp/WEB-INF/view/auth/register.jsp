<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>inscription</title>
</head>
<body>
    <main>
        <h1 align="center">Inscrivez-vous</h1>
        <form action="register" name="register" method="post">
            <div>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" maxlength="50">
            </div>
            <div>
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" maxlength="16">
            </div>
            <button type="submit">Se connecter</button>
        </form>
        <c:if test="${param.notification ne null}"><h2>${param.notification}</h2></c:if>
        <p align="center">Vous avez déjà un compte, <a href="/connexion">connectez-vous</a></p>
    </main>
</body>
</html>