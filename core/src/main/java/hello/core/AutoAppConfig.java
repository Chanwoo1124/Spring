package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //어디 파일부터 찾을지 지정해줄수있음 (지정 안할시 지금 이파일 클래스 위치 기준부터 시작함 ex) hello.core
        basePackages = "hello.core.member",
        //ComponentScan 안되게 뺴는거
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
