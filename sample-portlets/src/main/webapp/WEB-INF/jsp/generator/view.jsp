<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>
<%@taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>

<portlet:defineObjects/>

<c:set var="ns"><portlet:namespace/></c:set>
<c:set var="resourcesPath">
    <%=request.getContextPath()%>
</c:set>

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