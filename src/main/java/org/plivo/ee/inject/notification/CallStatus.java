/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.inject.notification;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * <p>
 * Call Request Parameter: Indicates the status of the call. The value is set to
 * either ringing, in-progress,or completed. In case the call is hung up, the
 * CallStatus is set to completed for inbound calls and to completed, busy,
 * failed, timeout or no-answer for outbound calls.
 * </p>
 * 
 * @author <a href="mailto:fiorenzo.pizza@gmail.com">Fiorenzo Pizza</a>
 * 
 */
@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, FIELD, PARAMETER })
public @interface CallStatus {

}
