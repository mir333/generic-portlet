<%@ page import="static eu.ibacz.swsc.portlet.generator.GeneratorPortletConstants.*" %>
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
        <portlet:actionURL var="url" name="<%=SHOW_DETAIL%>">
            <portlet:param name="<%=PARAM_INDEX%>" value="${status.index}"/>
            <portlet:param name="<%=VIEW_PARAM%>" value="<%=VIEW_DETAIL%>"/>
        </portlet:actionURL>
        <tr>
            <td>
                <c:out value="${status.index}"/>
            </td>
            <td>
                <c:out value="${number}"/>
            </td>
            <td>
                <a href="${url}">
                    <c:if test="${status.index gt 1}">
                        <f:message key="generator-detail"/>
                    </c:if>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>