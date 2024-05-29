<%-- 
    Document   : bajaVeterinario
    Created on : 30-abr-2024, 18:52:08
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja Veterinario</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <div class="container-fluid text-center" style="height: 79vh;">
            <div class="row h-100 justify-content-center">
                <main class="form-signin col-lg-3 col-md-6 col-12 align-self-center">
                    <h1 class="h3 mb-3 fw-normal">Baja Veterinario</h1>

                    <s:form action="eliminacionVeterinario" method="post">

                        <div class="form-floating">
                            <s:textfield name="dni" label="DNI a dar de baja"></s:textfield>
                            </div>
                            <div class="form-floating">
                            <s:password name="password" label="Introduce tu contraseña"></s:password>
                            </div>
                            <div class="form-floating">
                            <s:submit name="boton" value="Dar de Baja" key="submit_bajaVeterinario"/>
                        </div>
                    </s:form>

                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Volver"/>
                    </s:form>

                </main>

            </div>
        </div>

        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
