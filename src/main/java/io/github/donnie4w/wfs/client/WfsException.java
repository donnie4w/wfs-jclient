/*
 * Copyright 2023 wfs Author. All Rights Reserved.
 * email: donnie4w@gmail.com
 */
package io.github.donnie4w.wfs.client;

public class WfsException extends Exception{
    private static final long serialVersionUID = 1L;

    public WfsException() {
        super();
    }

    public WfsException(String message) {
        super(message);
    }

    public WfsException(Throwable cause) {
        super(cause);
    }

    public WfsException(String message, Throwable cause) {
        super(message, cause);
    }
}
