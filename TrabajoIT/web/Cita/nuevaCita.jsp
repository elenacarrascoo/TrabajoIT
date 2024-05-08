<%-- 
    Document   : nuevaCita
    Created on : 5 may 2024, 19:50:53
    Author     : clarabecerragil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Cita</title>
    </head>
    <body>
        <h1>Nueva Cita</h1>
    <s:form name="altaCita" action="altaCita" method="post">
        <s:textfield name="fecha" label="Fecha" type="date"/>
        <s:textfield name="hora" label="Hora" type="time"/>
        <s:textfield name="motivo" label="Motivo"/>
        
        <s:submit name="altaCita" value="Reservar"/>
    </s:form>
</body>
</html>