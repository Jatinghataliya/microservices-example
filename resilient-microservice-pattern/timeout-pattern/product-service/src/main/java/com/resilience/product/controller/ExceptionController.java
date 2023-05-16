package com.resilience.product.controller;

import java.net.SocketTimeoutException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.resilience.product.entity.Error;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler({SocketTimeoutException.class, Exception.class})
	public Error handleError(SocketTimeoutException ste) {
		return Error.builder().errorCode(500).errorMessage("Failed").errorDescription(ste.getMessage()).build();
	}
	
}
