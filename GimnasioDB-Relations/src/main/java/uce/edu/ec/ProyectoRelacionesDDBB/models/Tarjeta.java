    package uce.edu.ec.ProyectoRelacionesDDBB.models;

    import jakarta.persistence.*;

    @Entity
    @Table(name="tarjetas")
    public class Tarjeta {
        @Id
        private int numero;
        private String caducidad;

        @OneToOne
        @JoinColumn(name="socios_dni")
        private Socio socio;

        public int getNumero() {
            return numero;
        }
        public void setNumero(int numero) {
            this.numero = numero;
        }
        public String getCaducidad() {
            return caducidad;
        }
        public void setCaducidad(String caducidad) {
            this.caducidad = caducidad;
        }
        public Tarjeta(int numero, String caducidad) {
            super();
            this.numero = numero;
            this.caducidad = caducidad;
        }

        public Socio getSocio() {
            return socio;
        }
        public void setSocio(Socio socio) {
            this.socio = socio;
        }
        public Tarjeta() {
            super();
        }
        public Tarjeta(int numero) {
            super();
            this.numero = numero;
        }
    }
