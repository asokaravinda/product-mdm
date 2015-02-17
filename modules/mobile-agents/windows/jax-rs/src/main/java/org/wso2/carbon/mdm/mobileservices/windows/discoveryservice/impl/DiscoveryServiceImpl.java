/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.carbon.mdm.mobileservices.windows.discoveryservice.impl;

import org.wso2.carbon.mdm.mobileservices.windows.common.Constants;
import org.wso2.carbon.mdm.mobileservices.windows.discoveryservice.beans.DiscoveryRequest;
import org.wso2.carbon.mdm.mobileservices.windows.discoveryservice.DiscoveryService;
import org.wso2.carbon.mdm.mobileservices.windows.discoveryservice.beans.DiscoveryResponse;
import org.apache.log4j.Logger;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Implementation class of Discovery Request.
 */
@WebService(endpointInterface = Constants.DISCOVERY_SERVICE_ENDPOINT, targetNamespace = Constants.DISCOVERY_SERVICE_TARGET_NAMESPACE)
@Addressing(enabled = true, required = true)
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
public class DiscoveryServiceImpl implements DiscoveryService {

	private Logger logger = Logger.getLogger(DiscoveryServiceImpl.class);

	/**
	 * This method returns the OnPremise AuthPolicy and next two endpoint the mobile device should call if
	 * this response to received successfully at the device end. This method is called by device immediately after the
	 * first GET method calling for the same endpoint.
	 * @param disRequest - Request bean comes via mobile phone
	 * @return discoveryResponse - Response bean
	 */
	@Override
	public DiscoveryResponse Discover(DiscoveryRequest disRequest) {

		DiscoveryResponse discoveryResponse = new DiscoveryResponse();
		discoveryResponse.setAuthPolicy(Constants.AUTH_POLICY);

		discoveryResponse.setEnrollmentPolicyServiceUrl(
				Constants.CERTIFICATE_ENROLLMENT_POLICY_SERVICE_URL);
		discoveryResponse.setEnrollmentServiceUrl(
				Constants.CERTIFICATE_ENROLLMENT_SERVICE_URL);

		if (logger.isDebugEnabled()) {
			logger.debug("Discovery service end point was triggered via POST method");
		}

		return discoveryResponse;
	}

	/**
	 * This is the first method called through device. The device checks the availability of the
	 * Service end point by calling this method.
	 * @return HTTP 200OK message
	 */
	@Override
	public Response DiscoverGet() {

		if (logger.isDebugEnabled()) {
			logger.debug("Discovery service end point was triggered via GET method");
		}
		return Response.ok().build();
	}

}