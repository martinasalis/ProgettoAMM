<%-- 
    Document   : listaUtentiJson
    Created on : 19-lug-2017, 17.24.05
    Author     : martinasalis
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="user" items="${listaUtenti}">
        <json:object>
            <json:property name="nome" value="${user.nome}"/>
            <json:property name="cognome" value="${user.cognome}"/>
            <json:property name="descrizione" value="${user.descrizione}"/>
            <json:property name="compleanno" value="${user.compleanno}"/>
            <json:property name="password" value="${user.password}"/>
            <json:property name="urlFotoProfilo" value="${user.urlFotoProfilo}"/>
        </json:object>
    </c:forEach>
</json:array>
