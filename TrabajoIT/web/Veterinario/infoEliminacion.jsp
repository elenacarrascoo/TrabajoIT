<%-- 
    Document   : infoEliminacion
    Created on : 01-may-2024, 17:11:26
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
        <h1>El veterinario, ha sido dado de baja con exito</h1>

        <s:form action="opcionesAdicionales" method="post">
            <s:submit name="boton" value="LogOut"/>

        </s:form>


    </body>
</html>
