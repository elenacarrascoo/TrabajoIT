<%-- 
    Document   : registro
    Created on : 27-abr-2024, 13:19:35
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <jsp:include page="HEADER.jsp" />
        
        <h1>Bienvenido a nuestro veterinario!</h1>
        
        <h2>¿Como te registras?</h2>
        
        <s:form action="elegirRegistro" method="post" >
            <s:radio label="Propietario / Veterinario" name="rolUsuario" list="{'propietario', 'veterinario'}"/>
            <s:submit value="aceptar" name="aceptar"></s:submit>
        </s:form>
        <jsp:include page="FOOTER.jsp" />
    </body>
</html>
