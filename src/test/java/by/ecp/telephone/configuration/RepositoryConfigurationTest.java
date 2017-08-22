package by.ecp.telephone.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"by.ecp.telephone"})
@EnableJpaRepositories(basePackages = {"by.ecp.telephone.repository"})
@EnableTransactionManagement
@ComponentScan(basePackages = {"by.ecp.telephone.service"})
public class RepositoryConfigurationTest {
}
