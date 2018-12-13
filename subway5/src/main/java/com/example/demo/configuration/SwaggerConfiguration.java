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

/*
 * Swagger 설정 파일
 * 이 설정이 정상적으로 등록된다면 다음의 주소가 생성됨
 * 			http://아이피:포트/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						//앱 정보 설정
						.apiInfo(app()).select()
						//분석할 대상을 설정
						//[1] 전체
						//.apis(RequestHandlerSelectors.any())
						//[2] 패키지 제한
						.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
								.paths(PathSelectors.any())
					.build();
	}
	
	//앱 정보를 반환하는 메소드(bean이 아님)
	private ApiInfo app() {
		return new ApiInfoBuilder()
						.title("지하철 역 정보 조회 서비스")
						.description("서울시 지하철의 역 정보를 관리하는 시스템")
						.version("0.0.1")
					.build();
	}
	
}






