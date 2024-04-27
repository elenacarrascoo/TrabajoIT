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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <s:property value="veterinario.nombre"></s:property>, especializada en <s:property value="veterinario.especialidad"></s:property></h1>
        <h2>¿Que acción deseas realizar?</h2>
        <s:form name="veterinarioAction" method="post">
            <s:submit name="boton1" value="Consultar Agenda"></s:submit>
            <s:submit name="boton2" value="Modificar Datos"></s:submit>
            <s:submit name="boton3" value="Consultar Compañeros" ></s:submit>
            <s:submit name="boton4" value="Baja Compañero"></s:submit>
            
        </s:form>
        
    </body>
</html>
