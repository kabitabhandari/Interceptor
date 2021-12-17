package interceptor.example.myinterceptor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class Slf4jMDCFilterConfiguration {

    private static final String REQUEST_ID = "RequestId";

    @Bean
    public FilterRegistrationBean<Filter> servletRegistrationBean() {
        final FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        final Slf4jMDCFilter log4jMDCFilterFilter = new Slf4jMDCFilter(REQUEST_ID);
        registrationBean.setFilter(log4jMDCFilterFilter);
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
