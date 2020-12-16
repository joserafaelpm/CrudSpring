package com.example.demo.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entidades.Heroe;
import com.example.demo.modeloDao.IEstado;
import com.example.demo.modeloDao.IGenero;
import com.example.demo.modeloDao.IHeroe;
import com.example.demo.servicios.HeroeServicio;

@Controller
public class ControlHeroe {
	@Autowired
	IHeroe hDAO;
	@Autowired
	IEstado eDAO;
	@Autowired
	IGenero gDAO;
	@Autowired
	HeroeServicio hSer;

	@GetMapping({ "/", "/index" })
//@RequestMapping
	public String List(Model model) {
		model.addAttribute("listaHeroes", hSer.findAll());
		return "index";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer id, Model model) {
		// Optional<Heroe> heroe = hDAO.findById(id);
		hSer.deleteById(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/crear/")
	public String crear(Model model) {
		Heroe heroe = new Heroe();
		model.addAttribute("heroe", heroe);
		model.addAttribute("listaGenero", gDAO.findAll());
		model.addAttribute("listaEstado", eDAO.findAll());
		return "formularioHeroe";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Validated Heroe heroe, Model model) {
		hSer.save(heroe);
		return "redirect:index";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Integer id, Model model) {
		Heroe heroe = hSer.findById(id);
		model.addAttribute("Heroe", heroe);
		return "formularioHeroe";

	}
}
