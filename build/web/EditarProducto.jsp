<%-- 
    Document   : EditarProducto
    Created on : 28/04/2020, 12:53:31 PM
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
        <form action="ServletProducto" method="post" style="margin: auto; width: 500px">
            <input type="hidden" name="accion" value="UPD">
            <input type="hidden" name="codigo" value="${producto.codigo}">
            <fieldset>
                <legend>Editar producto</legend>
                Nombre:<input type="text" name="nombre" value="${producto.nombre}"><br/>
                Categoria:<input type="text" name="idcategoria" value="${producto.idcategoria}"><br/>
                Proveedor: <input type="text" name="idproveedor" value="${producto.idproveedor}"><br/>
                Stock Inicial: <input type="text" name="stock_inicial" value="${producto.stock_inicial}"><br/>
                Stock Inicial: <input type="text" name="fecha_Registro" value="<%=request.getAttribute("fecha_registro_formateado")%>"><br/>
                Stock Minimo: <input type="text" name="stock_minimo" value="${producto.stock_minimo}"><br/>
                Codigo de Barra: <input type="text" name="codigo_barra" value="${producto.codigo_barra}"><br/>
                Fecha Vencimiento: <input type="text" name="fecha_ven" value="<%=request.getAttribute("fecha_ven_formateado")%>"><br/>
                Precio Unitario: <input type="text" name="precio_unitario" value="${producto.precio_unitario}"><br/>
                <input type="submit" value="Guardar">
            </fieldset>
        </form>
    </body>
</html>
