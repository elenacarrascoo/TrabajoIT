<%-- 
    Document   : modificarTratamiento
    Created on : 09-may-2024, 9:20:40
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Tratamiento</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <div class="container-fluid text-center" style="height: 79vh;">
            <div class="row h-100 justify-content-center">
                <main class="form-signin col-lg-3 col-md-6 col-12 align-self-center">
                    <h1 class="h3 mb-3 fw-normal">Modificación de tratamiento</h1>


                    <s:form name="Tratamiento" action="Tratamiento" method="post">
                        <table class="wwFormTable">
                            <tbody>

                                <tr>

                                     <td class="tdLabel">
                                            <div class="form-floating">
                                            <s:select 
                                                name="tipo" 
                                                label="Tipo" 
                                                list="{'Quirúrgico','Desparasitación','Exámenes Clínicos', 'Fisioterapia','Vacunación', 'Diagnóstico', 'Terapias Rehabilitativas', 'Esterilización y Castración','Diagnóstico por Imagen','Tratamiento de Enfermedades Crónicas' }" 
                                                headerKey="-1" 
                                                headerValue="Selecciona un tipo" required="true" value="%{#session.tratamiento.tipo}"/>
                                        </div>
                                    </td>

                                    <td class="tdLabel">
                                        <div class="form-floating">
                                            <s:textfield name="fecha" label="Fecha" type="date" required="true" value="%{#session.tratamiento.fecha}"/>
                                        </div>
                                    </td>

                                    <td class="tdLabel">
                                        <div class="form-floating">
                                            <s:textfield name="precio" label="Precio" value="%{#session.tratamiento.precio}" required="true"/>
                                        </div>
                                    </td>

                                    <td class="tdLabel">
                                        <div class="form-floating">
                                            <s:textfield name="resultados" label="Resultados" value="%{#session.tratamiento.resultados}" required="true"/>
                                        </div>
                                    </td>                          


                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <div align="right">
                                            <s:submit name="boton" value="Modificacion"/>
                                            <s:hidden name ="idTratamiento" value="%{id}"></s:hidden>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                    </s:form>

                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Volver"/>
                        <s:submit name="boton" value="LogOut"/>

                    </s:form>
                </main>

            </div>
        </div>


        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
