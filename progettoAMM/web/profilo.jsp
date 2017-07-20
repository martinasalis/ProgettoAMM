<%-- 
    Document   : profilo
    Created on : 8-lug-2017, 11.11.52
    Author     : martinasalis
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="widt=device-width, initial-scale=1.0">
        <meta name="author" content="Martina Salis">
        <meta name="keywords" content="Cerca amici">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
 
    <body>
        
        <!--header contenente in titolo della pagina-->
        <header class="titleLeft">
            <div id="title">
                <h1>NerdBook</h1>
            </div>
        </header>   
        
        <!--Barra di navigazione-->
        <nav>
            <ul>
                <li class="active"><a href="Profilo">Profilo</a></li>
                <li><a href="Bacheca">Bacheca</a></li>
            </ul>
            
            <div id="logout">
                <div>
                    <img title="fotoProfilo" alt="Foto Profilo" src="${user.urlFotoProfilo}">
                    <p>${user.nome}</p>
                </div>
                <c:if test="${empty param.user}">
                    <p id="logOutLink"><a href="Login?logout=1">Logout</a></p>
                </c:if> 
            </div>
            
        </nav>
        
        <c:if test="${UserNotAuthenticated == true}">
            <div id="UserNotAuthenticatedWarning">Accesso Negato</div>
        </c:if>
        
        <!--Contenuti della pagina-->
        <c:if test="${UserNotAuthenticated != true}">
            
        <div id="divBody">
            
            
            <div id="altro">
                <div id="persone">
                    <h3>Persone</h3>
                    <c:forEach var="user" items="${users}">
                        <a href alt="Bacheca Utente" src="Bacheca?user=${user.id}">${user.nome} ${user.cognome}</a>
                    </c:forEach>
                </div>

                <div id="gruppi">
                    <h3>Gruppi</h3>
                    <c:forEach var="group" items="${groups}">
                        <a href alt="Bacheca Utente" src="Bacheca?group=${group.id}">${group.nome}</a>
                    </c:forEach>
                </div>
            </div>
            
            
            <div class="profileImg"> 
                    <img title="fotoProfilo" alt="Foto Profilo" src="${user.urlFotoProfilo}">
  
            </div>
                
            <c:if test="${profileModified == true}">
                <div id="profileModified">I dati sono stati inseriti con successo</div>
            </c:if>
            
            <div id="formIscrizione">
                <form action="Profilo" method="post">
                    <div>
                        <label for="name">Nome: </label>
                        <input type="text" name="nome" id="name"/><br />
                    </div> 
                    <div>
                        <label for="surname">Cognome: </label>
                        <input type="text" name="cognome" id="surname" /><br />
                    </div>
                    <div>
                        <label for="presentation">Descrizione: </label>
                        <textArea rows="4" cols="20" name="presentation" id="presentation"> </textArea> <br />
                    </div>
                    <div>
                        <label for="bday">Compleanno: </label>
                        <input type="date" name="bday" id="bday"/><br />
                    </div>
                    <div>
                        <label for="psw">Password: </label>
                        <input type="password" name="password" id="psw" /><br />
                    </div>
                    <div>
                        <label for="cpsw">Conferma password:</label>
                        <input type="password" name="cPassword" id="cpsw" /><br />
                    </div>    
                        <button type="submit">Aggiorna</button>
                </form>
                <div id="cancel">
                    <form  action="Profilo" method="post" >
                        <input type="hidden" name="hdnbt"/>
                        <input type="button" name="delete" value="Cancella Profilo" onclick="{document.frm.hdnbt.value=this.value;document.frm.submit();}" />
                    </form>
                </div>
            </div>
        </div>
            
        </c:if>
    </body>
</html>