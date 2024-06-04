<%-- 
    Document   : actualizarFactura
    Created on : 28-may-2024, 13:44:31
    Author     : ecarr
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Factura</title>
    </head>
    <body>
        <h1>Actualizar importe de la factura:</h1>

        <s:form action="modificarFactura" method="post">
            <s:textfield name="importe" label="Importe" value="%{#session.factura.importe}"/>
            <s:submit name="modificarFactura" key="submit_actualizarFactura"/>
        </s:form>
    </body>

    <s:form action="volverFacturas" method="post">
        <s:submit name="volverFacturas" key="submit_volver"/>
    </s:form>
</html>
