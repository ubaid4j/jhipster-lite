package tech.jhipster.lite.error.infrastructure.primary;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
class ErrorsConfiguration {

  @Bean("assertionErrorMessageSource")
  MessageSource assertionErrorMessageSource() {
    ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

    source.setBasename("classpath:/messages/assertions-errors/messages");
    source.setDefaultEncoding("UTF-8");

    return source;
  }
}