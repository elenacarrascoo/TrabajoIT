
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <div class="container-fluid text-center" style="height: 79vh;">
            <div class="row h-100 justify-content-center">
                <main class="form-signin col-lg-3 col-md-6 col-12 align-self-center">
                    <h1>Registro de nuevo veterinario </h1>


                    <s:form name="altaVeterinario" action="altaVeterinario" method="post">
                        <table class="wwFormTable">
                            <tbody>
                                <tr>
                                    <td class="tdLabel">
                                        <div class="form-floating">
                                            <s:textfield name="dni" label="DNI" required="true" key="dni.requerido"></s:textfield>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tdLabel">
                                            <div class="form-floating">
                                            <s:textfield name="nombre" label="Nombre" required="true" key="nombre.requerido"></s:textfield>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tdLabel">
                                            <!-- ComboBox para especialidad -->
                                            <div class="form-floating">
                                            <s:select 
                                                name="especialidad" 
                                                label="Especialidad" 
                                                list="{'Medicina Interna','Cirugía General','Cirugía Ortopédica', 'Dermatología', 'Odontología Veterinaria','Oftalmología', 'Cardiología', 'Neurología', 'Oncología','Anestesiología','Radiología e Imagenología','Medicina de Emergencia','Comportamiento y Etología','Terapia Rehabilitativa','Zootecnia'}"
                                                headerKey="-1" 
                                                headerValue="Selecciona una especialidad" 
                                                required="true"/>
                                        </div>
                                    </td>

                                    <td class="tdLabel">
                                        <div class="form-floating">
                                            <s:textfield name="experiencia" label="Experiencia" required="true" key="experiencia.requerido"></s:textfield>
                                            </div>
                                        </td>

                                        <td class="tdLabel">
                                            <div class="form-floating">
                                            <s:textfield name="telefono" label="Telefono" required="true" key="telefono.requerido"></s:textfield>
                                            </div>
                                        </td>

                                        <td class="tdLabel">
                                            <div class="form-floating">
                                            <s:textfield name="correo" label="Correo electronico" required="true" key="correo.requerido"></s:textfield>
                                            </div>
                                        </td>

                                        <td class="tdLabel">
                                            <div class="form-floating">
                                            <s:password name="password" label="Password" required="true" key="password.requerida"></s:password>
                                            </div>
                                        </td>


                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div align="right">
                                            <s:submit name="boton" value="registro"></s:submit>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                    </s:form>
                    <s:form action="veterinarioActions" method="post">
                        <s:submit name="boton" value="Cancelar"></s:submit>
                    </s:form>
                </main> 
            </div>
        </div>
        <jsp:include page="../FOOTER.jsp" />

    </body>
</html>
