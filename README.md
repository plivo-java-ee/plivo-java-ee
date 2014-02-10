plivo-java-ee
=============

plivo for java ee developers

for more informations <a href="http://www.plivo-java-ee.org/">plivo-java-ee.org</a>

1) use java server faces to product Plivo XML

Using PLIVO JAVA HELPER LIBRARY

'
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
'

USING PLIVO_JAVA-EE

'
<?xml version="1.0" encoding="UTF-8"?>
<f:view xmlns="http://www.w3c.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:pj="http://plivo-java-ee.org/plivo-java-ee">
	<pj:response>
		<pj:dial callerId="12345678901" action="http://http://plivo-java-ee.org/redirect" method="GET">
			<pj:number>12345678901</pj:number>
		</pj:dial>
	</pj:response>
</f:view>
'
<img src="docs/plivo_javaee_im.jpg">

<a href="http://www.plivo.com/">Plivo is a trademark of Plivo Inc.</a>
