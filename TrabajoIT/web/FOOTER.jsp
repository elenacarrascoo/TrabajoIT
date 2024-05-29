<%-- 
    Document   : FOOTER
    Created on : 29-may-2024, 13:11:00
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid" style="background-color: #353535; position: absolute">
            <footer class="py-1 my-2">
                <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                    <s:if test="%{#session.propietario == null && #session.veterinario == null}">
                        <li class="nav-item"><a href="index.jsp" class="nav-link px-2 footerFuente">Inicio</a></li>
                    </s:if>
                    <s:if test="%{#session.propietario != null}">
                        <li class="nav-item"><a href="<s:url action="volverInicioPropietario"></s:url>" class="nav-link px-2 footerFuente">Inicio</a></li>
                    </s:if>
                    <s:if test="%{#session.veterinario != null}">
                        <li class="nav-item"><a href="<s:url action="volverInicioVeterinario"></s:url>" class="nav-link px-2 footerFuente">Inicio</a></li>
                    </s:if>
                    <li class="nav-item"><a href="<s:url action="acercaDeNosotros"></s:url>" class="nav-link px-2 footerFuente">Acerca de nosotros</a></li>
                </ul>
                <p class="text-center footerFuente">© 2024 <a href="" class="px-2 footerFuente" >UPOVET</a></p>
            </footer>
        </div>
    </body>
</html>
