package org.cibertec.edu.pe.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_comprador", length = 100)
    private String nombreComprador;

    @Column(name = "fecha_venta")
    private Date fechaVenta;

    @Column(name = "monto_total")
    private Double montoTotal;
    

    // Constructores
    public Venta() {
	}
    
    public Venta(Integer id, String nombreComprador, Date fechaVenta, Double montoTotal) {
		this.id = id;
		this.nombreComprador = nombreComprador;
		this.fechaVenta = fechaVenta;
		this.montoTotal = montoTotal;
	}
    
    public Venta(String nombreComprador, Date fechaVenta, Double montoTotal) {
		this.nombreComprador = nombreComprador;
		this.fechaVenta = fechaVenta;
		this.montoTotal = montoTotal;
	}

    // Getters y setters
	public Integer getId() {
		return id;
	}	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Ciudad getCiudadOrigen() {
		// TODO Auto-generated method stub
		return null;
	}

	public Ciudad getCiudadDestino() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCantidad() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getFechaRetorno() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDetalleVenta(Detalleventa detalleVenta) {
		// TODO Auto-generated method stub
		
	}

	public Date getFechaViaje() {
		// TODO Auto-generated method stub
		return null;
	}	
}