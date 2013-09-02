/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package eu.ibacz.swsc.portlet.generator;

import eu.ibacz.swsc.portlet.detail.DetailPortletConstants;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static eu.ibacz.swsc.portlet.generator.GeneratorPortletConstants.*;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class GeneratorPortlet extends GenericPortlet {

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException,
            IOException {
        String jspToRender;

        String view = request.getParameter(VIEW_PARAM);
        if (VIEW_DETAIL.equals(view)) {
            jspToRender = doViewDetail(request, response);
        } else {
            jspToRender = doViewMain(request, response);
        }


        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher(jspToRender);
        dispatcher.include(request, response);
    }

    private String doViewDetail(RenderRequest request, RenderResponse response) {
        String index = request.getParameter(PARAM_INDEX);
        Integer i = Integer.parseInt(index);
        List<Long> fib = fib(i + 1);
        int size = fib.size();

        request.setAttribute(ATTR_FIRST, fib.get(size - 3));
        request.setAttribute(ATTR_SECOND, fib.get(size - 2));
        request.setAttribute(ATTR_SUM, fib.get(size - 1));
        return JSP_DETAIL;
    }

    private String doViewMain(RenderRequest request, RenderResponse response) {
        request.setAttribute(ATTR_NUMBERS, fib(LIMIT));
        return JSP_VIEW;
    }


    @ProcessAction(name = SHOW_DETAIL)
    public void showDetail(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        response.setRenderParameters(request.getParameterMap());
        response.setRenderParameter(DetailPortletConstants.PRP_ENTRY_ID, request.getParameter(PARAM_INDEX));
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
