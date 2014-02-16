package org.plivo.ee.test.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.plivo.ee.helper.xml.elements.Number;
import org.plivo.ee.helper.exception.PlivoException;
import org.plivo.ee.helper.xml.elements.Dial;
import org.plivo.ee.helper.xml.elements.PlivoResponse;

@WebServlet(description = "A simple Sample", urlPatterns = { "/servletsample" })
public class ServletSample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PlivoResponse plivoResponse = new PlivoResponse();
		Dial dial = new Dial();
		dial.setCallerId("12345678901");
		Number number = new Number("12345678901");

		dial.setAction("http://http://myserverurl/setredirect/");
		dial.setMethod("GET");

		try {
			dial.append(number);
			plivoResponse.append(dial);
			response.setContentType("application/xml");
			response.getWriter().print(plivoResponse.toXML());
		} catch (PlivoException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
