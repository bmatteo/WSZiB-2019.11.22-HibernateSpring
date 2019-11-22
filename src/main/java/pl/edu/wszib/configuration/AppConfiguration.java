package pl.edu.wszib.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"pl.edu.wszib.dao.impl2","pl.edu.wszib.services.impl"})
public class AppConfiguration {
}
