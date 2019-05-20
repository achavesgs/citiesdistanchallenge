package com.achaves.citiesdistancechallenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achaves.citiesdistancechallenge.dao.IDistanceDAO;
import com.achaves.citiesdistancechallenge.model.CitiesDistance;
import com.achaves.citiesdistancechallenge.model.City;
import com.achaves.citiesdistancechallenge.utils.CitiesDistanceCalculator;
import com.achaves.citiesdistancechallenge.utils.Unities;

@Service
public class DistanceService implements IDistanceService {
	
	@Autowired
	private IDistanceDAO dao;

	/**
	 * Returns the list of cities combined into pairs and the given distance between
	 * the two cities in an predetermined unity (KM or MI)
	 * 
	 * @param informedUnity
	 * 
	 * @return cities
	 */
	@Override
	public List<CitiesDistance> combinedCitiesWithDistance(String informedUnity) throws Exception {
		Unities unity;
		
		try {
			unity = Unities.valueOf(informedUnity.toUpperCase());
		} catch (Exception e) {
			throw new IllegalArgumentException("Unity \"" + informedUnity + "\" not recognized. "
					+ "The accepted unities are \"KM (Kilometers)\" and \"MI (Miles)\"");
		}
		
		List<City> cities = new ArrayList<>();
		
		try {
			cities = dao.listAllCities();
		} catch (Exception e) {
			throw new Exception(/*"Couldn't list the cities. "
					+ "Please, try again later or contact the system administrator."*/e.getMessage()+". "+e.getStackTrace());
		}
		
		List<CitiesDistance> citiesDistances = listPairOfCities(cities, unity);
		
		return citiesDistances;
	}
	
	/**
	 * Algorithm that combines a list of cities into pairs without repetitions,
	 * for instance, combine the cities A, B and C:
	 *   A B
	 *   A C
	 *   B C
	 *   
	 * @param cities
	 * @param unity
	 * 
	 * @return
	 */
	private List<CitiesDistance> listPairOfCities(List<City> cities, Unities unity) {
		List<CitiesDistance> citiesDistances = new ArrayList<>();
		CitiesDistanceCalculator calculator = new CitiesDistanceCalculator(unity);
		
		for (int i = 0; i < cities.size(); i++) {
			for (int j = i + 1; j < cities.size(); j++) {
				City cityA = cities.get(i);
				City cityB = cities.get(j);
				double distance = calculator.calculate(cityA, cityB);
				
				CitiesDistance citiesDistance = new CitiesDistance(cityA, cityB, distance);
				
				citiesDistances.add(citiesDistance);
			}
		}
		
		return citiesDistances;
	}

}
