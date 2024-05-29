
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

                    <h1>Registro de nuevo tratamiento </h1>
                    <s:form name="Tratamiento" action="Tratamiento" method="post">
                        <table class="wwFormTable">
                            <tbody>
                                <tr>
                                    <td class="tdLabel">
                                        <div class="form-floating">
                                            <s:textfield name="fecha" label="Fecha" required="true"></s:textfield>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tdLabel">
                                            <div class="form-floating">
                                            <s:textfield name="precio" label="Precio" required="true" ></s:textfield>
                                            </div>
                                        </td>

                                        <td class="tdLabel">
                                            <div class="form-floating">
                                            <s:select 
                                                name="tipo" 
                                                label="Tipo" 
                                                list="{'Quirúrgico','Desparasitación','Exámenes Clínicos', 'Fisioterapia','Vacunación', 'Diagnóstico', 'Terapias Rehabilitativas', 'Esterilización y Castración','Diagnóstico por Imagen','Tratamiento de Enfermedades Crónicas' }" 
                                                headerKey="-1" 
                                                headerValue="Selecciona un tipo" required="true"/>
                                        </div>
                                    </td>


                                    <td class="tdLabel">
                                        <s:textfield name="resultados" label="Resultados" required="true"></s:textfield>
                                        </td>



                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div align="right">
                                            <s:submit name="boton" value="Registrar_Tratamiento"></s:submit>
                                            </div>
                                        </td>
                                    </tr>

                            </s:form>

                            <s:form action="Tratamiento" method="post">
                                <s:submit name="boton" value="Volver"/>
                                <s:submit name="boton" value="LogOut"/>

                            </s:form>

                        </tbody>
                    </table>
                </main>
            </div>
        </div>

        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
