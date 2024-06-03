<%-- 
    Document   : facturasVeterinario
    Created on : 03-jun-2024, 12:29:15
    Author     : cbgcl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus facturas</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Tus facturas</h1>
    <s:if test="%{!facturas.isEmpty()}">
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
                            <s:submit name="eliminarFactura" key="submit_eliminarFactura"/>
                            <s:hidden name="numFactura" value="%{#factura.id}"></s:hidden>
                        </s:form>
                    </td>                      
                    <td>
                        <s:form action="formModificarFactura" method="post">
                            <s:submit name="modificarFactura" key="submit_modificarFactura"/>
                            <s:hidden name="numFactura" value="%{#factura.id}"></s:hidden>
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
        <s:submit name="volverVeterinario" ke="submit_volver"/>
    </s:form>
    <jsp:include page="../FOOTER.jsp" />
</body>
</html>

