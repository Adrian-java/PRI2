package com.eclinic.visit.planner;

import java.util.Comparator;

import com.eclinic.domain.Visit;

public class CustomComparators implements Comparator<Visit> {
    
    public int compare(Visit v1, Visit v2) {
        return v1.getDateOfVisit().compareTo( v2.getDateOfVisit());
    }
}
