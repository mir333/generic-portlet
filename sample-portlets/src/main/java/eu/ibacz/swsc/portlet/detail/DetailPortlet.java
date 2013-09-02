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

    public Long fib(Integer n) {
        if (n < 2) {
            return Long.valueOf(n);
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
