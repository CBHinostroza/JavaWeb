<%-- 
    Document   : EditarProveedor
    Created on : 23/04/2020, 10:45:52 PM
    Author     : bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editando</h1>
        <form action="MiServlet" method="post" style="margin: auto; width: 500px">
            <input type="hidden" name="accion" value="UPD">
            <input type="hidden" name="codigo" value="${proveedor.codigo}">
            <fieldset>
                <legend>Editar proveedor</legend>
                <label>Nombre:</label><input type="text" name="nombre" value="${proveedor.nombre}"><br/>
                <label>Direccion:</label><input type="text" name="direccion" value="${proveedor.direccion}"><br/>
                Territorio: <input type="text" name="territorio" value="${proveedor.codigo_territorio}"><br/>
                Telefono: <input type="text" name="telefono" value="${proveedor.telefono}"><br/>
                Email: <input type="text" name="email" value="${proveedor.email}"><br/>
                <input type="submit" value="Guardar">
            </fieldset>
        </form>
    </body>
</html>
