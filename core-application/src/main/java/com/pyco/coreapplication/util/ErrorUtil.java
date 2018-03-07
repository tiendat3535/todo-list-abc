package com.pyco.coreapplication.util;

import org.slf4j.Logger;

import java.util.UUID;

public class ErrorUtil {

    private  static final String ERROR_MESSAGE_LOG = "ErrorId: %s, ErrorMessage: %s";

    private ErrorUtil() {}

    public static UUID logError(Logger logger, Exception e) {
        UUID errorId = UUID.randomUUID();
        logger.error(String.format(ERROR_MESSAGE_LOG, e.getMessage()), e);
        return errorId;
    }

}
