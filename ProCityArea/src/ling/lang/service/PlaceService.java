package ling.lang.service;

import java.util.List;

import ling.lang.domain.Place;

public interface PlaceService {
	List<Place> getProvince();
	 
	List<Place> getCity(String proCode);
	
	List<Place> getArea(String cityCode);
}
