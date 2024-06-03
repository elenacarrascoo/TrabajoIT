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
        <title>Inicio</title>
    </head>
    <body>
        <jsp:include page="HEADER.jsp" />
        <div class="container-fluid pt-3 pb-3" style="min-height: 70vh">
            <div class="row mt-2 text-center">
                <h1>¡BIENVENIDO A NUESTRO VETERINARIO!</h1>
            </div>
            <div class="row col-12 mt-5">
                <div class="col-6 text-center">
                    <h2>¿Perteneces ya a UPOVET?</h2>
                    <a href="<s:url action='loginForm'/>" class="btnModificado btn">
                        <s:text name="submit_login" />
                    </a>
                </div>
                <div class="col-6 text-center">
                    <h2>¿Todavía no te has registrado?</h2>
                    <a href="<s:url action='registrarForm'/>" class="btnModificado btn">
                        <s:text name="submit_registrar" />
                    </a>   
                </div>
                
            </div>
            
        </div>
        
        
        <jsp:include page="FOOTER.jsp" />
    </body>
</html>
