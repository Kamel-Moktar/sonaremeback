package sonaremettakwine.commercial;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import sonaremettakwine.commercial.dao.decoupage.Decoupage;
import sonaremettakwine.commercial.dao.decoupage.DecoupageRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


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

//    @Bean
//    public CommandLineRunner start(DecoupageRepository decoupageRepository) {
//        return arg -> {
//
//            JSONParser parser = new JSONParser();
//            URL url = getClass().getClassLoader().getResource("wilaya.json");
//            try {
//                Object obj = parser.parse(new FileReader(url.getFile()));
//                JSONArray jsonObject = (JSONArray) obj;
//              jsonObject.forEach(e->{
//
//                  JSONObject w = (JSONObject) e;
//                  Decoupage decoupage = new Decoupage((Long) w.get("id"), (String) w.get("commune_name"), (String) w.get("daira_name"), (String) w.get("wilaya_code"), (String) w.get("wilaya_name"));
//
//                  decoupageRepository.save(decoupage);
//              });
//
//
//
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//        };
//    }

}
