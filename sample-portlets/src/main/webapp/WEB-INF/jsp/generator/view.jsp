<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jspf" %>

<f:setBundle basename="content.generator"/>


<h1><f:message key="generator-title"/></h1>
<table style="width: 100%">
    <tr>
        <th><f:message key="generator-table-index"/></th>
        <th><f:message key="generator-table-number"/></th>
    </tr>
    <c:forEach var="number" items="${numbers}" varStatus="status">
        <tr>
            <td>
                    ${status.index}
            </td>
            <td>
                    ${number}
            </td>
        </tr>
    </c:forEach>
</table>