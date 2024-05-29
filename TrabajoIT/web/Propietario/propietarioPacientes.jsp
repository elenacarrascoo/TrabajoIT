<%-- 
    Document   : propietarioPacientes
    Created on : 27-abr-2024, 16:42:59
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus mascotas</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <div class="container-fluid pt-3 pb-3" style="min-height: 70vh">
            <h1>Tus mascotas:</h1>
            <table border="1" class="table">
                <thead style="color: #3C6E71 ">
                    <tr>
                        <th>ID</th>
                        <th>Foto</th>
                        <th>Nombre</th>
                        <th>Especie</th>
                        <th>Raza</th>
                        <th>Sexo</th>
                        <th>Edad</th>
                        <th>Fecha de nacimiento</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <s:iterator var="paciente" value="listaPacientes">
                        <tr>
                            <td><s:property value="#paciente.id"/></td>
                            <td><img src="${pageContext.request.contextPath}${paciente.foto}" alt="sinFoto" width="75" height="75" class="rounded-circle"></td>                          
                            <td><s:property value="#paciente.nombre"/></td>
                            <td><s:property value="#paciente.especie"/></td>
                            <td><s:property value="#paciente.raza"/></td>
                            <td><s:property value="#paciente.sexo"/></td>
                            <td><s:property value="#paciente.edad"/></td>
                            <td><s:property value="#paciente.fechaNacimiento"/></td>
                            <td>
                                <div class="row col-12 mt-1">
                                    <div class="col-6 justify-content-center">
                                        <s:form action="cogerCita" method="post">
                                            <s:submit name="cogerCita" key="submit_cogerCita"></s:submit>
                                            <s:hidden name="idPaciente" value="%{#paciente.id}"/>
                                        </s:form>
                                    </div>
                                    <div class="col-6 justify-content-center">
                                        <s:form action="consultarHistorial" method="post">
                                            <s:hidden name="pacienteConsultar" value="%{#paciente.id}"/>
                                            <s:submit name="consultarHistorial" key="submit_consultarHistorial"></s:submit>
                                        </s:form>
                                    </div>
                                </div>
                                <div class="row col-12 mt-1">
                                    <div class="col-6 justify-content-center">
                                        <!-- Mirar este hidden -->
                                        <s:form action="gestionCitas" method="post">
                                            <s:hidden name="pacienteConsultar" value="%{#paciente.id}"/>
                                            <s:submit name="gestionCitas" key="submit_gestionCitas"></s:submit>
                                        </s:form>
                                    </div>
                                    <div class="col-6 justify-content-center">
                                        <s:form action="eliminarPaciente" method="post">
                                            <s:submit name="eliminarPaciente" key="submit_eliminarPaciente"/>
                                            <s:hidden name="idPaciente" value="%{#paciente.id}"/>
                                        </s:form>
                                    </div>
                                </div>
                                <div class="row col-12 mt-1">
                                    <div class="col-12 justify-content-center">
                                        <s:form action="formModificarPaciente" method="post">
                                            <s:submit name="modificarPaciente" key="submit_modificarPaciente"/>
                                            <s:hidden name="idPaciente" value="%{#paciente.id}"></s:hidden>
                                        </s:form>
                                    </div>    

                                </div>



                            </td>
                        </tr>
                    </s:iterator>

                </tbody>             
            </table>
            <a href="<s:url action='volverPropietario'/>" class="btnModificado btn mt-5">
                <s:text name="submit_volver" />
            </a> 
        </div>

        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
