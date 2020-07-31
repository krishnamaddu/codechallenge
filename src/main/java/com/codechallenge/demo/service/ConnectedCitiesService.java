package com.codechallenge.demo.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectedCitiesService {
	
	@Autowired
	CitiesFileService citiesFileService;

	public String isConnectedCities(String origin, String destination) throws IOException, Exception
	{
		Map<String,String> citiesMap = citiesFileService.getCitiesMap();
		String connected = "no";
		if(citiesMap!=null && citiesMap.size()>0)
			if(citiesMap.containsKey(origin) && citiesMap.get(origin).equals(destination)) 
				return "yes";
		return connected;
	}

}
