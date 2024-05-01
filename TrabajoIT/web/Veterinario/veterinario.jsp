<%-- 
    Document   : veterinario
    Created on : 27-abr-2024, 13:14:18
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opciones del Veterinario</title>
    </head>
    <body>
        <h1>Bienvenido, <s:property value="nombre"></s:property> Especializado en <s:property value="especialidad"></s:property></h1>
        <h2>¿Qué acción deseas realizar?</h2>

        <s:form action="veterinarioActions" method="post">
            <s:submit name="boton" value="Consultar Agenda" />
        </s:form>
        
        <s:form action="veterinarioActions" method="post">
            <s:submit name="boton" value="Modificar Datos" />
        </s:form>

        <s:form action="veterinarioActions" method="post">
            <s:submit name="boton" value="Consultar Compañeros" />
        </s:form>

        <s:form action="veterinarioActions" method="post">
            <s:submit name="boton" value="Baja Veterinario" />
        </s:form>
        
        <s:form action="veterinarioActions" method="post">
            <s:submit name="boton" value="LogOut" />
        </s:form>

    </body>
</html>