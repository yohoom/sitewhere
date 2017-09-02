package com.sitewhere.server.schedule;

import java.util.HashMap;
import java.util.Map;

import org.quartz.JobExecutionException;

import com.sitewhere.rest.model.device.request.BatchCommandForCriteriaRequest;
import com.sitewhere.spi.scheduling.JobConstants;

public class BatchCommandInvocationJobParser {

    /**
     * Parse configuration data.
     * 
     * @param data
     * @throws JobExecutionException
     */
    public static BatchCommandForCriteriaRequest parse(Map<String, String> data) throws JobExecutionException {

	String specificationToken = null;
	String siteToken = null;
	String groupToken = null;
	String groupRole = null;
	String commandToken = null;
	Map<String, String> parameters = new HashMap<String, String>();

	for (String key : data.keySet()) {
	    String value = data.get(key);
	    if (JobConstants.BatchCommandInvocation.SPECIFICATION_TOKEN.equals(key)) {
		specificationToken = value;
	    } else if (JobConstants.BatchCommandInvocation.SITE_TOKEN.equals(key)) {
		siteToken = value;
	    } else if (JobConstants.BatchCommandInvocation.GROUP_TOKEN.equals(key)) {
		groupToken = value;
	    } else if (JobConstants.BatchCommandInvocation.GROUP_ROLE.equals(key)) {
		groupRole = value;
	    } else if (JobConstants.CommandInvocation.COMMAND_TOKEN.equals(key)) {
		commandToken = value;
	    } else if (key.startsWith(JobConstants.CommandInvocation.PARAMETER_PREFIX)) {
		String paramKey = key.substring(JobConstants.CommandInvocation.PARAMETER_PREFIX.length());
		parameters.put(paramKey, value);
	    }
	}

	BatchCommandForCriteriaRequest request = new BatchCommandForCriteriaRequest();
	request.setCommandToken(commandToken);
	request.setParameterValues(parameters);
	request.setSpecificationToken(specificationToken);
	request.setSiteToken(siteToken);
	request.setGroupToken(groupToken);
	request.setGroupsWithRole(groupRole);
	return request;
    }
}
