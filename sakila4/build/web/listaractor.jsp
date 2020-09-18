<%-- 
    Document   : listar_actores
    Created on : 11-jul-2020, 20:23:29
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
                        <th bgcolor="#dff9fb">ACTOR ID</th>
                        <th bgcolor="#dff9fb">FIRST NAME</th>
                        <th bgcolor="#dff9fb">LAST NAME</th>
                        <th bgcolor="#dff9fb">LAST UPDATE</th>
                    </tr>
                    <jsp:useBean class="daoImpl.ActorDAOImplement" id="actorDAO"></jsp:useBean>
                    <c:forEach items="${actorDAO.listar()}" var="actor">
                        <tr>
                            <td>${actor.getActor_id()}</td>
                            <td>${actor.getFirst_name()}</td>
                            <td>${actor.getLast_name()}</td>
                            <td>${actor.getLast_update()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
