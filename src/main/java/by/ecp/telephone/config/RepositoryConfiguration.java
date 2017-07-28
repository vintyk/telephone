package by.ecp.telephone.config;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"by.ecp.telephone.entity"})
@EnableJpaRepositories(basePackages = {"by.ecp.telephone.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
