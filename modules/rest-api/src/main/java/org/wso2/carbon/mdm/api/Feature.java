/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.mdm.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.device.mgt.common.*;
import org.wso2.carbon.device.mgt.core.service.DeviceManagementService;
import org.wso2.carbon.mdm.api.common.MDMAPIException;
import org.wso2.carbon.mdm.api.util.MDMAPIConstants;
import org.wso2.carbon.mdm.api.util.MDMAPIUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Features
 */
@Produces({ "application/json", "application/xml" })
@Consumes({ "application/json", "application/xml" })
public class Feature {
	private static Log log = LogFactory.getLog(Feature.class);
	/**
	 * Get all features for Mobile Device Type
	 *
	 * @return Feature
	 * @throws org.wso2.carbon.mdm.api.common.MDMAPIException
	 */
	@GET
	public List<org.wso2.carbon.device.mgt.common.Feature> getFeatures()
			throws MDMAPIException {
		List<org.wso2.carbon.device.mgt.common.Feature> features;
		DeviceManagementService dmService;
		OperationManager operationManager;
		try {
			dmService = MDMAPIUtils.getDeviceManagementService();
			operationManager = dmService.getOperationManager(MDMAPIConstants.MOBILE_DEVICE_TYPE);
			features = operationManager.getFeaturesForDeviceType(MDMAPIConstants.MOBILE_DEVICE_TYPE);
		} catch (DeviceManagementServiceException deviceServiceMgtEx) {
			String errorMsg = "Device management service error.";
			log.error(errorMsg, deviceServiceMgtEx);
			throw new MDMAPIException(errorMsg, deviceServiceMgtEx);
		} catch (DeviceManagementException deviceMgtEx) {
			String errorMsg = "Error occurred while fetching the operation manager.";
			log.error(errorMsg, deviceMgtEx);
			throw new MDMAPIException(errorMsg, deviceMgtEx);
		} catch (FeatureManagementException ex) {
			String errorMsg = "Error occurred while fetching the features for the device type.";
			log.error(errorMsg, ex);
			throw new MDMAPIException(errorMsg, ex);
		}
		return features;
	}

}
