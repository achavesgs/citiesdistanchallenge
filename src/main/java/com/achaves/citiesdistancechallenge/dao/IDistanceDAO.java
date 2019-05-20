package com.achaves.citiesdistancechallenge.dao;

import java.util.List;

import com.achaves.citiesdistancechallenge.model.City;

public interface IDistanceDAO {

	public List<City> listAllCities () throws Exception;
}
