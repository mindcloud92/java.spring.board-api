package io.cloudrium.sample.board.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApiConfiguration implements WebMvcConfigurer {

    private final String LOCAL_BOARD_WEB_ORIGIN = "http://localhost:8080";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(LOCAL_BOARD_WEB_ORIGIN)
                .allowedHeaders("*")
                .allowedMethods("*");

    }
}
