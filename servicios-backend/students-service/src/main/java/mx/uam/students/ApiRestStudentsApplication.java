package mx.uam.students;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRestStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestStudentsApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Servicio A: Registro de Estudiantes")
						.description("Documentación del Servicio: Aquí se registran, se eliminan, se actualizan y se muestra una lista de estudiantes"));
	}
}