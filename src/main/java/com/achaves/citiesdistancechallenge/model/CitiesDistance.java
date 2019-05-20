package com.achaves.citiesdistancechallenge.model;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Represents the distance between two cities
 * 
 * @author Aline Chaves
 */
@XmlRootElement(name="citiesdistance")
@XmlSeeAlso(City.class)
public class CitiesDistance {

	private City cityA;

	private City cityB;

	private double distance;

	public CitiesDistance() {}

	public CitiesDistance(City cityA, City cityB, double distance) {
		this.cityA = cityA;
		this.cityB = cityB;
		this.distance = distance;
	}

	@XmlAttribute(name="cityA")
	public City getCityA() {
		return cityA;
	}

	public void setCityA(City cityA) {
		this.cityA = cityA;
	}

	@XmlAttribute(name="cityB")
	public City getCityB() {
		return cityB;
	}

	public void setCityB(City cityB) {
		this.cityB = cityB;
	}

	@XmlAttribute(name="distance")
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}