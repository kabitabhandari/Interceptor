package interceptor.example.myinterceptor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class Slf4jMDCFilter extends OncePerRequestFilter {

    private final String requestId;


    public Slf4jMDCFilter(String responseHeader) {
        this.requestId = responseHeader;
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain)
            throws java.io.IOException, ServletException {
        try {
            final String token = UUID.randomUUID().toString();
            MDC.put(requestId, token);
            response.addHeader(requestId, token);
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}