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
 * Conference CallbackUrl Request Parameter: Sent if ConferenceAction is set to
 * record attribute. Duration of recording in seconds. If recordSession or
 * startOnDialAnswer is true, the duration is always -1.
 * 
 * Record Request Parameter: Duration of recording in seconds. If recordSession
 * or startOnDialAnswer is true, duration is always set to -1.
 * 
 * Record CallbackUrl Request Parameter: Duration of recording in seconds. If
 * recordSession or startOnDialAnswer is true, the duration is always -1.
 * </p>
 * 
 * @author <a href="mailto:fiorenzo.pizza@gmail.com">Fiorenzo Pizza</a>
 * 
 */
@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, FIELD, PARAMETER })
public @interface RecordingDuration {

}
