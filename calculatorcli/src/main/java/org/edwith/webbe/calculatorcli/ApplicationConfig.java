package org.edwith.webbe.calculatorcli;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//스프링 설정 파일이라는 것을 의미
//  특정 패키지 이하에서 컴포넌트를 찾도록 합니다.
// @Component, @Repository, @Service,
//@Controller, @RestController 등의 어노테이션이 붙은 클래스를 찾아 빈으로 등록
@ComponentScan(basePackages = {"org.edwith.webbe.calculatorcli"})
public class ApplicationConfig {
}