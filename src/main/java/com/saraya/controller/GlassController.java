package com.saraya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saraya.model.Glass;
import com.saraya.service.GlassService;


@Controller
public class GlassController {

	@Autowired
	GlassService gs;
	//@Autowired
	//UserValidation uv;
	@RequestMapping(value="/list-glass", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("glasses", gs.getAllGlasses());
		return "glassList";
	}
	
	//------------------ADDING METHOD----------------------------
	
	@RequestMapping(value="/add-glass", method=RequestMethod.GET)
			public String addCarForm(ModelMap model) {
		model.addAttribute("gla", new Glass());
		return "addGlass";
	}
	
	@RequestMapping(value="/add-glass", method=RequestMethod.POST)
	public String glassAdded(ModelMap model, @Valid @ModelAttribute("gla") Glass g, BindingResult result) {
		if(result.hasErrors()) {
			return "addGlass";
		}
		gs.addGlass(g.getYear(), g.getMake(), g.getModel(), g.getImage());
		model.clear();
		return "redirect:/list-glass";
	}
	
	//----------------------------------------------------------------
	
	
	
	//--------------UPDATE METHOD-----------------------------
	
	@RequestMapping(value="/update-glass", method=RequestMethod.GET)
	public String updateGlassForm(ModelMap model, @RequestParam int id) {
		model.addAttribute("gla", gs.findById(id));
		return "addGlass";
	}
	//-------------------------------------------------
	@RequestMapping(value="/update-glass", method=RequestMethod.POST)
	public String glassListUpdate(ModelMap model, @Valid @ModelAttribute("gla") Glass g,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "addGlass";
		}
		
		gs.updateByGlass(g);
		model.clear();
		return "redirect:/list-glass";
	}
	//-----------------------------------------------------
	
	@RequestMapping(value="/delete-glass", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id ) {
		gs.deleteGlass(id);
		model.clear();
		return "redirect:/list-glass";
		
	}
}