/*
 * Copyright 2023 wfs Author. All Rights Reserved.
 * email: donnie4w@gmail.com
 */
package io.github.donnie4w.wfs.client;

public class WfsRunTimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public WfsRunTimeException() {
        super();
    }

    public WfsRunTimeException(String message) {
        super(message);
    }

    public WfsRunTimeException(Throwable cause) {
        super(cause);
    }

    public WfsRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
