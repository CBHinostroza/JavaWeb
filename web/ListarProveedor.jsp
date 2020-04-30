<%-- 
    Document   : ListarProveedor
    Created on : 22/04/2020, 06:02:50 PM
    Author     : bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="JS/Util.js" type="text/javascript"></script>
    </head>
    <body>
        <h2>Listado de Proveedores:</h2>

        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Direccion</td>
                    <td>Territorio</td>
                    <td>Telefono</td>
                    <td>Email</td>
                    <td colspan="2">Accion</td>
                <tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${lista}">
                    <tr>
                        <td>${p.codigo}</td>
                        <td>${p.nombre}</td>
                        <td>${p.direccion}</td>
                        <td>${p.distrito}</td>
                        <td>${p.telefono}</td>
                        <td>${p.email}</td>
                        <td>
                            <a href='MiServlet?accion=GET&codigo=${p.codigo}'>
                                <input type="submit" value="Editar"/></a>
                            <a href='MiServlet?accion=DEL&codigo=${p.codigo}' onclick="return alerta()">
                                <input type="submit" value="Eliminar"/></a>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
            <td>
                <a href="RegistroProveedor.jsp">
                    <input type="submit" value="Agregar">
                </a>
            </td>
        </tfoot>
    </table>
</body>
</html>
