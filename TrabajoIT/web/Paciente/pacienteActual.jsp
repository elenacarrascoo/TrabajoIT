<%-- 
    Document   : pacienteActual
    Created on : 27-abr-2024, 16:45:26
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
        <s:form method="post" action="consultarPaciente">
            <s:label from="consultarPaciente" value="Ver datos de tu mascota: "></s:label>
            <s:submit name="consultarPaciente" value="Consultar Paciente"></s:submit>
        </s:form>
        <br>
        <s:form method="post" action="">
            <s:label from="" value=""></s:label>
            <s:submit name="" value=""></s:submit>
        </s:form>
        <br>
        <s:form method="post" action="">
            <s:label from="" value=""></s:label>
            <s:submit name="" value=""></s:submit>
        </s:form>
    </body>
</html>
