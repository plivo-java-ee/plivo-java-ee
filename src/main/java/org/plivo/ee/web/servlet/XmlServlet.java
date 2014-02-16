package org.plivo.ee.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.plivo.ee.helper.exception.PlivoException;
import org.plivo.ee.helper.xml.elements.PlivoResponse;

public abstract class XmlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
	}

	protected void log(HttpServletRequest req) {
		logger.info("loggging http parameters start");
		Enumeration<String> parameterNames = req.getParameterNames();
		StringBuffer buffer;
		while (parameterNames.hasMoreElements()) {
			buffer = new StringBuffer();
			String paramName = parameterNames.nextElement();
			buffer.append(paramName).append(":");
			String[] paramValues = req.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				buffer.append(paramValue).append(";");
			}
			logger.info(buffer.toString());
		}
		logger.info("loggging http parameters stop");
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/html;charset=UTF-8");
		if (isLogParameters()) {
			log(req);
		}
		try (PrintWriter out = res.getWriter()) {
			if (getPlivoResponse() != null) {
				out.print(getPlivoResponse().toXML());
			} else {
				out.print(new PlivoResponse().toXML());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PlivoException e) {
			e.printStackTrace();
		}
	}

	protected abstract PlivoResponse getPlivoResponse() throws PlivoException;

	protected abstract boolean isLogParameters();

}
