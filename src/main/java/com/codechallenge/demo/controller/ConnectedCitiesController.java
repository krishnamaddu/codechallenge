package com.codechallenge.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.demo.service.ConnectedCitiesService;

@RestController
public class ConnectedCitiesController {
	
	@Autowired
	ConnectedCitiesService connectedCitiesService;
	
	@GetMapping(value = "/connected")
	public String isCitiesConnected(@PathParam("origin") String origin, @PathParam("destination")  String destination)
	{
		String connected = null;
		try {
			connected = connectedCitiesService.isConnectedCities(origin, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connected;
	}
}
