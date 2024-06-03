<%-- 
    Document   : propietarioFacturas
    Created on : 27-abr-2024, 16:43:14
    Author     : ecarr
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus facturas</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Tus facturas</h1>
        <table border="1" class="wwFormTable">
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
                                <s:submit name="eliminarFactura" value="Eliminar factura"/>
                                <s:hidden name="numFactura" value="%{#factura.id}"></s:hidden>
                            </s:form>
                        </td>                      
                        <td>
                            <s:form action="formModificarFactura" method="post">
                                <s:submit name="modificarFactura" value="Modificar factura"/>
                                <s:hidden name="numFactura" value="%{#factura.id}"></s:hidden>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>       
            </tbody>   
        </table>
        <s:form action="volverPropietario" method="post">
            <s:submit name="volverPropietario" value="Volver"/>
        </s:form>
        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
