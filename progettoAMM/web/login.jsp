<%-- 
    Document   : login
    Created on : 8-lug-2017, 11.11.25
    Author     : martinasalis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="widt=device-width, initial-scale=1.0">
        <meta name="author" content="Martina Salis">
        <meta name="keywords" content="Cerca amici">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        
        <!--header contenente in titolo della pagina-->
        <header class="titleCenter">
            <div id="title">
                <h1>NerdBook</h1>
            </div>
        </header>  
        
        <!--Contenuti della pagina-->
        <div id="divBody">
            <div id="formLogin">
                
                    
                <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
                </c:if>
                    
                
                <form action="Login" method="post"> 
                    <div id="inputType">
                        <div>
                            <label for="name">Username: </label>
                            <input type="text" name="username" id="name"/>
                        </div>
                        <div>
                            <label for="pw">Password: </label>
                            <input type="password" name="password" id="pw"/>
                        </div>
                        
                        <button type="submit">Entra</button>
                        
                    </div>
                    
                </form>
            </div>
        </div>

    </body>
</html>

