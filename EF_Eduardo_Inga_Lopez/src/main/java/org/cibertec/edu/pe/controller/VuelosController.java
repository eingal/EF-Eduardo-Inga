package org.cibertec.edu.pe.controller;


import java.sql.Date;
import java.time.LocalDate;
import org.cibertec.edu.pe.model.Ciudad;
import org.cibertec.edu.pe.model.Detalleventa;
import org.cibertec.edu.pe.model.Venta;
import org.cibertec.edu.pe.repository.ICiudadRepository;
import org.cibertec.edu.pe.repository.IDetalleVentaRepository;
import org.cibertec.edu.pe.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

		@Controller
		public class VuelosController {

		    @Autowired
		    private IVentaRepository ventaRepository;

		    @Autowired
		    private ICiudadRepository ciudadRepository;

		    @Autowired
		    private IDetalleVentaRepository detalleVentaRepository;

		    @GetMapping("/")
		    public String index(Model model) {
		        model.addAttribute("venta", new Venta());
		        model.addAttribute("ciudades", ciudadRepository.findAll());
		        return "index";
		    }

		    @PostMapping("/agregar")
		    public String agregarVenta(@Valid @ModelAttribute("venta") Venta venta, BindingResult result, Model model) {
		        if (result.hasErrors()) {
		            model.addAttribute("ciudades", ciudadRepository.findAll());
		            return "index";
		        }

		        Ciudad ciudadOrigen = ciudadRepository.findByCodigoPostal(venta.getCiudadOrigen().getCodigoPostal());
		        Ciudad ciudadDestino = ciudadRepository.findByCodigoPostal(venta.getCiudadDestino().getCodigoPostal());
		        if (ciudadOrigen == null || ciudadDestino == null) {
		            result.rejectValue("ciudadOrigen", "error.ciudad", "La ciudad de origen no existe.");
		            result.rejectValue("ciudadDestino", "error.ciudad", "La ciudad de destino no existe.");
		            model.addAttribute("ciudades", ciudadRepository.findAll());
		            return "index";
		        }
		        Detalleventa detalleVenta = new Detalleventa();
		        detalleVenta.setCantidad(venta.getCantidad());
		        detalleVenta.setCiudadDestino(ciudadDestino);
		        detalleVenta.setCiudadOrigen(ciudadOrigen);
		        detalleVenta.setFechaRetorno(venta.getFechaRetorno());
		        detalleVenta.setFechaViaje(venta.getFechaViaje());
		        detalleVenta.setSubTotal(calcularSubTotal(venta.getCantidad(), ciudadOrigen, ciudadDestino, venta.getFechaVenta(), venta.getFechaRetorno()));
		        detalleVenta.setVenta(venta);
		        detalleVenta = detalleVentaRepository.save(detalleVenta);
		        venta.setDetalleVenta(detalleVenta);
		        venta.setMontoTotal(detalleVenta.getSubTotal());
		        venta = ventaRepository.save(venta);
		        model.addAttribute("venta", new Venta());
		        model.addAttribute("ciudades", ciudadRepository.findAll());
		        return "index";
		    }
		    
		    @GetMapping("/limpiar")
		    public String limpiar(Model model) {
		        model.addAttribute("venta", new Venta());
		        return "index";
		    }

		    private Double calcularSubTotal(int cantidad, Ciudad ciudadOrigen, Ciudad ciudadDestino, Date date, Date date2) {
		        // Lógica para calcular el subtotal de la venta
		        return 0.0;
		    }
		    
		    }

		

