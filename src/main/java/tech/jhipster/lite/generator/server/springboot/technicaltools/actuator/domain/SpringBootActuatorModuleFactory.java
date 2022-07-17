package tech.jhipster.lite.generator.server.springboot.technicaltools.actuator.domain;

import static tech.jhipster.lite.module.domain.JHipsterModule.*;

import tech.jhipster.lite.error.domain.Assert;
import tech.jhipster.lite.module.domain.JHipsterModule;
import tech.jhipster.lite.module.domain.javabuild.GroupId;
import tech.jhipster.lite.module.domain.properties.JHipsterModuleProperties;

public class SpringBootActuatorModuleFactory {

  private static final GroupId SPRING_GROUP = groupId("org.springframework.boot");

  public JHipsterModule buildModule(JHipsterModuleProperties properties) {
    Assert.notNull("properties", properties);

    JHipsterModuleBuilder builder = moduleBuilder(properties)
      .context()
      .put("applicationName", properties.projectBaseName().capitalized())
      .and();

    appendDependencies(builder);
    appendSpringProperties(builder);

    return builder.build();
  }

  private void appendDependencies(JHipsterModuleBuilder builder) {
    builder.javaDependencies().addDependency(SPRING_GROUP, artifactId("spring-boot-starter-actuator"));
  }

  private void appendSpringProperties(JHipsterModuleBuilder builder) {
    builder
      .springMainProperties()
      .set(propertyKey("management.endpoints.web.base-path"), propertyValue("/management"))
      .set(
        propertyKey("management.endpoints.web.exposure.include"),
        propertyValue("configprops", "env", "health", "info", "logfile", "loggers", "threaddump")
      )
      .set(propertyKey("management.endpoint.health.probes.enabled"), propertyValue("true"))
      .set(propertyKey("spring.security.oauth2.client.registration.oidc.scope"), propertyValue("openid", "profile", "email"))
      .set(propertyKey("management.endpoint.health.show-details"), propertyValue("always"));
  }
}
