    package uce.edu.ec.ProyectoRelacionesDDBB.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import uce.edu.ec.ProyectoRelacionesDDBB.models.Socio;
    import uce.edu.ec.ProyectoRelacionesDDBB.repository.RepositorySocio;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ServiceSocio {

    @Autowired
    private RepositorySocio repSocio;

    public Socio saveSocio(Socio socio){
    return repSocio.save(socio);
    }

    public Optional<Socio> getSocioId(String dni){
    return repSocio.findById(dni);
    }

    public List<Socio> getAllSocio(){
        return repSocio.findAll();
    }

    public void deleteSocio(String dni){
    repSocio.deleteById(dni);
    }


    public void updateSocio(String dni,Socio actualizar){
    Optional<Socio> socioExistente=repSocio.findById(dni);
    if(socioExistente.isPresent()){
        Socio socio = socioExistente.get();
        socio.setNombre(actualizar.getNombre());
        socio.setApellidos(actualizar.getApellidos());
        repSocio.save(socio);
    }else {
        throw new RuntimeException("Socio no encontrado!!!!");
    }

    }

    }
