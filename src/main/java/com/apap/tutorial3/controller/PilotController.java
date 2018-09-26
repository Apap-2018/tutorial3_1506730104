package com.apap.tutorial3.controller;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial3.model.PilotModel;
import com.apap.tutorial3.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/pilot/add")
	public String add(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "licenseNumber", required = true) String licenseNumber,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "flyHour", required = true) Integer flyHour) {
		PilotModel pilot = new PilotModel(id, licenseNumber, name, flyHour);
		pilotService.addPilot(pilot);
		
		return "add";
	}
	
	/**
	@RequestMapping("/pilot/view")
	public String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		
		model.addAttribute("pilot", archive);
		return "view-pilot";
	}
	**/
	
	@RequestMapping("/pilot/viewall")
	public String viewall(Model model) {
		List<PilotModel> archive = pilotService.getPilotList();
		
		model.addAttribute("pilotList", archive);
		return "viewall-pilot";
	}
	
	@RequestMapping(value = {"pilot/view/license-number/{licenseNumber}"})
	public String pathView(@PathVariable Optional<String> licenseNumber, Model model){
		if (licenseNumber.isPresent()) {
			PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber.get());
			model.addAttribute("pilot", archive);
			return "view-pilot";
		} else {
			return "error-view-pilot";
		}
	}
	
	@RequestMapping("/pilot/update/license-number/{licenseNumber}/fly-hour/{flyHour}")
	public String updateFlyHour(@PathVariable Optional<String> licenseNumber, @PathVariable Optional<Integer> flyHour, Model model) {
		if (licenseNumber.isPresent()) {
			PilotModel archive = pilotService.updatePilotFlyHour(licenseNumber.get(), flyHour.get());
			model.addAttribute("pilot", archive);
			return "view-pilot-updated";
		} else {
			return "error-update-flyHour";
		}
	}
	
	@RequestMapping("pilot/delete/id/{id}")
	public String deletePilot(@PathVariable Optional<String> id, Model model) {
		if (id.isPresent()) {
			PilotModel archive = pilotService.deletePilot(id.get());
			model.addAttribute("id", id);
			return "delete-pilot";
		} else {
			return "error-delete-pilot";
		}
	}
}