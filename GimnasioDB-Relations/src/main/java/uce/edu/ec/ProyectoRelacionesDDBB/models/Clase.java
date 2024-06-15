    package uce.edu.ec.ProyectoRelacionesDDBB.models;

    import jakarta.persistence.*;

    import java.util.HashSet;
    import java.util.Set;

    @Entity
    @Table(name="clases")
    public class Clase {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;

        @ManyToOne
        @JoinColumn(name = "instructor_id")
        private Instructor instructor;

        @ManyToMany
        @JoinTable(
                name = "clase_socio",
                joinColumns = @JoinColumn(name = "clase_id"),
                inverseJoinColumns = @JoinColumn(name = "socio_dni")
        )
        private Set<Socio> socios = new HashSet<>();

        public Clase(String nombre, Long id ) {
            this.nombre = nombre;
            this.socios = new HashSet<>();
        }

        public Clase() {
            this.socios = new HashSet<>();
        }

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public Instructor getInstructor() {
            return instructor;
        }
        public void setInstructor(Instructor instructor) {
            this.instructor = instructor;
        }
        public Set<Socio> getSocios() {
            return socios;
        }
        public void setSocios(Set<Socio> socios) {
            this.socios = socios;
        }
    }
