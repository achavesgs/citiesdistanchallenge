package com.achaves.citiesdistancechallenge.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.achaves.citiesdistancechallenge.factory.ConnectionInfo;

/**
 * Data Access Objects
 * 
 * @author Aline Chaves
 */
public abstract class DAO {

	@Autowired
	private ConnectionInfo conn;

	public Connection openConnection() throws Exception {
		return DriverManager.getConnection(
				conn.getUrl(),
				conn.getUsername(),
				conn.getPassword()
		);
	}

}
