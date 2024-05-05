<%-- 
    Document   : actualizarPropietario
    Created on : 03-may-2024, 15:14:03
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Actualiza tus datos:</h1>
        
        <s:form action="registrarActualizacion" method="post">
            <s:textfield name="nombre" label="Nombre"/>
            <s:textfield name="direccion" label="Direccion"/>
            <s:textfield name="telefono" label="Telefono"/>
            <s:textfield name="correo" label="Correo"/>
            <s:textfield name="infoContactoAdicional" label="Información contacto adicional"/>
            <s:submit name="registrarActualizacion" value="Actualizar datos"/>
        </s:form>
    </body>
</html>
