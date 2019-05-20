package com.achaves.citiesdistancechallenge.utils;

import com.achaves.citiesdistancechallenge.model.City;

/**
 * Calculates the distance between to cities
 * 
 * @author Aline Chaves
 */
public class CitiesDistanceCalculator {

	private Unities unity;

	public CitiesDistanceCalculator(Unities unity) {
		this.unity = unity;
	}

	/**
	 * Calculates the distance between to given cities (cityA, cityB) in a given
	 * unity (KM or MI)
	 * 
	 * @param cityA
	 * @param cityB
	 * 
	 * @return
	 */
	public double calculate(City cityA, City cityB) {
		// Converts the latitudes from degrees into radians
		double latitudeAInRad = Math.toRadians(cityA.getLatitude());
		double latitudeBInRad = Math.toRadians(cityB.getLatitude());

		// Variation of longitudes
		double deltaLongitude = cityB.getLongitude() - cityA.getLongitude();
		double deltaLongitudeInRad = Math.toRadians(deltaLongitude);

		// Calculates the sine and cosine
		double sinLatitudeA = Math.sin(latitudeAInRad);
		double cosLatitudeA = Math.cos(latitudeAInRad);
		double sinLatitudeB = Math.sin(latitudeBInRad);
		double cosLatitudeB = Math.cos(latitudeBInRad);
		double cosDeltaLongitude = Math.cos(deltaLongitudeInRad);

		// Gets the Earth radius
		EarthRadius radius = EarthRadius.valueOf(unity.name());

		// Calculates the distance between the coordinates
		return Math.acos(cosLatitudeA * cosLatitudeB * cosDeltaLongitude + sinLatitudeA * sinLatitudeB)
				* radius.getRadius();
	}
}
