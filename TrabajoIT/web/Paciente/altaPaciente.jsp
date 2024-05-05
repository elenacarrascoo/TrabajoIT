<%-- 
    Document   : altaPaciente
    Created on : 02-may-2024, 11:45:51
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
        <h1>Introduce los datos de tu mascota:</h1>
        
        <s:form action="registrarPaciente" method="post">
            <s:textfield name="nombre" label="Nombre"/>
            <s:textfield name="especie" label="Especie"/>
            <s:textfield name="raza" label="Raza"/>
            <s:textfield name="sexo" label="Sexo"/>
            <s:textfield name="edad" label="Edad"/>
            <s:textfield name="fechaNacimiento" label="Fecha de nacimiento"/>
            <s:label value="Numero de historial"/>
            <s:number name="numHistorial"/>
            <s:submit name="darAltaPaciente" value="Dar de alta"/>
        </s:form>
    </body>
</html>