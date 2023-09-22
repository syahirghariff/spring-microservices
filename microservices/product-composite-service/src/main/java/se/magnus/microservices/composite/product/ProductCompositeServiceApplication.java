package se.magnus.microservices.composite.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Collections;

@SpringBootApplication
@ComponentScan("se.magnus")

// Chapter 5: Need remove
// Chapter 5: Spring Fox to generate Swagger V2 documentation for Restful Services
//@EnableSwagger2WebFlux
public class ProductCompositeServiceApplication {


	@Value("${api.common.version}")
	String apiVersion;
	@Value("${api.common.title}")
	String apiTitle;
	@Value("${api.common.description}")
	String apiDescription;
	@Value("${api.common.termsOfServiceUrl}")
	String apiTermsOfServiceUrl;
	@Value("${api.common.license}")
	String apiLicense;
	@Value("${api.common.licenseUrl}")
	String apiLicenseUrl;
	@Value("${api.common.contact.name}")
	String apiContactName;
	@Value("${api.common.contact.url}")
	String apiContactUrl;
	@Value("${api.common.contact.email}")
	String apiContactEmail;


	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductCompositeServiceApplication.class, args);
	}

	/**
	 * Chapter 5
	 * Spring Bean that returns Spring Fox Docket, to configure Spring Fox
	 * @return Docket
	 */
	@Bean
	public Docket apiDocumentation(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				// apis() paths() Spring Fox to look for API documentations
				.apis(RequestHandlerSelectors.basePackage("se.magnus.microservices.composite.product"))
				.paths(PathSelectors.any())
				.build()
				// Spring Fox not to add any default HTTP response code to the API Documentation, such as 401 or 403 which we dont currently use
				.globalResponseMessage(RequestMethod.GET, Collections.emptyList())
				.apiInfo(new ApiInfo(
						apiTitle,
						apiDescription,
						apiVersion,
						apiTermsOfServiceUrl,
						new Contact(apiContactName, apiContactUrl, apiContactEmail),
						apiLicense,
						apiLicenseUrl,
						Collections.emptyList()
				));
	}
}
