    package uce.edu.ec.ProyectoRelacionesDDBB.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import uce.edu.ec.ProyectoRelacionesDDBB.models.Instructor;
    import uce.edu.ec.ProyectoRelacionesDDBB.repository.RepositoryInstructor;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ServiceInstructor {

        @Autowired
        private RepositoryInstructor repInstructor;

        public Instructor saveInstructor(Instructor instructor) {
            return repInstructor.save(instructor);
        }

        public Optional<Instructor> getInstructorById(Long id) {
            return repInstructor.findById(id);
        }

        public List<Instructor> getAllInstructors() {
            return repInstructor.findAll();
        }

        public void deleteInstructor(Long id) {
            repInstructor.deleteById(id);
        }

        public void updateInstructor(Long id, Instructor actualizar) {
            Optional<Instructor> instructorExistente = repInstructor.findById(id);
            if (instructorExistente.isPresent()) {
                Instructor instructor = instructorExistente.get();
                instructor.setNombre(actualizar.getNombre());
                instructor.setClases(actualizar.getClases());
                repInstructor.save(instructor);
            } else {
                throw new RuntimeException("Instructor no encontrado!!!!");
            }
        }
    }
