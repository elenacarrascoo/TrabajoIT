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
        <h1>Tus mascotas:</h1>
        <table border="1" class="wwFormTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Especie</th>
                    <th>Raza</th>
                    <th>Sexo</th>
                    <th>Edad</th>
                    <th>Fecha de nacimiento</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator var="paciente" value="listaPacientes">
                    <tr>
                        <td><s:property value="#paciente.id"/></td>
                        <td><s:property value="#paciente.nombre"/></td>
                        <td><s:property value="#paciente.especie"/></td>
                        <td><s:property value="#paciente.raza"/></td>
                        <td><s:property value="#paciente.sexo"/></td>
                        <td><s:property value="#paciente.edad"/></td>
                        <td><s:property value="#paciente.fechaNacimiento"/></td>
                        <td>
                            <s:form action="cogerCita" method="post">
                                <s:submit name="cogerCita" key="submit_cogerCita"></s:submit>
                                <s:hidden name="idPaciente" value="%{#paciente.id}"/>
                            </s:form>
                        
                            <s:form action="consultarHistorial" method="post">
                                <s:hidden name="pacienteConsultar" value="%{#paciente.id}"/>
                                <s:submit name="consultarHistorial" key="submit_consultarHistorial"></s:submit>
                            </s:form>
                        
                            <!-- Mirar este hidden -->
                            <s:form action="gestionCitas" method="post">
                                <s:hidden name="pacienteConsultar" value="%{#paciente.id}"/>
                                <s:submit name="gestionCitas" key="submit_gestionCitas"></s:submit>
                            </s:form>
                        
                            <s:form action="eliminarPaciente" method="post">
                                <s:submit name="eliminarPaciente" key="submit_eliminarPaciente"/>
                                <s:hidden name="idPaciente" value="%{#paciente.id}"/>
                            </s:form>
                        
                            <s:form action="formModificarPaciente" method="post">
                                <s:submit name="modificarPaciente" key="submit_modificarPaciente"/>
                                <s:hidden name="idPaciente" value="%{#paciente.id}"></s:hidden>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
                     
            </tbody>             
        </table>
        <s:form action="volverPropietario" method="post">
            <s:submit name="volverPropietario" key="submit_volver"/>
        </s:form>
    </body>
</html>
