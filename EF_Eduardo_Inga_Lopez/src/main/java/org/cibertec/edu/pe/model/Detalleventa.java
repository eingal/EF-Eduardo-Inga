package org.cibertec.edu.pe.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_detalle_venta")

public class Detalleventa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_postal_destino", length = 50)
    private String codigoPostalDestino;

    @Column(name = "codigo_postal_origen", length = 50)
    private String codigoPostalOrigen;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "codigo_postal_origen", referencedColumnName = "codigo_postal", insertable = false, updatable = false)
    private Ciudad ciudadOrigen;

    @ManyToOne
    @JoinColumn(name = "codigo_postal_destino", referencedColumnName = "codigo_postal", insertable = false, updatable = false)
    private Ciudad ciudadDestino;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha_viaje")
    private Date fechaViaje;

    @Column(name = "fecha_retorno")
    private Date fechaRetorno;

    @Column(name = "sub_total")
    private Double subTotal;
    
    // Constructores
    public Detalleventa() {
    	
	}
    
    public Detalleventa(String codigoPostalDestino, String codigoPostalOrigen, Venta venta,
			Integer cantidad, Date fechaViaje, Date fechaRetorno, Double subTotal) {
		this.codigoPostalDestino = codigoPostalDestino;
		this.codigoPostalOrigen = codigoPostalOrigen;
		this.venta = venta;
		this.cantidad = cantidad;
		this.fechaViaje = fechaViaje;
		this.fechaRetorno = fechaRetorno;
		this.subTotal = subTotal;
	}
    
	public Detalleventa(Integer id, String codigoPostalDestino, String codigoPostalOrigen, Venta venta,
			Integer cantidad, Date fechaViaje, Date fechaRetorno, Double subTotal) {
		this.id = id;
		this.codigoPostalDestino = codigoPostalDestino;
		this.codigoPostalOrigen = codigoPostalOrigen;
		this.venta = venta;
		this.cantidad = cantidad;
		this.fechaViaje = fechaViaje;
		this.fechaRetorno = fechaRetorno;
		this.subTotal = subTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoPostalDestino() {
		return codigoPostalDestino;
	}

	public void setCodigoPostalDestino(String codigoPostalDestino) {
		this.codigoPostalDestino = codigoPostalDestino;
	}

	public String getCodigoPostalOrigen() {
		return codigoPostalOrigen;
	}

	public void setCodigoPostalOrigen(String codigoPostalOrigen) {
		this.codigoPostalOrigen = codigoPostalOrigen;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaViaje() {
		return fechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

	public Date getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

    // Getters y setters
	
}