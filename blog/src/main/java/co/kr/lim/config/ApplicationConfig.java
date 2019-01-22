package co.kr.lim.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="co.kr.lim")
@EnableTransactionManagement
@EnableJpaRepositories
@ImportResource(value="classpath:application.properties")
public class ApplicationConfig {
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
    @Value("${jdbc.url}")
    private String url;
    
    @Value("${jdbc.username}")
    private String userName;
    
    @Value("${jdbc.password}")
    private String password;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public ModelMapper mapper() {
    	return new ModelMapper();
    }
}
