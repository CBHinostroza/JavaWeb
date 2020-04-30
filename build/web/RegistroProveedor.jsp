<%-- 
    Document   : RegistroProveedor
    Created on : 22/04/2020, 02:13:30 PM
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
        <h1>Hello World!</h1>
        <form action="MiServlet" method="post" style="margin: auto; width: 500px">
            <input type="hidden" name="accion" value="INS">
            <fieldset>
                <legend>Registro de proveedor</legend>
                <label>Nombre:</label><input type="text" name="nombre"><br/>
                <label>Direccion:</label><input type="text" name="direccion"><br/>
                Territorio: <input type="text" name="territorio"><br/>
                Telefono: <input type="text" name="telefono"><br/>
                Email: <input type="text" name="email"><br/>
                <input type="submit" value="Guardar">
            </fieldset>
        </form>
        
    </body>
</html>
