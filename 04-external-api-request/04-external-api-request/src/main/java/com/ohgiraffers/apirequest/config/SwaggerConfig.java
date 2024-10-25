package com.ohgiraffers.apirequest.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * Spring 에서 외부 API 요청 및 처리
 *
 * 대표적인 라이브러리
 * - HttpClient
 * - RestTemplate
 * - WebClient
 * - OpenFeign
 *
 * 주의할 점
 * - request와 response가 외부서버와 맞게 설정되어있는지 확인!
 * */

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){

        return new OpenAPI()
                .components(new Components())
                .info(swaggerInfo());
    }

    private Info swaggerInfo(){
        return new Info()
                .title("Ohgiraffers API")
                .description("외부 API요청 테스트")
                .version("1.0.0");
    }

}
