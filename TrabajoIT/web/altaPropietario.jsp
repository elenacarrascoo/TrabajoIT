<%-- 
    Document   : altaPropietario
    Created on : 27-abr-2024, 13:22:12
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Introduce tus datos:</h1>
        
        <s:form action="registrarPropietario" method="post">
            <s:textfield name="dni" label="DNI:"/>
            <s:textfield name="nombre" label="Nombre:"/>
            <s:textfield name="direccion" label="Direccion:"/>
            <s:textfield name="telefono" label="Telefono:"/>
            <s:textfield name="correo" label="Correo:"/>
            <s:textfield name="infoContactoAdicional" label="Info contacto adicional:"/>
            <s:submit name="darAltaPropietario" value="Dar de alta"/>
        </s:form>
    </body>
</html>
