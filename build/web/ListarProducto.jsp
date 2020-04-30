<%-- 
    Document   : ListarProducto
    Created on : 25/04/2020, 07:01:23 PM
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
        <h2>Listado de Productos:</h2>

        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Categoria</td>
                    <td>Proveedor</td>
                    <td>Stock</td>
                    <td>Fecha Registro Stock</td>
                    <td>Stock minimo</td>
                    <td>Codigo de barra</td>
                    <td>Fecha vencimiento</td>
                    <td>Precio unitario</td>
                    
                    <td colspan="2">Accion</td>
                <tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${lista}">
                    <tr>
                        <td>${p.codigo}</td>
                        <td>${p.nombre}</td>
                        <td>${p.nombre_categoria}</td>
                        <td>${p.nombre_proveedor}</td>
                        <td>${p.stock_inicial}</td>
                        <td>${p.fecha_Registro}</td>
                        <td>${p.stock_minimo}</td>
                        <td>${p.codigo_barra}</td>
                        <td>${p.fecha_ven}</td>
                        <td>${p.precio_unitario}</td>
                        <td>
                            <a href='ServletProducto?accion=GET&codigo=${p.codigo}'>
                                <input type="submit" value="Editar"/></a>
                            <a href='ServletProducto?accion=DEL&codigo=${p.codigo}' onclick="return alerta()">
                                <input type="submit" value="Eliminar"/></a>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
            <td>
                <a href="RegistroProducto.jsp">
                    <input type="submit" value="Agregar">
                </a>
            </td>
        </tfoot>
    </table>
    </body>
</html>
