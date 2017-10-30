/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.sources.spi;

import java.util.List;
import java.util.Map;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.communication.IDecodedDeviceRequest;
import com.sitewhere.spi.device.communication.IInboundEventSource;
import com.sitewhere.spi.server.lifecycle.ITenantLifecycleComponent;

/**
 * Manages the list of event sources for a tenant.
 * 
 * @author Derek
 */
public interface IEventSourcesManager extends ITenantLifecycleComponent {

    /**
     * Get list of inbound event sources.
     * 
     * @return
     */
    public List<IInboundEventSource<?>> getEventSources();

    /**
     * Handle processing for a decoded event from an event source.
     * 
     * @param sourceId
     * @param encoded
     * @param metadata
     * @param decoded
     * @throws SiteWhereException
     */
    public void handleDecodedEvent(String sourceId, byte[] encoded, Map<String, Object> metadata,
	    IDecodedDeviceRequest<?> decoded) throws SiteWhereException;

    /**
     * Handle failed decode from an event source.
     * 
     * @param sourceId
     * @param encoded
     * @param metadata
     * @param t
     * @throws SiteWhereException
     */
    public void handleFailedDecode(String sourceId, byte[] encoded, Map<String, Object> metadata, Throwable t)
	    throws SiteWhereException;
}