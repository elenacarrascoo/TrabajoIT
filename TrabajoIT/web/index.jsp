<%-- 
    Document   : index
    Created on : 27-abr-2024, 10:28:48
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
        <h1>BIENVENIDO A NUESTRO VETERINARIO!</h1>
        
        <h2>¿Perteneces ya a UPOVET?</h2>
        <s:form action="login" method="post">
            <s:submit name="login" value="Iniciar Sesión"/>
        </s:form>
        
        <h2>¿Todavía no te has registrado?</h2>
        <s:form action="registrar" method="post">
            <s:submit name="registrar" value="Registrar"/>
        </s:form>
    </body>
</html>
