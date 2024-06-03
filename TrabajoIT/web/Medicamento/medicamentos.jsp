<%-- 
    Document   : medicamentos
    Created on : 27-abr-2024, 16:44:27
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicamentos</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Medicamentos disponibles</h1>
        <s:if test="%{medicamentos!=null}">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Fecha Caducidad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><s:property value="medicamentos.id"/></td>
                            <td><s:property value="medicamentos.nombre"/></td>
                            <td><s:property value="medicamentos.fechaCaducidad"/></td>
                            <td>
                                <s:form action="eliminarMedicamento" method="post">
                                    <s:hidden name="idMedicamentoEliminar" value="%{medicamentos.id}"/>
                                    <s:submit action="eliminarMedicamento" key="submit_eliminarMedicamento"/>
                                </s:form>
                                <s:form action="formActualizarMedicamento" method="post">
                                    <s:hidden name="idMedicamentoModificar" value="%{#medicamento.id}"/>
                                    <<s:submit action="formActualizarMedicamento" key="submit_actualizarMedicamento"/>
                                </s:form>
                            </td>
                        </tr>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <p>No hay medicamentos asociados a esta cita.</p>
        </s:else>
        <s:form action="opcionesAdicionalesMedicamento" method="post">
            <s:submit name="boton" value="Volver"/>
            <s:submit name="boton" value="LogOut"/>
        </s:form>
        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
