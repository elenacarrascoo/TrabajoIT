<%-- 
    Document   : login
    Created on : 27-abr-2024, 10:29:06
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
        <h1>Hola de nuevo</h1>
        <s:form action="login" method="post">
            <s:textfield name="nombre" label="Introduce tu nombre" ></s:textfield>
            <s:password name="dni" label="Introduce tu dni"></s:password>
            <s:submit name="botonLogin" value="Iniciar sesión"/>
        </s:form>
    </body>
</html>
