<%-- 
    Document   : actualizarCita
    Created on : 27-abr-2024, 16:47:19
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizaci&oacute;n de la Cita</title>
    </head>
    <body>
        <h1>Actualizando la cita <s:property value="#session.cita.id"/></h1>
        <s:form>
            <s:textfield name="fecha" label="Fecha"/>
            <s:textfield name="fecha" label="Fecha" type="date"/>
            <s:textfield name="hora" label="Hora" type="time"/>
        
            <s:submit name="modificarCita" value="Actualizar"/>
        </s:form>
    </body>
</html>
