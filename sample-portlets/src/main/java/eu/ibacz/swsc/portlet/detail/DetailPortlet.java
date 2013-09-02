package eu.ibacz.swsc.portlet.detail;

/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static eu.ibacz.swsc.portlet.detail.DetailPortletConstants.*;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class DetailPortlet extends GenericPortlet {


    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        String entryId = request.getParameter(PRP_ENTRY_ID);
        if (entryId != null && !EMPTY_STRING.equals(entryId)) {
            Long fib = fib(Integer.valueOf(entryId));
            request.setAttribute(ATTR_FIB_NO, fib);
        }
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher(JSP_VIEW);
        dispatcher.include(request, response);
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
        String resourceID = request.getResourceID();
        if (GET_TIME_RES.equals(resourceID)) {
            sendTime(response);
        } else {
            super.serveResource(request, response);
        }
    }

    private void sendTime(ResourceResponse response) {
        Date now = new Date();
        PrintWriter out = null;
        try {
            response.setContentType("text/json");
            out = response.getWriter();
            out.print("{time:'");
            out.print(now.toString());
            out.print("'}");
        } catch (IOException ex) {
            // log error
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private Long fib(Integer n) {
        if (n < 2) {
            return Long.valueOf(n);
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
