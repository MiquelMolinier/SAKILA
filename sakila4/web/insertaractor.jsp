<%-- 
    Document   : insertar
    Created on : 11-jul-2020, 20:41:13
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
                <h1>Agregar alumno</h1>
                <form action="ActorServlet" method="POST">
                    <input type="hidden" name="accion" value="Agregar actor" />
                    <table>
                        <tr>
                            <td>ActorID:</td>
                            <td><input type="text" name="ActorID" value="" /></td>
                        </tr>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="ActorFirstName" value="" /></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td><input type="text" name="ActorLastName" value="" /></td>
                        </tr>
                        <tr>
                            <td>Last Update:</td>
                            <td><input type="text" name="LastUpdate" value="" /></td>
                        </tr>
                    </table>
                    <input type="submit" value="Enviar" />
                </form>
            </div> 
        </div>
    </body>
</html>