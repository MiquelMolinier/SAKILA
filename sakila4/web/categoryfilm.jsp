<%-- 
    Document   : categorifilm
    Created on : 18-sep-2020, 11:26:46
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
                        <th bgcolor="#dff9fb">AMOUNT RENTAL</th>
                        <th bgcolor="#dff9fb">PAYMENT DATE</th>
                        <th bgcolor="#dff9fb">RENTAL DATE</th>
                        <th bgcolor="#dff9fb">CUSTOMER FIRST NAME</th>
                        <th bgcolor="#dff9fb">CUSTOMER LAST NAME</th>
                        <th bgcolor="#dff9fb">CUSTOMER ADDRESS</th>
                        <th bgcolor="#dff9fb">CUSTOMER CITY</th>
                        <th bgcolor="#dff9fb">CUSTOMER COUNTRY</th>
                        <th bgcolor="#dff9fb">TITLE FILM</th>
                    </tr>
                    <jsp:useBean class="daoImpl.CustomerDAOImplement" id="customerDAO"></jsp:useBean>
                    <c:forEach items="${customerDAO.listar()}" var="customer">
                        <tr>
                            <td>${customer[0]}</td>
                            <td>${customer[1]}</td>
                            <td>${customer[2]}</td>
                            <td>${customer[3]}</td>
                            <td>${customer[4]}</td>
                            <td>${customer[5]}</td>
                            <td>${customer[6]}</td>
                            <td>${customer[7]}</td>
                            <td>${customer[8]}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
