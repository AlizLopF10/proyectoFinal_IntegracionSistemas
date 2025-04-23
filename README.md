#Documentación Técnica del Proyecto: Gestión de Estudiantes y Calificaciones#
Este proyecto es una aplicación web desarrollada con Angular (frontend) y dos servicios backend independientes en Spring Boot (Java): 
- Un servicio para la gestión de estudiantes.
- Otro servicio para la gestión de calificaciones.  

A continuación se detalla todo lo necesario para ejecutar el proyecto correctamente desde cero.


  # Requisitos del sistema #
 - Java 21 o superior: Para ejecutar servicios Spring Boot.
 - Node.js 18+: Requerido para Angular.
 - Angular CLI (npm install -g @angular/cli): Para crear, ejecutar y compilar el frontend.
 - IDE como Visual Studio Code o IntelliJ IDEA: Para desarrollo backend/frontend.
 - Maven 3.8: Para compilar los servicios Java.
 - Postman: Para pruebas.
 
 
  Tecnologías utilizadas
  # Backend (ambos servicios) #
  - Spring Boot 3.4.4
  - Java 21
  - Dependencias: Spring Web, Spring Data JPA
  - Swagger (springdoc-openapi)
  - Maven
 
  Servicio A: Estudiantes
   Framework: Spring Boot
   Puerto: 8080
   Endpoint Base: /students

   Endpoints
    Método          Ruta                          Descripción
    GET          /students               Obtiene todos los estudiantes.
	GET         /students/{matricula}     Obtiene un estudiante por matricula.
    POST       /student                  Crea un estudiante.
    PUT       /students/{matricula}       Actualizar estudiante.
    DELETE   /students/{matricula}        Eliminar estudiante.


  Servicio B: Calificaciones
   Framework: Spring Boot
   Puerto: 8081
   Endpoint Base: /grades

   Endpoints
    Método          Ruta                               Descripción
	GET          /grades                       Obtiene todos los estudiantes.
    GET         /grades/{matricula}            Calificaciones por matrícula
    POST       /grades                         Crear calificación
    PUT       /grades/{matricula}/{materia}    Actualizar calificación
    DELETE   /grades/{matricula}/{materia}     Eliminar calificación


  # Frontend Angular #
   Angular (componentes standalone)
   Angular Material (cards, router, estilos)
 
   Estructura clave
	- app.component.ts: Componente principal que carga los estudiantes y sus calificaciones.
	- student.service.ts: Servicio que consume el backend de estudiantes.
	- grades.service.ts: Servicio que consume el backend de calificaciones.
	- app.routes.ts: Configuración de rutas con Angular standalone.


  # Instalación de dependencias #
  Desde la carpeta uam-frontend, corre:
  - npm install

  Ejecución del servidor Angular
  - ng serve
    Visita http://localhost:4200 en tu navegador.


  # Instalación y configuración del backend #
	1. Abrir y compilar los proyectos
	Con tu IDE (como IntelliJ IDEA o Eclipse):
	 - Importa ambos proyectos (students-service y grades-service) como proyectos Maven.
	 - Asegúrate de que los puertos estén correctamente configurados:
		 * Estudiantes: localhost:8080/students
		* Calificaciones: localhost:8081/grades
	 
	2. Configuración del archivo application.properties
	Para students-service:
	 * server.port=8080
	 * springdoc.api-docs.path=/api-docs
	 * springdoc.swagger-ui.path=/swagger-ui.html
	 
	Para grades-service:
	 * server.port=8081
	 * springdoc.api-docs.path=/api-docs
	 * springdoc.swagger-ui.path=/swagger-ui.html


	3. CORS
	- Agregar en cada controlador principal:
		@CrossOrigin(origins = "http://localhost:4200")
		
	- O una configuración global en una clase WebConfig:
	
		@Configuration
		public class WebConfig implements WebMvcConfigurer {
		  @Override
		  public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("http://localhost:4200");
		  }
		}


	4. Ejecutar servicios
	Desde la terminal o el IDE, ejecutar cada aplicación por separado.


	# Documentación Swagger #
	Cada servicio cuenta con documentación automática de los endpoints accesible desde el navegador:
	
	- Estudiantes: http://localhost:8080/doc/swagger-ui.html
	- Calificaciones: http://localhost:8081/doc/swagger-ui.html


    # Pruebas #
	Usa herramientas como Postman para probar los endpoints de los servicios, antes de integrar con Angular.
	
	Servicio de estudiantes (localhost:8080):
	  - GET /students: Listar estudiantes.
	  - POST /students: Crear estudiante.
	  - PUT /students/{matricula}: Actualizar estudiante.
	  - DELETE /students/{matricula}: Eliminar estudiante.
		
	Servicio de calificaciones (localhost:8081):
	  - GET /grades: Listar todas las calificaciones
	  - GET /grades/{matricula}: Obtener calificaciones por matrícula
	  - POST /grades: Crear calificación
	  - PUT /grades/{matricula}/{materia}: Actualizar calificación
	  - DELETE /grades/{matricula}/{materia}: Eliminar calificación


	# Recomendaciones finales #
	- Asegúrate de que los puertos 8080 y 8081 estén libres antes de iniciar Angular.
	- Si usas puertos diferentes, ajusta las URLs en los servicios student.service.ts y grades.service.ts del frontend.
	- Puedes extender el proyecto agregando autenticación, filtros por nombre o materia, desde el frontend, etc.