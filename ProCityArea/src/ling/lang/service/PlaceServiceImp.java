package ling.lang.service;

import java.util.List;

import ling.lang.dao.PlaceDao;
import ling.lang.dao.PlaceDaoImp;
import ling.lang.domain.Place;

public class PlaceServiceImp implements PlaceService {

	@Override
	public List<Place> getProvince() {
		PlaceDao placeDao = new PlaceDaoImp();
		return placeDao.getProvince();
	}
	 
	@Override
	public List<Place> getCity(String proCode) {
		PlaceDao placeDao = new PlaceDaoImp();
		return placeDao.getCity(proCode);
	}

	@Override
	public List<Place> getArea(String cityCode) {
		PlaceDao placeDao = new PlaceDaoImp();
		return placeDao.getArea(cityCode);
	}

}
