plivo-java-ee
=============

The purpose of this library is <b>simplify</b> the use of Plivo services in java enterprise application servers like GlassFish, JBoss...

For more informations <a href="http://www.plivo-java-ee.org/">plivo-java-ee.org</a>
<img src="docs/plivo_javaee_im.jpg">

<h2>Generate Plivo XML using JavaServer Faces</h2>

<b>Using PLIVO JAVA HELPER LIBRARY</b>
You can generate xml code using the official library and you can publish the output generated using java Servlet.

```

@WebServlet(description = "A simple Sample", urlPatterns = { "/servletsample" })
public class ServletSample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PlivoResponse plivoResponse = new PlivoResponse();
		Dial dial = new Dial();
		dial.setCallerId("12345678901");
		Number number = new Number("12345678901");

		dial.setAction("http://http://plivo-java-ee.org/redirect");
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

```

<b>USING PLIVO JAVA EE</b>
You can create a simple page page.xhtml and you can use plivo-java-ee tags.

```

<?xml version="1.0" encoding="UTF-8"?>
<f:view xmlns="http://www.w3c.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:pj="http://plivo-java-ee.org/plivo-java-ee">
	<pj:response>
		<pj:dial callerId="12345678901" 
			action="http://http://plivo-java-ee.org/redirect" 
			method="GET">
			<pj:number>12345678901</pj:number>
		</pj:dial>
	</pj:response>
</f:view>

```

<a href="http://www.plivo.com/">Plivo is a trademark of Plivo Inc.</a>
