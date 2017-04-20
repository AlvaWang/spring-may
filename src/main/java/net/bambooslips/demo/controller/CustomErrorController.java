package net.bambooslips.demo.controller;

/**
 * Created by Eureka on 2016/5/13.
 */

import net.bambooslips.demo.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomErrorController.class);

    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH, produces = {"text/html","application/xhtml+xml","application/xml"})
    ModelAndView error_view(HttpServletRequest request, HttpServletResponse response) {
        LOG.warn("Errors view has been called");
        //yes this is called = =
        ErrorResponse er =  new ErrorResponse(response.getStatus(), getErrorAttributes(request, false));
        ModelAndView m = new ModelAndView("/error");
        m.addObject("url", request.getRequestURI());;
        m.addObject("status", er.status);
        m.addObject("error", er.error);
        m.addObject("exception", er.exception);
        m.addObject("message", er.message);
        m.addObject("timestamp", er.timeStamp);
        return m;
    }

    @RequestMapping(value = PATH, produces = {"application/json","*/*"})
    @ResponseBody
    ErrorResponse error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        LOG.info(getErrorAttributes(request, false).toString());
        return new ErrorResponse(response.getStatus(), getErrorAttributes(request, false));
}

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

}