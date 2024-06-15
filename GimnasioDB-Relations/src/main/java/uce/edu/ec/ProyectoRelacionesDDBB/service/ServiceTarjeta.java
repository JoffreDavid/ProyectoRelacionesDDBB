    package uce.edu.ec.ProyectoRelacionesDDBB.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import uce.edu.ec.ProyectoRelacionesDDBB.models.Socio;
    import uce.edu.ec.ProyectoRelacionesDDBB.models.Tarjeta;
    import uce.edu.ec.ProyectoRelacionesDDBB.repository.RepositorySocio;
    import uce.edu.ec.ProyectoRelacionesDDBB.repository.RepositoryTarjeta;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ServiceTarjeta {
        @Autowired
        private RepositoryTarjeta repTarjeta;

        @Autowired
        private RepositorySocio repSocio;

        public Tarjeta saveTarjeta(Tarjeta tarjeta, String dniSocio) {
            Socio socio = repSocio.findById(dniSocio).orElseThrow(() -> new RuntimeException("Socio no encontrado"));
            tarjeta.setSocio(socio);
            return repTarjeta.save(tarjeta);
        }

        public Optional<Tarjeta> getTarjetaById(int numero) {
            return repTarjeta.findById(numero);
        }

        public List<Tarjeta> getAllTarjetas() {
            return repTarjeta.findAll();
        }

        public void deleteTarjeta(int numero) {
            repTarjeta.deleteById(numero);
        }

        public void updateTarjeta(int numero, Tarjeta actualizar) {
            Optional<Tarjeta> tarjetaExistente = repTarjeta.findById(numero);
            if (tarjetaExistente.isPresent()) {
                Tarjeta tarjeta = tarjetaExistente.get();
                tarjeta.setCaducidad(actualizar.getCaducidad());
                tarjeta.setSocio(actualizar.getSocio());
                repTarjeta.save(tarjeta);
            } else {
                throw new RuntimeException("Tarjeta no encontrada!!!!");
            }
        }

        public Tarjeta assignSocioToTarjeta(int numero, String dniSocio) {
            Tarjeta tarjeta = repTarjeta.findById(numero).orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
            Socio socio = repSocio.findById(dniSocio).orElseThrow(() -> new RuntimeException("Socio no encontrado"));
            tarjeta.setSocio(socio);
            return repTarjeta.save(tarjeta);
        }
    }
