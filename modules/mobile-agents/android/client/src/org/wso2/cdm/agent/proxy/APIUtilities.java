/**
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.cdm.agent.proxy;

import java.util.Map;

import org.json.JSONObject;

public class APIUtilities {
	private String httpMethod;
	private String endPoint;
	private JSONObject requestParams;
	private Map<String, String> requestParamsMap;
	public Map<String, String> getRequestParamsMap() {
		return requestParamsMap;
	}
	public void setRequestParamsMap(Map<String, String> requestParams) {
		this.requestParamsMap = requestParams;
	}
	public JSONObject getRequestParams() {
		return requestParams;
	}
	public void setRequestParams(JSONObject requestParams) {
		this.requestParams = requestParams;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
}
