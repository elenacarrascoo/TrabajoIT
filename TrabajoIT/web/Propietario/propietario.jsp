<%-- 
    Document   : propietario
    Created on : 27-abr-2024, 13:14:07
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
        <h1>Hola <s:property value="#session.propietario.nombre"/></h1>
        <s:form method="post" action="formAltaPaciente">
            <s:label from="altaPaciente" value="¿Quieres registrar a tu mascota?: "></s:label>
            <s:submit name="altaPaciente" key="submit_altaPaciente"></s:submit>
        </s:form>
        <br>
        <s:form method="post" action="verPacientes">
            <s:label from="verPacientes" value="Ve toda la información de tus mascotas: "></s:label>
            <s:submit name="verPacientes" key="submit_verPacientes"></s:submit>
        </s:form>
        <br>
        <s:form method="post" action="actualizarPropietario">
            <s:label from="actualizarPropietario" value="Actualiza tus datos: "></s:label>
            <s:submit name="actualizarPropietario" key="submit_actualizar"></s:submit>
        </s:form>
        <br>
        <s:form method="post" action="verFacturas">
            <s:label from="verFacturas" value="Ve toda la información de tus facturas "></s:label>
            <s:submit name="verFacturas" key="submit_verFacturas"></s:submit>
        </s:form>
        <br>
        <br>
        <s:form action="logoutPropietario" method="post">
            <s:submit name="logout" key="submit_logout"/>
        </s:form>
    </body>
</html>
