<%-- 
    Document   : mensaje
    Created on : 22/04/2020, 01:46:53 PM
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
        <h1>Error en el proyecto</h1>
        <h2><%=request.getAttribute("resultado")%></h2>
    </body>
</html>
