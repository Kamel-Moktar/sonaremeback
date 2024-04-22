package sonaremettakwine.commercial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.customer.CustomerRepository;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoice.InvoiceRepository;
import sonaremettakwine.commercial.service.customer.CustomerService;
import sonaremettakwine.commercial.service.invoice.InvoiceService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

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

	@Bean
	public CommandLineRunner start(
			CustomerService customerService,
			InvoiceService invoiceService

	) {

		return arg -> {
//			customerRepository.save(new Customer(null,"SONATRACH","SH","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"NAFTAL  GPL","NGPL","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"NAFTAL COM","NCOM","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"NAFTAL CARBU","NCAR","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"SONELGAZ DISTRIBUTION","SNG-DIST","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"SONELGAZ TRANSPORT GAZ","STG","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"STH","STH","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"SOMIPHOS","SOMIPHOF","4455221144","55447788","445588777","4477888"));
//			customerRepository.save(new Customer(null,"dddd","SH","4455221144","55447788","445588777","4477888"));


//
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
//
//
//			Customer customer1=customerService.getCustomerById(403L);
//			Customer customer2=customerService.getCustomerById(402L);
//
//			Invoice newInvoice1=new Invoice();
//			newInvoice1.setCustomer(customer1);
//			newInvoice1.setReference("Convention cadre nu 22541");
//			newInvoice1.setObject("Autoca Niv 2 du 01/01/2024 au 30/04/2024");
//			Date date = formatter.parse("01/02/2024");
//			newInvoice1.setDate(date);
//			newInvoice1.setNumber("2024001");
//			invoiceService.add(newInvoice1);
//
//
//			Invoice newInvoice2=new Invoice();
//			newInvoice2.setCustomer(customer2);
//			newInvoice2.setReference("BCN 2222");
//			newInvoice2.setObject("Excel avanancé Niv 2 du 01/01/2024 au 30/04/2024");
//			Date date2 = formatter.parse("05/01/2024");
//			newInvoice2.setDate(date2);
//			newInvoice2.setNumber("2024002");
//			invoiceService.add(newInvoice2);

		};

	}



}
