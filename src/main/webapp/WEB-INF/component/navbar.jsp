<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
    <c:choose>
        <c:when test="${sessionScope.employe ne null}">
            <p><a href="/deconnexion">Déconnexion</a></p>
            <p>Bonjour ${sessionScope.employe.email}</p>
        </c:when>
        <c:otherwise>
            <p><a href="/deconnexion">Déconnexion</a></p>
            <p>Hello</p>
        </c:otherwise>
    </c:choose>

</nav>