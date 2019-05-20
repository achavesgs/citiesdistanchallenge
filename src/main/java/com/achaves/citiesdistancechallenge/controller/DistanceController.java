package com.achaves.citiesdistancechallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.achaves.citiesdistancechallenge.model.CitiesDistance;
import com.achaves.citiesdistancechallenge.service.IDistanceService;

/**
 * Controller
 * 
 * @author Aline Chaves
 */
@RestController
public class DistanceController {
	
	@Autowired
	private IDistanceService service;

	@RequestMapping(value = "/{unity}/{mediaType}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<CitiesDistance>> list(@PathVariable("unity") String unity, @PathVariable("mediaType") String mediaType) throws Exception {
		return new ResponseEntity<List<CitiesDistance>>(service.combinedCitiesWithDistance(unity) ,HttpStatus.OK);
	}
}
