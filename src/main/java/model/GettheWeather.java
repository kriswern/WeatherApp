package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GettheWeather {

	private String baseUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
	private String apiKey = "a522f3da602976ff6f5619298ae29c09";

	public void getWeather(weatherBean wBean) throws IOException {

		String URLtoSend = baseUrl + wBean.getCityStr() + "," + "&APPID=" + apiKey
				+ "&mode=xml";

		URL line_api_url = new URL(URLtoSend);

		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		System.out.println(linec);
		
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

			String inputLine;
			String ApiResponse = "";
			
			while ((inputLine = in.readLine()) != null) {
				ApiResponse += inputLine;
			}
			in.close();

			Document doc = convertStringToXMLDocument(ApiResponse);
			doc.getDocumentElement().normalize();

			wBean.setCloudsStr(getStuff(doc, "clouds", "name"));
			wBean.setTemperatureC(getStuff(doc, "temperature", "value"));
			wBean.setWind(getStuff(doc, "direction", "name"));	
			
		}catch(Exception e) {e.printStackTrace();}

		
	}

	private String getStuff(Document doc, String ele, String atr) {

		NodeList nList = doc.getElementsByTagName(ele);
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String weatherValue = eElement.getAttribute(atr);
				return weatherValue;
			}
		}
		return "";
	}


	private static Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}