<%-- 
    Document   : login
    Created on : 27-abr-2024, 10:29:06
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <s:head/>
    </head>
        <body>

        <jsp:include page="HEADER.jsp" />

        <div class="container-fluid text-center" style="height: 79vh;">
            <div class="row h-100 justify-content-center">
                <main class="form-signin col-lg-3 col-md-6 col-12 align-self-center">
                    <s:form action="login" method="post" theme="simple">
                        <h1 class="h3 mb-3 fw-normal">Introduce tus datos</h1>
                        <div class="form-floating">
                            <s:textfield name="dni" id="floatingInput" cssClass="form-control" placeholder="12345678A"></s:textfield>
                                <label for="floatingInput">DNI</label>
                            </div>
                            <div class="form-floating">
                            <s:password name="password" placeholder="Contraseña" cssClass="form-control"></s:password>
                                <label for="floatingInput">Contraseña</label>
                            </div>
                        <s:submit value="Ingresar" name="btnLogin" cssClass="btnModificado w-100 btn mt-3"></s:submit>
                        <s:fielderror cssClass="pt-3"></s:fielderror>
                    </s:form>
                        <p class="pt-2"><a class="link-dark" href="<s:url action="registrarForm"/>">Registrarse</a></p>
                </main>

            </div>
        </div>

        <jsp:include page="FOOTER.jsp" />

    </body>
</html>
