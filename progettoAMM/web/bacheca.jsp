<%-- 
    Document   : bacheca
    Created on : 8-lug-2017, 11.10.02
    Author     : martinasalis
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <li><a href="Profilo">Profilo</a></li>
                <li class="active"><a href="Bacheca">Bacheca</a></li>
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
        
        <c:if test="${UserNotAuthenticated != true}">
        <!--Contenuti della pagina-->
        <div id="divBody">
            
            
            <div id="search">
                <input id="searchField" type="text" placeholder="search User!" value="">
                <button id="searchUser">Cerca</button>
            </div>
            
            
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
            
            <div id="formNewPost">
            <c:choose>
                <c:when test="${empty newpost}">
                <form action="Bacheca" method="post">
                    <div id="newPost">
                        <div id="postContent">
                            <div>
                                <label for="textPost"></label>
                                <textarea name="textPost" id="textPost"></textarea>
                            </div>
                            <div>
                                <label for="urlImg"></label>
                                <input type="url" name="img" id="urlImg" value="URL - Allegato Opzionale"/><br />
                            </div>
                            </div>
                        <div id="postType">
                            <div id="img">
                                <label for="imgType">Immagine</label>
                                <input type="radio" name="postType" value="imgType" id="imgType">
                            </div>
                            <div id="link">
                                <label for="linkType">Link</label>
                                <input type="radio" name="postType" value="linkType" id="linkType">
                            </div>
                        </div>

                        <button type="submit" name = "nuovoPost" value ="needConfirm" >Crea Post</button>  
                    </div>                   
                </form>
            </div>
            </c:when>
                <c:otherwise>
                    <div id="formNewPost">
                        <form action="Bacheca" method="post">
                            <textarea>${content}</textarea>
                            <c:if test="${postType == 'imgType'}">
                                <img src="${url}" alt="downloadedImage">
                            </c:if>
                            <c:if test="${postType == 'linkType'}">
                                <a src="${url}" alt="downloadedLink">Link</a>
                            </c:if>
                            <input type="text" hidden name="textPost" value="${content}">
                            <input type="text" hidden name="postType" value="${typePost}">
                            <input type="url" hidden name="urlImg" value="${url}">
                            <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
            
            <div id="post">
                <c:forEach var="post" items="${post}">
                    <div class="posts">
                        <div>
                            <p class="text">${post.content}</p>
                            <c:if test="${post.postType == 'IMAGE'}">
                                <img alt="Post con foto" src="${post.url}">
                            </c:if>
                            <c:if test="${post.postType == 'LINK'}">
                                <a alt="Post con link" src="${post.url}">Link</a>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
              
        </div>
        </c:if>  
    </body>
</html>

