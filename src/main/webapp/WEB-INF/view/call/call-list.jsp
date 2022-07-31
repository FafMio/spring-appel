<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Liste des appels</title>
</head>
<body>
<main>
    <h1 align="center">Appels <a href="appels/ajouter">+</a></h1>

    <c:forEach items="appels" var="appel">
        <%-- TODO faire l'affichage (manque de temps)--%>
        <p>in progress</p>
    </c:forEach>

    <div class="pageable">
        <c:choose>
            <c:when test="${!appel.isFirst()}">
                <p><a href="calendar?page=0">Premier</a></p>
                <p><a href="calendar?page=${appel.number-1}">Précédent</a></p>
            </c:when>
            <c:otherwise>
                <p>Premier</p>
                <p>Précédent</p>
            </c:otherwise>
        </c:choose>
        <p>page ${appel.getNumber()+1}</p>
        <c:choose>
            <c:when test="${!appel.last}">
                <p><a href="calendar?page=${appel.number+1}">Suivant</a></p>
                <p><a href="calendar?page=${appel.totalPages - 1}">Dernier</a></p>
            </c:when>
            <c:otherwise>
                <p>Suivant</p>
                <p>Dernier</p>
            </c:otherwise>
        </c:choose>
    </div>
</main>
</body>
</html>
