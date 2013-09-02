<%@ page import="eu.ibacz.swsc.portlet.detail.DetailPortletConstants" %>
<%--* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jspf" %>


<h1>
    <c:out value="${fibNumber}"/>
</h1>

<h2>
    <span id="${ns}clock"></span>
</h2>

<portlet:resourceURL id="<%=DetailPortletConstants.GET_TIME_RES%>" var="resUrl"/>
<script language="javascript" type="text/javascript">
    AUI().ready('aui-io-request', 'aui-node', function (A) {

        setInterval(function () {
            A.io.request('${resUrl}', {
                dataType: 'json',
                method: 'POST',
                data: {   ts: new Date()   },
                on: {
                    success: function () {
                        var time = eval(this.get('responseData'));
                        A.one("#${ns}clock").set('text', time);
                    }
                }
            });
        }, 1000);

    });

</script>
