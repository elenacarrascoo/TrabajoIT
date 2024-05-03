<%-- 
    Document   : actualizarPaciente
    Created on : 27-abr-2024, 16:47:34
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
        <h1>Actualiza los datos de tu mascota:</h1>
        
        <s:form action="actualizarPaciente" method="post">
            <s:textfield name="nombre" label="Nombre"/>
            <s:textfield name="especie" label="Especie"/>
            <s:textfield name="raza" label="Raza"/>
            <s:textfield name="sexo" label="Sexo"/>
            <s:textfield name="edad" label="Edad"/>
            <s:textfield name="fechaNacimiento" label="Fecha de nacimiento"/>
            <s:submit name="actualizarPaciente" value="Actualizar datos"/>
        </s:form>
    </body>
</html>
