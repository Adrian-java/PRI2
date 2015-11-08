package com.eclinic.graphic;

import java.util.Date;
import java.util.Set;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

public interface GraphicCrud {

	public Set<Graphic> findGraphicByDoctor(Doctor doctor);
	
	public Set<Graphic> findGraphicByDate(Date date);
	
	public void addGraphic(Graphic graphic);
	
	public void updateGraphic(Graphic graphic);
}
