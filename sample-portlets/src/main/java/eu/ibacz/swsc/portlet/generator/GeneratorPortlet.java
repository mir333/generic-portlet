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
    private static final String JSP_VIEW = "/WEB-INF/jsp/generator/view.jsp";
    private static final String ATTR_NUMBERS = "numbers";
    private static final Integer LIMIT = 20;

    @Override
       protected void doView(RenderRequest request, RenderResponse response) throws PortletException,
            IOException {

        request.setAttribute(ATTR_NUMBERS, fib(LIMIT));

           PortletRequestDispatcher dispatcher =
                   getPortletContext().getRequestDispatcher(JSP_VIEW);
           dispatcher.include(request, response);
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
