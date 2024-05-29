<%-- 
    Document   : HEADER
    Created on : 29-may-2024, 12:35:27
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="CSS/general.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/3e2086bcb1.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid" style="background-color: #3C6E71;">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4">
                <s:if test="%{#session.propietario == null && #session.veterinario == null}">
                    <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                        <span class="fs-4">UPOVET <i class="fa-solid fa-paw p-1"></i></span>
                    </a>
                </s:if>
                <s:if test="%{#session.propietario != null}">
                    <a href="<s:url action="volverInicioPropietario"></s:url>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                        <span class="fs-4">UPOVET <i class="fa-solid fa-paw p-1"></i></span>
                    </a>
                    <span class="d-flex align-items-center mb-3 mb-md-0 link-body-emphasis text-decoration-none p-3"><i class="fa-solid fa-user xs p-1"></i> <s:property value="#session.propietario.nombre"></s:property></span>
                    <ul class="nav nav-pills">
                        <li class="nav-item p-1"><a href="<s:url action='logoutPropietario'/>" class="btnModificado btn"><s:text name="submit_logout" /></a></li>
                    </ul>
                    
                </s:if>
                <s:if test="%{#session.veterinario != null}">
                    <a href="<s:url action="volverInicioVeterinario"></s:url>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                        <span class="fs-4">UPOVET <i class="fa-solid fa-paw p-1"></i></span>
                    </a>
                    
                    <span class="d-flex align-items-center mb-3 mb-md-0 link-body-emphasis text-decoration-none p-3"><i class="fa-solid fa-user-nurse xs p-1"></i> <s:property value="#session.veterinario.nombre"></s:property></span>
                    <ul class="nav nav-pills">
                        <li class="nav-item p-1"><a href="<s:url action='logoutPropietario'/>" class="btnModificado btn"><s:text name="submit_logout" /></a></li>
                    </ul>
                </s:if>
                
            </header>
        </div>
    </body>
</html>
