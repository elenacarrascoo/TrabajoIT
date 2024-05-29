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
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px;
            }
            h1 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }
            .table-container {
                background-color: #ffffff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 800px;
                margin: auto;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            th, td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            th {
                background-color: #009879;
                color: #ffffff;
                font-weight: bold;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            tr:hover {
                background-color: #ddd;
            }
            .form-actions {
                display: flex;
                justify-content: center;
                gap: 10px;
            }
            .form-actions input[type="submit"] {
                background-color: #009879;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
            .form-actions input[type="submit"]:hover {
                background-color: #007a63;
            }
            .message {
                text-align: center;
                color: #777;
                font-size: 1.2em;
            }
        </style>
    </head>
    <body>
<<<<<<< Updated upstream
        <div class="container-fluid pt-3 pb-3" style="min-height: 70vh">
            <h1>Los tratamientos son:</h1>
=======
        <jsp:include page="../HEADER.jsp" />


        <h1>Los tratamientos son:</h1>
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
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
=======
                    </s:iterator>


>>>>>>> Stashed changes





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
        </div>
    </body>
    
</html>

