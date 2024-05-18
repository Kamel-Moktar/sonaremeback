package sonaremettakwine.commercial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import sonaremettakwine.commercial.service.customer.CustomerService;
import sonaremettakwine.commercial.service.invoice.InvoiceService;

@SpringBootApplication
public class CommercialApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommercialApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		final CorsConfiguration config = new CorsConfiguration();
		// config.setAllowCredentials("*");

		config.addAllowedOrigin(CorsConfiguration.ALL);
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		//config.addExposedHeader(CorsConfiguration.ALL);
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}



}
