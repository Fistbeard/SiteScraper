package com.vogella.build.maven.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Item {
	String name;
	String url;
	Double price;
	Item()
	{
	}
	
	Item(String name, String url, Double price)
	{
		this.name = name;
		this.url = url;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//builds a JSON string and returns it.
	public String toJSONString()
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", url=" + url + ", price=" + price + "]";
	}
	
	
}
