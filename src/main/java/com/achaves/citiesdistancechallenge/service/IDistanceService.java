package com.achaves.citiesdistancechallenge.service;

import java.util.List;

import com.achaves.citiesdistancechallenge.model.CitiesDistance;

public interface IDistanceService {
	
	public List<CitiesDistance> combinedCitiesWithDistance(String informedUnity) throws Exception;

}
