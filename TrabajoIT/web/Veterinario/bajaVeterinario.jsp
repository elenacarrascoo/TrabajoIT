<%-- 
    Document   : bajaVeterinario
    Created on : 30-abr-2024, 18:52:08
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja Veterinario</title>
    </head>
    <body>
        
        <s:form action="eliminacionVeterinario" method="post">
            <s:textfield name="dni" label="Dime el dni del veterinario a dar de baja"></s:textfield>
            <s:password name="password" label="Introduce tu contraseña"></s:password>
            <s:submit name="boton" value="Dar de Baja" key="submit_bajaVeterinario"/>
        </s:form>
        
        <s:form action="opcionesAdicionales" method="post">
            <s:submit name="boton" value="Volver"/>
        </s:form>
        
        
    </body>
</html>
