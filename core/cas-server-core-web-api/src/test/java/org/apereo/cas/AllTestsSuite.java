package org.apereo.cas;

import org.apereo.cas.web.support.filters.AddResponseHeadersFilterTests;
import org.apereo.cas.web.support.filters.RequestParameterPolicyEnforcementFilterTests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This is {@link AllTestsSuite}.
 *
 * @author Misagh Moayyed
 * @since 6.0.0-RC3
 */
@SelectClasses({
    RequestParameterPolicyEnforcementFilterTests.class,
    AddResponseHeadersFilterTests.class
})
@RunWith(JUnitPlatform.class)
public class AllTestsSuite {
}
