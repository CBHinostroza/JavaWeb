<%-- 
    Document   : RegistroProducto
    Created on : 25/04/2020, 07:27:35 PM
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
        <form action="ServletProducto" method="post" style="margin: auto; width: 500px">
            <input type="hidden" name="accion" value="INS">
            <fieldset>
                <legend>Registro de producto</legend>
                <label>Nombre:</label><input type="text" name="nombre"><br/>
                <label>Categoria:</label><input type="text" name="categoria"><br/>
                Proveedor: <input type="text" name="proveedor"><br/>
                Stock Inicial: <input type="text" name="stock_inicial"><br/>
                Stock Minimo: <input type="text" name="stock_minimo"><br/>
                Codigo Barra: <input type="text" name="codigo_barra"><br/>
                Fecha Vencimiento: <input type="text" name="fecha_ven"><br/>
                Precio Unitario: <input type="text" name="precio_unitario"><br/>
              
                <input type="submit" value="Guardar">
            </fieldset>
        </form>
    </body>
</html>
