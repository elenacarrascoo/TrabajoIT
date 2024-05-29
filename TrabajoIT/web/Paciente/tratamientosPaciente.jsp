<%-- 
    Document   : tratamientosPaciente
    Created on : 08-may-2024, 13:26:23
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Los tratamientos son:</h1>

        <s:if test="%{!listaTratamientos.isEmpty()}">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th>Fecha</th>
                        <th>Precio</th>
                        <th>Resultados</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de citas -->
                    <s:iterator value="listaTratamientos" var="tratamiento">
                        <tr>
                            <td><s:property value="#tratamiento.id" /></td>
                            <td><s:property value="#tratamiento.tipo" /></td>
                            <td><s:property value="#tratamiento.fecha" /></td>
                            <td><s:property value="#tratamiento.precio" /></td>
                            <td><s:property value="#tratamiento.resultados" /></td>
                            <td>
                                <s:form action="Tratamiento" method="post">
                                    <s:submit name="boton" value ="Modificar_Tratamiento" key="submit_modificarTratamiento" />
                                    <s:hidden name="idTratamiento" value="%{#tratamiento.id}"/> 
                                </s:form>

                                <s:form action="Tratamiento" method="post">
                                    <s:submit name="boton"  value="Eliminar Tratamiento" key="submit_eliminarTratamiento" />
                                    <s:hidden name="idTratamiento" value="%{#tratamiento.id}"/> 
                                </s:form>
                            </td>

                        </tr>
                    </s:iterator>
                        
                        



                </tbody>
            </table>

            <s:form action="opcionesAdicionales" method="post">
                <s:submit name="boton" key="submit_volver"/>
                <s:submit name="boton" key="submit_logout"/>
            </s:form>

        </s:if>
        <s:else>
            <p>Tratamiento no encontrado.</p>
            <s:form action="opcionesAdicionales" method="post">
                <s:submit name="boton" key="submit_volver"/>
                <s:submit name="boton" key="submit_logout"/>
            </s:form>
        </s:else>
    </body>
</html>

