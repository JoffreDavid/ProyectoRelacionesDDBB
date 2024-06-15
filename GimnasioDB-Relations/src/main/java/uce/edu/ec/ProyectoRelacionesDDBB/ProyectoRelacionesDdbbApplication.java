	package uce.edu.ec.ProyectoRelacionesDDBB;
/*
*
* author: Arias David
* tema: Relations en Spring
 */
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import uce.edu.ec.ProyectoRelacionesDDBB.models.Clase;
	import uce.edu.ec.ProyectoRelacionesDDBB.models.Instructor;
	import uce.edu.ec.ProyectoRelacionesDDBB.models.Socio;
	import uce.edu.ec.ProyectoRelacionesDDBB.models.Tarjeta;
	import uce.edu.ec.ProyectoRelacionesDDBB.service.ServiceClase;
	import uce.edu.ec.ProyectoRelacionesDDBB.service.ServiceInstructor;
	import uce.edu.ec.ProyectoRelacionesDDBB.service.ServiceSocio;
	import uce.edu.ec.ProyectoRelacionesDDBB.service.ServiceTarjeta;


	@SpringBootApplication
	public class ProyectoRelacionesDdbbApplication implements CommandLineRunner {

		@Autowired
		ServiceSocio serviceSocio;
		@Autowired
		ServiceTarjeta serviceTajeta;
		@Autowired
		ServiceInstructor serviceInstructor;
		@Autowired
		ServiceClase serviceClase;

		public static void main(String[] args) {

			SpringApplication.run(ProyectoRelacionesDdbbApplication.class, args);

		}

		@Override
		public void run(String... args) throws Exception {


			// Crear y guardar Socio
			Socio socio = new Socio("2", "Juan", "Perez");
			serviceSocio.saveSocio(socio);

			// Crear y guardar Tarjeta, asignando al Socio creado
			Tarjeta tarjeta = new Tarjeta(1, "24-06-2026");
			serviceTajeta.saveTarjeta(tarjeta,"2");

			// Crear y guardar Instructor
			Instructor instructor = new Instructor("Pedro", 23L);
			serviceInstructor.saveInstructor(instructor);

			// Crear y guardar Clase, asignando al Instructor creado
			Clase clase = new Clase("Natacion", 1L);
			clase.setInstructor(instructor);
			serviceClase.saveClase(clase);

			// Asignar Socio a la Tarjeta (aunque ya se hizo en saveTarjeta, por si acaso)
			serviceTajeta.assignSocioToTarjeta(1,"2");

			// Asignar Clase al Socio
			socio.getClases().add(clase);
			serviceSocio.saveSocio(socio);

			// Actualizar Clase con el Socio asignado
			clase.getSocios().add(socio);
			serviceClase.saveClase(clase);

		}
	}
