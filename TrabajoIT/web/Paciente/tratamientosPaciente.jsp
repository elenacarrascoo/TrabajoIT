<%-- 
    Document   : tratamientosPaciente
    Created on : 08-may-2024, 13:26:23
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="%{tratamiento != null}">
            <p>ID: <s:property value="%{tratamiento.id}"/></p>
            <p>Tipo: <s:property value="%{tratamiento.tipo}"/></p>
            <p>Fecha: <s:property value="%{tratamiento.fecha}"/></p>
            <p>Precio: <s:property value="%{tratamiento.precio}"/></p>
            <p>Resultados: <s:property value="%{tratamiento.resultados}"/></p>
        </s:if>
            <s:else>
        <p>Tratamiento no encontrado.</p>
    </s:else>
    </body>
</html>
