<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ajouter un appel</title>
</head>
<body>
<main>
    <h1 align="center">Crée un appel</h1>
    <form name="add-appel" method="post">
        <div>
            <label for="employesConcernes">Employé(s) concerné(s)</label>
            <select id="employesConcernes" name="employesConcernes" multiple>
                <c:forEach items="${allEmployesConcernes}" var="employeConcerne">
                    <option value="${employeConcerne.id}">${employeConcerne.email}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="typeAppelant">Type d'appelant</label>
            <select id="typeAppelant" name="typeAppelant">
                <option>Veuillez choisir</option>
                <c:forEach items="${typesAppelant}" var="typeAppelant">
                    <option value="${typeAppelant.id}">${typeAppelant.nom}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="nomAppelant">Nom de l'appelant</label>
            <input type="nomAppelant" id="nomAppelant" name="nomAppelant" maxlength="50">
        </div>
        <div>
            <label for="prenomAppelant">Prénom de l'appelant</label>
            <input type="prenomAppelant" id="prenomAppelant" name="prenomAppelant" maxlength="50">
        </div>
        <div>
            <label for="numeroDeTelephoneAppelant">Numéro de l'appelant</label>
            <input type="numeroDeTelephoneAppelant" id="numeroDeTelephoneAppelant" name="numeroDeTelephoneAppelant" maxlength="15">
        </div>
        <div>
            <label for="objet">Objet de l'appel</label>
            <input type="objet" id="objet" name="objet" maxlength="250">
        </div>
        <div>
            <label for="supportPublicitaire">Support publicitaire</label>
            <select id="supportPublicitaire" name="supportPublicitaire">
                <option>Veuillez choisir</option>
                <c:forEach items="${supportsPublicitaire}" var="supportPublicitaire">
                    <option value="${supportPublicitaire.id}">${supportPublicitaire.nom}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Saisi par ${sessionScope.employe.email}</label>
        </div>
        <div>
            <c:forEach items="${allHistoriqueStatuts}" var="historiqueStatuts">
                <div>
                    <input type="radio" id="typeAppelant" name="typeAppelant" value="${historiqueStatuts.id}" >
                    <label for="typeAppelant">${historiqueStatuts.nom}</label>
                </div>
            </c:forEach>
        </div>


        <button type="submit">crée l'appel</button>
    </form>
</main>
</body>
</html>
