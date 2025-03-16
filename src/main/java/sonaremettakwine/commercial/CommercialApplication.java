package sonaremettakwine.commercial;


import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import sonaremettakwine.commercial.dao.decoupage.Decoupage;
import sonaremettakwine.commercial.dao.decoupage.DecoupageRepository;
import sonaremettakwine.commercial.security.Role;
import sonaremettakwine.commercial.security.RoleService;
import sonaremettakwine.commercial.security.UserInfo;
import sonaremettakwine.commercial.security.UserInfoService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


@SpringBootApplication
public class CommercialApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommercialApplication.class, args);
    }



    @Bean
    ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }


    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("kamelardz@gmail.com");
        mailSender.setPassword("ewfgnoppzkfetpof");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
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
    public CommandLineRunner start(UserInfoService userInfoService, RoleService roleService) {
        return arg -> {
//       List<Role> roles=new LinkedList<Role>();
//            roles.add(roleService.getRoleById(8L));
//            userInfoService.addUser(new UserInfo(null,"Administrateur","kamelardz@yahoo.fr","123","Oui",roles));
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
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

        };
    }

}
