package com.ecps.apidoc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用非swagger-ui jar的方式使用的新配置
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-17 下午 03:53
 */
@Configuration
@EnableSwagger
public class SwaggerApiConfig {

    private SpringSwaggerConfig springSwaggerConfig;



    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation()
    {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .apiVersion("V1.0")
                .includePatterns(".*?");
    }

    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "ECPS管理系统 接口文档管理",
                "如果没有特殊说明，所有接口返回的数据格式为JSON格式，JSON模板为："+"{ \"status\":200/500/... ,\"msg\":\"操作成功/操作失败/...\", \"data\":{数据} }",
                null,
                null,
                null,
                "api");
        return apiInfo;
    }

}
