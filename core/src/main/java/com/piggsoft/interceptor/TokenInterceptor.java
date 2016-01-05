package com.piggsoft.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggsoft.constants.Constants;
import com.piggsoft.context.TokenManager;
import com.piggsoft.model.User;
import com.piggsoft.response.Rsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <br>Created by fire pigg on 2015/12/31.
 *
 * @author piggsoft@163.com
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURL().indexOf(Constants.TOKEN_URL) != -1) {
            return true;
        }
        String token = request.getParameter(Constants.REQUEST_TOKEN_NAME);
        if (StringUtils.isEmpty(token)) {
            writeRsp(request, response, "403", "token is required");
            return false;
        }
        User user = TokenManager.get(token);
        if (null == user) {
            writeRsp(request, response, "402", "token expired");
            return false;
        }
        return true;
    }


    private void writeRsp(HttpServletRequest request, HttpServletResponse response, String code, String msg) throws IOException {
        String callback = request.getParameter(Constants.JSONP_CALLBACK_PARAM_NAME);
        Rsp rsp = new Rsp(code, msg);
        StringBuffer json = new StringBuffer(objectMapper.writeValueAsString(rsp));
        if (!StringUtils.isEmpty(callback)) {
            json.insert(0, callback + "(");
            json.append(")");
        }
        response.getWriter().write(json.toString());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
