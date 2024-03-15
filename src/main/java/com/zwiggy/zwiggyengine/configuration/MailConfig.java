package com.zwiggy.zwiggyengine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

@Configuration
public class MailConfig {
    @Primary
    @Bean
    public FreeMarkerConfigurationFactory factoryBean() {
        FreeMarkerConfigurationFactory fbean = new FreeMarkerConfigurationFactory();
        fbean.setTemplateLoaderPath("src/main/resources/templates");
        return fbean;
    }
}
