package hello.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

// @Component // 주석처리 하게 되면, 스프링 부트가 제공하는 기본 오류 매커니즘이 동작한다. (?) (BasicErrorController)
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> { // pom.xml

    // 이름 그대로 웹 서버를 커스터마이징 하는 것이다.
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        // HTTP 상태 코드에 따른 오류 처리 ( response.sendError(..) )
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404"); // 404 예외 발생시, /error-page/400 경로를 호출해라.
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500"); // 500 예외 발생시, /error-page/500 경로를 호출해라.

        // 예외 타입에 따른 오류 처리 ( throw ex )
        ErrorPage errorPageEx = new ErrorPage(RuntimeException.class, "/error-page/500"); // RuntimeException이 발생하면, /error-page/500 경로를 호출해라.

        factory.addErrorPages(errorPage404, errorPage500, errorPageEx);
    }
}