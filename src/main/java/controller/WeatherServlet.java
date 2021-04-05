package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GettheWeather;
import model.historyBean;
import model.weatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WeatherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GettheWeather w = new GettheWeather();
		HttpSession session = request.getSession();
		String cityStr = request.getParameter("city");
		String ecodedCityStr = URLEncoder.encode(cityStr.toUpperCase(), "UTF-8");
		//session.invalidate(); 

		weatherBean wBean = null;
		
		String cookieValueStr = getCookieValue(request, ecodedCityStr);
		if (cookieValueStr != null) {
			System.out.println("hämtat från cookies");
			wBean = makeBean(cookieValueStr);
		}else {
			wBean = new weatherBean(ecodedCityStr);
			w.getWeather(wBean);
			if(session.getAttribute("cookieConsent") != null && session.getAttribute("cookieConsent").equals("yes")) {
				System.out.println("Skapade ny cookie");
				Cookie cki = new Cookie("c" + ecodedCityStr, wBean.toString());
				cki.setMaxAge(60*30);
				response.addCookie(cki);	
			}
			
		}

		request.setAttribute("wBean", wBean);
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);

	}

	public weatherBean makeBean(String cookieValue) {
		weatherBean wBean = null;
		
		String temp[] = cookieValue.split("@", 4);
		wBean = new weatherBean(temp[0], temp[1], temp[2], temp[3]);

		return wBean;
	}

	public String getCookieValue(HttpServletRequest request, String city) {
		Cookie ck[] = request.getCookies();
		if (ck.length > 0) {
			for (int i = 0; i < ck.length; i++) {
				if (ck[i].getValue().contains(city)) {
					return ck[i].getValue();
				}
			}
		}
		return null;
	}
}
