/**
 * Project Name:wfs-jclient
 * File Name:WfsException.java
 * Package Name:com.wfs
 * Date:2017��4��14������1:30:45
 * Copyright (c) 2017, donnie4w@gmail.com All Rights Reserved.
 *
 */

package com.wfs.client;

/**
 * ClassName:WfsException <br/>
 * Date: 2017��4��14�� ����1:30:45 <br/>
 * 
 * @author dong
 * @version
 * @since JDK 1.7
 * @desc
 */
public class WfsException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construct a new runtime exception with <code>null</code> as its detail message.
	 */
	public WfsException() {

		super();

	}

	/**
	 * Construct a new runtime exception with the specified detail message.
	 *
	 * @param message
	 *            The detail message for this exception
	 */
	public WfsException(String message) {

		this(message, null);

	}

	/**
	 * Construct a new runtime exception with the specified detail message and cause.
	 *
	 * @param message
	 *            The detail message for this exception
	 * @param cause
	 *            The root cause for this exception
	 */
	public WfsException(String message, Throwable cause) {

		super(message);
		this.cause = cause;

	}

	/**
	 * Construct a new runtime exception with the specified cause and a detail message of
	 * <code>(cause == null &#63; null : cause&#46;toString())</code>.
	 *
	 * @param cause
	 *            The root cause for this exception
	 */
	public WfsException(Throwable cause) {

		super((cause == null) ? (String) null : cause.toString());
		this.cause = cause;

	}

	// ----------------------------------------------------- Instance Variables

	/**
	 * The root cause of this exception
	 */
	protected Throwable cause = null;

	// --------------------------------------------------------- Public Methods

	/**
	 * Return the root cause of this exception (if any).
	 */
	public Throwable getCause() {

		return (this.cause);

	}
}
