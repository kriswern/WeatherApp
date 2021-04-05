package model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class weatherBean {

	private String cityStr;
	private String cloudsStr;
	private String temperature;
	private String wind;

	public weatherBean(String cityStr) {
		this.cityStr = cityStr;
	}
	public weatherBean(String city, String cloud, String temp, String wind) {
		this.cityStr = city;
		this.cloudsStr = cloud;
		this.temperature = temp;
		this.wind = wind;
	}

	public String getCityStr() {
		try {
			String decodedCity = URLDecoder.decode(cityStr, "UTF-8");
			return decodedCity;
		}catch(Exception e) {e.printStackTrace();}
		return cityStr;
	}

	public String getCloudsStr() {
		try {
			String decodedCloud = URLDecoder.decode(cloudsStr, "UTF-8");
			return decodedCloud;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public String getTemperature() {
		return temperature;
	}
	public String getWind() {
		return wind;
	}

	public void setCloudsStr(String cloudsStr) throws IOException {
		String ecodedClouds = URLEncoder.encode(cloudsStr, "UTF-8");
		this.cloudsStr = ecodedClouds;
	}
	public void setTemperatureC(String kelvin) {
			double kelv = Double.parseDouble(kelvin);
			double c = kelv-273.15;
			int test = (int)c;
			
			this.temperature = String.valueOf(test);
	}
	public void setWind(String windDir) {
		this.wind = windDir;
	}

	@Override
	public String toString() {
		return cityStr + "@" + cloudsStr + "@" + temperature + "@" + wind;
	}
	
	
		
}