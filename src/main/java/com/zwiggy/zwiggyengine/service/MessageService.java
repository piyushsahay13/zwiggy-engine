package com.zwiggy.zwiggyengine.service;

/**
 * The MessageService interface defines methods for sending messages, including simple messages and messages with attachments.
 * Implementations of this interface provide specific functionality for sending messages in various scenarios.
 *
 * @author [piyush]
 */
public interface MessageService {

    /**
     * Sends a simple message.
     *
     * @return A string representing the result or status of the message sending operation.
     */
     Object send(Object messageContent) throws Exception;

}

