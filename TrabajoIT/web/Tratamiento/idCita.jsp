<%-- 
    Document   : idCita
    Created on : 08-may-2024, 13:55:05
    Author     : Usuario
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
        <s:form action="Tratamiento" method="post">
            <s:textfield name="dni" label="ID de la cita a consultar"></s:textfield>
            <s:submit name="boton" value="ConsultarID"/>
        </s:form>
        
    </body>
</html>
