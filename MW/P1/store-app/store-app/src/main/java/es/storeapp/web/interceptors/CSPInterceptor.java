package es.storeapp.web.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class CSPInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        response.setHeader("Content-Security-Policy", 
            "default-src  'self'; " +
            "img-src * 'self' data:; " +
            "script-src   'self' 'unsafe-inline'; " +
            "style-src   'self' 'unsafe-inline';"
            + "frame-ancestors 'none';" +
                "font-src 'self';" +
                "base-uri 'self';" +
                "block-all-mixed-content;" +
                "frame-src 'self';");
        return true;
    }
    
}
