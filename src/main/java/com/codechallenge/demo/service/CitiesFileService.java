package com.codechallenge.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class CitiesFileService {

	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	public Map<String, String> getCitiesMap() throws IOException {

		Map<String, String> cities = new HashMap<>();

		Resource res = resourceLoader.getResource("classpath:static/cities.txt");

		List<String> lines = Files.readAllLines(Paths.get(res.getURI()), StandardCharsets.UTF_8);
		
		lines.forEach(line -> {
			String[] cityItem = line.split(",");
			if(cityItem !=null && cityItem[0]!=null && cityItem[0].trim().length()>0
					&& cityItem[1]!=null && cityItem[1].trim().length()>0)
			cities.put(cityItem[0].trim(), cityItem[1].trim());
		});

		return cities;
	}

}
