package org.inariforge.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc OpenAPI 設定.
 */
@Configuration
public class OpenApiConfig {

    /**
     * 自訂 OpenAPI 資訊.
     *
     * @return OpenAPI
     */
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("BasicArchitecture API")
                        .version("0.0.1-SNAPSHOT")
                        .description("模組化全端應用程式 REST API 文件")
                        .contact(new Contact()
                                .name("InariForge")
                                .url("https://github.com/inariforge"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
