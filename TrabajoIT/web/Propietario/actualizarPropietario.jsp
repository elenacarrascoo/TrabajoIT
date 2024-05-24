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
            <s:textfield name="nombre" label="Nombre" value="%{#session.propietario.nombre}"/>
            <s:textfield name="direccion" label="Direccion" value="%{#session.propietario.direccion}"/>
            <s:textfield name="telefono" label="Telefono" value="%{#session.propietario.telefono}"/>
            <s:textfield name="correo" label="Correo" value="%{#session.propietario.correo}"/>
            <s:textfield name="infoContactoAdicional" label="Información contacto adicional" value="%{#session.propietario.infoContactoAdicional}"/>
            <s:password name="password" label="Password" value="%{#session.propietario.password}"/>
            <s:submit name="registrarActualizacion" value="Actualizar datos"/>
        </s:form>
        <br>
        <br>
        <br>
        <s:form action="volverPropietario" method="post">
            <s:submit name="volverPropietario" value="Volver"/>
        </s:form>
    </body>
</html>
