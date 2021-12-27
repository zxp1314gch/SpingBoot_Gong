package com;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket applicationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 配置是否启用swagger，如果是false，swagger将不能在浏览器中访问
                .enable(true)
                // 指定需要发布到swagger接口目录，不支持通配符
                .select()
                // 通过RequestHandlerSelectors配置其他方式扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.controller"))   // 对所有路径进行监控
                .paths(PathSelectors.any())
                .build()
                // 用来创建该Api的基本信息(这些基本信息会展现在文档页面中)
                .apiInfo(applicationInfo());
    }
    /**
     * Api 接口文档
     * @return
     */
    private ApiInfo applicationInfo() {
        // ApiInfo(大标题,小标题,版本，，作者，链接显示文字，网站链接)
        return new ApiInfoBuilder().title("数据对接")
                .contact(new Contact("","",""))
                .version("1.0")
                .description("数据接口测试")
                .build();
    }

}
