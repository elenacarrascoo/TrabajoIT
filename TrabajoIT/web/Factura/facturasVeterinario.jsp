<%-- 
    Document   : facturasVeterinario
    Created on : 03-jun-2024, 12:29:15
    Author     : cbgcl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus facturas</title>
         <style>
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
                font-size: 1em;
                font-family: 'Arial', sans-serif;
                text-align: left;
            }
            table thead tr {
                background-color: #009879;
                color: #ffffff;
                text-align: left;
            }
            table th, table td {
                padding: 12px 15px;
                border: 1px solid #dddddd;
            }
            table tbody tr {
                border-bottom: 1px solid #dddddd;
            }
            table tbody tr:nth-of-type(even) {
                background-color: #f3f3f3;
            }
            table tbody tr:last-of-type {
                border-bottom: 2px solid #009879;
            }
            table tbody tr:hover {
                background-color: #f1f1f1;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Tus facturas</h1>
    <s:if test="%{!facturas.isEmpty()}">
        <table border="1">
            <thead>
                <tr>
                    <th>Numero factura</th>
                    <th>Fecha</th>
                    <th>Importe</th>
                    <th>Propietario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator var="factura" value="facturas">
                
                <tr>
                    <td><s:property value="#factura.numFactura"/></td>
                    <td><s:property value="#factura.fecha"/></td>
                    <td><s:property value="#factura.importe"/></td>
                    <td><s:property value="#factura.propietario.dni"/></td>
                    <td>
                        <s:form action="eliminarFactura" method="post">
                            <s:submit name="eliminarFactura" key="submit_eliminarFactura"/>
                            <s:hidden name="numFactura" value="%{#factura.numFactura}"></s:hidden>
                        </s:form>
                    </td>                      
                    <td>
                        <s:form action="formModificarFactura" method="post">
                            <s:submit name="formModificarFactura" key="submit_modificarFactura"/>
                            <s:hidden name="numFactura" value="%{#factura.numFactura}"></s:hidden>
                        </s:form>
                    </td>
                </tr>
            </s:iterator>       
            </tbody>   
        </table>
    </s:if>
    <s:else>
        <p> No existen facturas.</p>
    </s:else>
    <s:form action="volverVeterinario" method="post">
        <s:submit name="volverVeterinario" key="submit_volver"/>
    </s:form>
    <jsp:include page="../FOOTER.jsp" />
    

</body>
</html>

