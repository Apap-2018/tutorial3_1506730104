package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.PilotModel;
import com.apap.tutorial3.service.PilotService;

import org.springframework.stereotype.Service;

@Service
public class PilotInMemoryService implements PilotService{
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}

	@Override
	public void addPilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		archivePilot.add(pilot);
	}

	@Override
	public List<PilotModel> getPilotList() {
		// TODO Auto-generated method stub
		return archivePilot;
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		for(int i = 0; i < archivePilot.size(); i++) {
			if(archivePilot.get(i).getLicenseNumber().equals(licenseNumber)) {
				return archivePilot.get(i);
			}
		}
		return null;
	}

	@Override
	public PilotModel updatePilotFlyHour(String licenseNumber, int new_flyHour) {
		// TODO Auto-generated method stub
		for(int i = 0; i < archivePilot.size(); i++) {
			if(archivePilot.get(i).getLicenseNumber().equals(licenseNumber)) {
				archivePilot.get(i).setFlyHour(new_flyHour);
				return archivePilot.get(i);
			}
		}
		return null;
	}

	@Override
	public PilotModel deletePilot(String id) {
		// TODO Auto-generated method stub
		for(int i = 0; i < archivePilot.size(); i++) {
			if(archivePilot.get(i).getId().equals(id)) {
				archivePilot.remove(i);
				PilotModel dummy = new PilotModel("dummy", "dummy", "dummy", 0);
				return dummy;
			}
		}
		return null;
	}
}
