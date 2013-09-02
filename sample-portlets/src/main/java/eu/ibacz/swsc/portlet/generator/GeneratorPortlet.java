/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package eu.ibacz.swsc.portlet.generator;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class GeneratorPortlet extends GenericPortlet {

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException,
            IOException {
        String jspToRender;

        String view = request.getParameter(GeneratorPortletConstants.VIEW_PARAM);
        if (GeneratorPortletConstants.VIEW_DETAIL.equals(view)) {
            jspToRender = doViewDetail(request, response);
        } else {
            jspToRender = doViewMain(request, response);
        }


        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher(jspToRender);
        dispatcher.include(request, response);
    }

    private String doViewDetail(RenderRequest request, RenderResponse response) {
        return GeneratorPortletConstants.JSP_DETAIL;
    }

    private String doViewMain(RenderRequest request, RenderResponse response) {
        request.setAttribute(GeneratorPortletConstants.ATTR_NUMBERS, fib(GeneratorPortletConstants.LIMIT));
        return GeneratorPortletConstants.JSP_VIEW;
    }



    public List<Long> fib(Integer limit) {
        List<Long> result = new ArrayList<Long>(limit);

        result.add(0l);
        result.add(1l);

        for (int i = 2; i < limit; i++) {
            result.add(result.get(i - 1) + result.get(i - 2));
        }

        return result;
    }
}
