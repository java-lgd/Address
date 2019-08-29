package ling.lang.dao;

import java.util.List;
import ling.lang.domain.Place;

public interface PlaceDao {
	List<Place> getProvince();
	 
	List<Place> getCity(String proCode);
	
	List<Place> getArea(String cityCode);

}
