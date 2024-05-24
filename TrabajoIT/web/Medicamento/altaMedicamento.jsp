<%-- 
    Document   : altaMedicamento
    Created on : 27-abr-2024, 16:44:42
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@taglib prefix="s" uri="/struts-tags" %>
    </head>
    <body>
        <h1>Introduce tus datos:</h1>
        
        <s:form action="altaMedicamento" method="post">
            <s:textfield name="nombre" label="Nombre medicamento"/>
            <s:textfield name="fechaCaducidad" label="Fecha de caducidad" type="date"/>
            <s:submit name="altaMedicamento" value="Añadir medicamento"/>
        </s:form>
    </body>
</html>
