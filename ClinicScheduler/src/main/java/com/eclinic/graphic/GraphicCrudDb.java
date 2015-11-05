package com.eclinic.graphic;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eclinic.dao.GraphicDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

@Component("GraphicCrudDb")
public class GraphicCrudDb implements GraphicCrud{

	@Autowired
	private GraphicDAO graphicDao;
	
	public Set<Graphic> findGraphicByDoctor(Doctor doctor) {
		return null;
	}

	public Set<Graphic> findGraphicByDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return graphicDao.findGraphicByDay(calendar);
	}

	public void addGraphic(Graphic graphic) {
		graphicDao.merge(graphic);
		
	}

	public void updateGraphic(Graphic graphic) {
		graphicDao.merge(graphic);
		
	}

}
