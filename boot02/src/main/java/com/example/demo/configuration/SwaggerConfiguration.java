package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	//Swagger UI 만들기
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					//앱정보 설정
					.apiInfo(app()).select()
					//분석할 대상을 설정
					//[1] 전체
					//.apis(RequestHandlerSelectors.any())
					//[2] 패키지를 특정
					.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
						.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo app() {
		return new ApiInfoBuilder()
						.title("레스트 서버 테스트")
						.description("테스트 슬명")
						.version("0.0.1")
					.build();
	}
}
