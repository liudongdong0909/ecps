package com.ecps.apidoc;

/**
 * swagger接口文档管理属性配置类
 *  直接集成swagger-uijar的方式使用此配置
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-17 下午 03:16
 */
//@EnableSwagger2
public class SwaggerConfig {
/*
    @Bean
    public Docket addUserDocket(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("ECPS管理系统 接口文档管理")
                .description("如果没有特殊说明，所有接口返回的数据格式为JSON格式，JSON模板为："
                        + "{ \"status\":200/500/... ,\"msg\":\"操作成功/操作失败/...\", \"data\":{数据} }")
                .version("1.0")
                .build();
*//*
        *//**//**//**//**//**//**//**//**
         * 匹配api路径 新增一个新接口就在这个地方加入对应的路径正则表达式
         *
         * 例如：^/api[/a-zA-Z]*$*//*

        StringBuffer sb = new StringBuffer();
        sb.append("^/order/[a-zA-Z]+$");
        Predicate<String> pathRegex = PathSelectors.regex(sb.toString());
        //String regex = "^/interim/[a-zA-Z]+.do$|^/newsDataController/[a-zA-Z]+.do$";
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
               *//* .groupName("test")*//*
                .pathMapping("/api")
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(pathRegex)//需要展示的api(使用正则表达式过滤请求路径，显示最新接口)
                .build();
        docket.apiInfo(apiInfo);
        return docket;
    }*/

}
