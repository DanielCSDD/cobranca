package com.algaworks.cobranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class CobrancaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CobrancaApplication.class, args);
    }

    // Definindo o Locale da aplicação.
    public LocaleResolver localeResolver() {
        return new FixedLocaleResolver(new Locale("pt", "BR"));
    }

    /* Criação de uma classe intrena, que irá cuidar do redirecionamento á uma página padrão.
     * Onde ao usuário digitar barra (/), após o nome do sistema, por exemplo: localhost:8080.
     * Com essa implementação o sistema irá redirecionar á uma página padrão.
     */
    @Configuration
    public static class MvcConfig implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addRedirectViewController("/", "/titulos");
        }
    }
}
