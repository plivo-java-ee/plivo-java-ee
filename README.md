plivo-java-ee
=============

<img src="docs/plivo_javaee_im.jpg">

The purpose of this library is <b>simplify</b> the use of <a href="http://www.plivo.com/">Plivo</a> services in java enterprise application servers.
The library is usefull on various aspects:

- to generate Plivo XML (using java server faces)
- to read the Plivo Request Parameters (using java CDI)
- to call or to send messages using @Inject  @Request scoped java beans
- to tracking the calls using special java scope @CallScope (like @SessionScoped)

<b>You should know the difference between java SE and java EE</b>:

- Java SE (formerly J2SE) is the basic Java environment (you only need a JVM to use Java SE).
- <b>Java EE is the enterprise edition of Java</b>. With it, you make websites, large scale applications, using more advanced api and more powerful services integrated in the platform. Besides the JVM, you need an application server Java EE-compatible, like Oracle GlassFish, Red Hat JBoss 6,7.x, Red Hat WildFly 8, IBM WebSphere, Apache Geronimo, Apache Tomee and others.

In your maven project you should have:

```
<dependency>
	<groupId>javax</groupId>
	<artifactId>javaee-api</artifactId>
	<version>${javaee-api.version}</version>
	<scope>provided</scope>
</dependency>

<dependency>
	<groupId>com.plivo</groupId>
	<artifactId>plivo-java</artifactId>
	<version>${plivo-java.version}</version>
	<scope>compile</scope>
</dependency>
```


<h2>Generate <a href="http://plivo.com/docs/xml/">Plivo XML</a> using PLIVO JAVA EE</h2>
<a href="http://htmlpreview.github.io/?https://raw.github.com/plivo-java-ee/plivo-java-ee/master/docs/vdldoc/index.html">If you want know all jsf tags, you should consult the vdldoc page</a>

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

This is simple and also very performant, but if you want change something, <b>you must recompile and redeploy your servlet</b>.


<b>USING PLIVO JAVA EE</b>

You can extend a XmlServlet in this way:

```
/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.demo.speak.servlet;

import javax.servlet.annotation.WebServlet;

import org.plivo.ee.helper.exception.PlivoException;
import org.plivo.ee.helper.xml.elements.Hangup;
import org.plivo.ee.helper.xml.elements.PlivoResponse;
import org.plivo.ee.web.servlet.XmlServlet;

@WebServlet(urlPatterns = { "/AnswerServlet", "/answer" })
public class AnswerServlet extends XmlServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public PlivoResponse getPlivoResponse() throws PlivoException {
		PlivoResponse plivoResponse = new PlivoResponse();
		Hangup hangup = new Hangup();
		hangup.setReason("rejected");
		plivoResponse.append(hangup);
		return plivoResponse;
	}

	@Override
	public boolean isLogParameters() {
		return true;
	}
}

```



You can create a simple page page.xhtml and you can use plivo-java-ee tags.



```

<?xml version="1.0" encoding="UTF-8"?>
<!-- ~ Copyright 2014 plivo-java-ee.org. Licensed under the Eclipse Public License version 1.0, available at http://www.eclipse.org/legal/epl-v10.html -->
<f:view xmlns="http://www.w3c.org/1999/xhtml"
	xmlns:f="http://xmlns.jcp.org/jsf/core"
	xmlns:pj="http://plivo-java-ee.org/plivo-java-ee" transient="true">
	<pj:response>
		<pj:dial callerId="12345678901" 
			action="http://http://plivo-java-ee.org/redirect" 
			method="GET">
			<pj:number>12345678901</pj:number>
		</pj:dial>
	</pj:response>
</f:view>

```

<b>This is more simple, and if you want change something, you mustn't recompile anything.</b>

<h2>@Inject <a href="http://plivo.com/docs/xml/request/">Plivo Request Parameters</a> with java CDI</h2>

In your java cdi beans, you can inject all plivo Request Parameters.
I.E.: 

If you use @RequestScoped cdi bean, you can use:

```

@Inject
@From 
String from;

```

or using some @SessionScoped cdi bean:

```

@Inject
@From Instance<String> from;

...
public void doSomething() {
	 System.out.println("from = " + from.get());
}


```

Below, the complete list of @Injectable Request Parameters:

```

@ALegRequestUUID
@ALegUUID
@BillDuration
@CallStatus
@CallUUID
@ConferenceAction
@ConferenceDigitsMatch
@ConferenceMemberID
@ConferenceName
@ConferenceUUID
@DialAction
@DialALegUUID
@DialBLegBillDuration
@DialBLegDuration
@DialBLegFrom
@DialBLegHangupCause
@DialBLegStatus
@DialBLegTo
@DialBLegUUID
@DialDigitsMatch
@DialHangupCause
@DialRingStatus
@DialStatus
@Digits
@Direction
@Duration
@ForwardedFrom
@From
@HangupCause
@MessageUUID
@RecordingDuration
@RecordingDurationMs
@RecordingEndMs
@RecordingID
@RecordingStartMs
@RecordUrl
@RequestParameters
@Text
@To
@Type
@XPh

```



<h2>Call or Send messages @Injecting CDI java Helper classes </h2>

You can inject a Caller (java helper class to use plivo call services), annotated with your Plivo account:

```

@Inject
@PlivoAccount(accountName = "default")
Caller caller;

```
and after that, you can call using:

```
try {
	String requestUUID = caller.answerUrl(ANSWER_URL)
		.hangupUrl(HANGUP_URL).fallbackUrl(FALLBACK_URL)
		.to(getTo()).call();
	logger.info("requestUUID: " + requestUUID);
} catch (PlivoException e) {
	e.printStackTrace();
}


```
In this case the setting of "from" parameter is done using the number inside the Plivo account.
If you would like to send a message (SMS), in similar way, you can inject a Sender:

```

@Inject
@PlivoAccount(accountName = "default")
Sender sender;
	
```

and after that, you can send a sms in simple way:

```
try {
	String messageUID = sender.url(URL).dst(getDst())
			.text(getMessage()).send();
	setResult(messageUID);
	logger.info("messageUID: " + messageUID);
} catch (PlivoException e) {
	e.printStackTrace();
}


```
In this case the setting of "src" parameter is done using the number inside the Plivo account.


<h2> Special java scope @CallScope (like @SessionScoped)</h2>


If you want to use the same instance of java bean for the during of conversation between Plivo server and your server, you can annotate your class with @CallScoped: it's like the java standard @SessionScoped scope.
The "pseudo session" starts with the receiving of @CallUUID parameter, and is active untill the plivo server call the URL: http://yourserver.com/appName/hangup.jsf.


```
@Named
@CallScoped
public class CallController implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(getClass().getName());
		
	@Inject
	@CallUUID
	private String callUUID;
	
	public CallController() {
	}
	
	.....
}

```


<h2>More informations</h2>

For more informations <a href="http://www.plivo-java-ee.org/">plivo-java-ee.org</a> or send an email to fiorenzino[AT]gmail.com

<a href="http://www.plivo.com/">Plivo is a trademark of Plivo Inc.</a>
