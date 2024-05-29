<%-- 
    Document   : listaVeterinarios
    Created on : 29-may-2024, 10:00:00
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Veterinarios</title>
        <s:head/>
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
        </style>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Lista de Veterinarios</h1>
        
        <div class="table-container">
            <!-- Verifica que la lista no sea nula y tenga elementos -->
            <s:if test="%{!listaVeterinarios.isEmpty()}">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Especialidad</th>
                            <th>Experiencia</th>
                            <th>Teléfono</th>
                            <th>Correo</th>
                            <th>DNI</th>
                            <th>Contraseña</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Itera sobre la lista de veterinarios -->
                        <s:iterator value="listaVeterinarios" var="veterinario">
                            <tr>
                                <td><s:property value="#veterinario.nombre"/></td>
                                <td><s:property value="#veterinario.especialidad"/></td>
                                <td><s:property value="#veterinario.experiencia"/></td>
                                <td><s:property value="#veterinario.telefono"/></td>
                                <td><s:property value="#veterinario.correo"/></td>
                                <td><s:property value="#veterinario.dni"/></td>
                                <td><s:property value="#veterinario.contraseña"/></td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
                
                <div class="form-actions">
                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Volver"/>
                    </s:form>
                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="LogOut"/>
                    </s:form>
                </div>
            </s:if>
            
            <!-- Si la lista es nula o está vacía -->
            <s:else>
                <p>No se encontraron veterinarios.</p>
                
                <div class="form-actions">
                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Volver"/>
                    </s:form>
                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="LogOut"/>
                    </s:form>
                </div>
            </s:else>
        </div>
        
        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
