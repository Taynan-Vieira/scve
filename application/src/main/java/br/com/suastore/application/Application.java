package br.com.suastore.application;

import br.com.suastore.application.jsf.ViewScope;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@EntityScan(basePackages = "br.com.suastore")
@SpringBootApplication(scanBasePackages = "br.com.suastore")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	public static CustomScopeConfigurer customScopeConfigurer() {
		Map<String, Object> scopes = new HashMap<>();
		scopes.put("view", new ViewScope());
		CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
		customScopeConfigurer.setScopes(scopes);
		return customScopeConfigurer;
	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
		                                       DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}
}
