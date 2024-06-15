    package uce.edu.ec.ProyectoRelacionesDDBB.models;

    import jakarta.persistence.*;
    import java.util.Set;

    @Entity
    @Table(name="instructores")
    public class Instructor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;

        @OneToMany(mappedBy = "instructor")
        private Set<Clase> clases;
        public Instructor(String nombre, Long class_id) {
            this.nombre = nombre;
            this.clases = clases;
        }
        public Instructor() {
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
        public Set<Clase> getClases() {
            return clases;
        }
        public void setClases(Set<Clase> clases) {
            this.clases = clases;
        }
    }
