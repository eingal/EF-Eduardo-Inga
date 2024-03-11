package org.cibertec.edu.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "tb_ciudad")
	public class Ciudad {
	    @Id
	    @Column(name = "codigo_postal", length = 50)
	    private String codigoPostal;

	    @Column(name = "nombre", length = 100)
	    private String nombre;

	    // Constructores
		public Ciudad() {

		}
		
		public Ciudad(String codigoPostal, String nombre) {
			this.codigoPostal = codigoPostal;
			this.nombre = nombre;
		}
		
	    // Getters y setters
		public String getCodigoPostal() {
			return codigoPostal;
		}

		public void setCodigoPostal(String codigoPostal) {
			this.codigoPostal = codigoPostal;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}    
}