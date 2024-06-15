    package uce.edu.ec.ProyectoRelacionesDDBB.models;

    import jakarta.persistence.*;

    import java.util.HashSet;
    import java.util.Set;

    @Entity
    @Table(name="socios")
    public class Socio {
        @Id
        private String dni;
        private String nombre;
        private String apellidos;

        @OneToOne(mappedBy="socio")
        private Tarjeta tarjeta;

        @ManyToMany(mappedBy = "socios")
        private Set<Clase> clases = new HashSet<>();

        public Socio(String dni, String nombre, String apellidos) {
            super();
            this.dni = dni;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.clases = new HashSet<>();
        }

        public Socio() {
            super();
            this.clases = new HashSet<>();
        }
        public String getDni() {
            return dni;
        }
        public void setDni(String dni) {
            this.dni = dni;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getApellidos() {
            return apellidos;
        }
        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public Tarjeta getTarjeta() {
            return tarjeta;
        }
        public void setTarjeta(Tarjeta tarjeta) {
            this.tarjeta = tarjeta;
        }

        public Set<Clase> getClases() {
            return clases;
        }
        public void setClases(Set<Clase> clases) {
            this.clases = clases;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((dni == null) ? 0 : dni.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Socio other = (Socio) obj;
            if (dni == null) {
                if (other.dni != null)
                    return false;
            } else if (!dni.equals(other.dni))
                return false;
            return true;
        }
    }
