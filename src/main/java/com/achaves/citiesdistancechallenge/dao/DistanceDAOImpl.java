package com.achaves.citiesdistancechallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.achaves.citiesdistancechallenge.dao.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.achaves.citiesdistancechallenge.model.City;

@Component
public class DistanceDAOImpl extends DAO implements IDistanceDAO {


	@Override
	public List<City> listAllCities() throws Exception {
		String sql = "SELECT * FROM city";
		Connection conn = openConnection();
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();

		List<City> cities = new ArrayList<>();

		City city = new City();
		
		while (rs.next()) {
			city = new City();

			city.setId(rs.getInt("id"));
			city.setName(rs.getString("name"));
			city.setLatitude(rs.getDouble("latitude"));
			city.setLongitude(rs.getDouble("longitude"));

			cities.add(city);
		}

		conn.close();
		prepareStatement.close();
		rs.close();

		return cities;
	}

}
