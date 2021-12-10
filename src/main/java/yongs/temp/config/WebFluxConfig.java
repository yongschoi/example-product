package yongs.temp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
          .allowedOrigins("*")
          // .allowCredentials(true)
          .allowedHeaders("*")
          .allowedMethods(
					HttpMethod.GET.name(),
			        HttpMethod.HEAD.name(),
			        HttpMethod.POST.name(),
			        HttpMethod.PUT.name(),
			        HttpMethod.DELETE.name());
    }
}
