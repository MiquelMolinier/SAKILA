<%-- 
    Document   : listarfilm
    Created on : 18-sep-2020, 11:07:03
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div></div>
            <div>
                <ul>
                    <li>
                        <a href="index.html">MENU</a>
                    </li>
                </ul>
            </div>
            <div>
                <table border="1">
                    <tr>
                        <th bgcolor="#dff9fb">FILM ID</th>
                        <th bgcolor="#dff9fb">TITLE</th>
                        <th bgcolor="#dff9fb">RELEASE YEAR</th>
                        <th bgcolor="#dff9fb">RATING</th>
                    </tr>
                    <jsp:useBean class="daoImpl.FilmDAOImplement" id="filmDAO"></jsp:useBean>
                    <c:forEach items="${filmDAO.listar()}" var="film">
                        <tr>
                            <td>${film.getFilm_id()}</td>
                            <td>${film.getTitle()}</td>
                            <td>${film.getRelease_year()}</td>
                            <td>${film.getRating()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
