package br.gov.susconnect.exames.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
      .info(new Info()
        .title("SUS Connect API - Exames ")
        .version("1.0.0")
        .description("Documentação da API de Exames do SUS Connect"));
  }
}
