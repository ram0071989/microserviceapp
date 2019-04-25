package org.strawberry.microserviceapp.homeview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.WebApplicationInitializer;
import org.strawberry.microserviceapp.homecore.repository.UserAccountRepository;

@EnableMongoRepositories(basePackageClasses = UserAccountRepository.class)
@ComponentScan( "org.strawberry.microserviceapp.homecore" )
@SpringBootApplication
public class HomeView extends SpringBootServletInitializer implements WebApplicationInitializer {
//public class HomeView extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder ) {
        return applicationBuilder.sources( HomeView.class );
    }

    public static void main( String[] args )
    {
        SpringApplication.run( HomeView.class, args );
    }
}
