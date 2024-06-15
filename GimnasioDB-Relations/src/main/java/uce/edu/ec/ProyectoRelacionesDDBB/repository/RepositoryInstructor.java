    package uce.edu.ec.ProyectoRelacionesDDBB.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import uce.edu.ec.ProyectoRelacionesDDBB.models.Instructor;

    public interface RepositoryInstructor extends JpaRepository<Instructor, Long> {
    }
