    package uce.edu.ec.ProyectoRelacionesDDBB.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import uce.edu.ec.ProyectoRelacionesDDBB.models.Clase;
    import uce.edu.ec.ProyectoRelacionesDDBB.repository.RepositoryClase;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ServiceClase {

        @Autowired
        private RepositoryClase repClase;

        public Clase saveClase(Clase clase) {
            return repClase.save(clase);
        }

        public Optional<Clase> getClaseById(Long id) {
            return repClase.findById(id);
        }

        public List<Clase> getAllClases() {
            return repClase.findAll();
        }

        public void deleteClase(Long id) {
            repClase.deleteById(id);
        }

        public void updateClase(Long id, Clase actualizar) {
            Optional<Clase> claseExistente = repClase.findById(id);
            if (claseExistente.isPresent()) {
                Clase clase = claseExistente.get();
                clase.setNombre(actualizar.getNombre());
                clase.setInstructor(actualizar.getInstructor());
                clase.setSocios(actualizar.getSocios());
                repClase.save(clase);
            } else {
                throw new RuntimeException("Clase no encontrada!!!!");
            }
        }
    }
