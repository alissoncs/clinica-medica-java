package com.vine.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vine.dto.ErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinessValidationException.class)
	public ResponseEntity<ErrorDTO> handleBusinessValidation(BusinessValidationException ex) {
		ErrorDTO dto = new ErrorDTO();
		dto.setMessage(ex.getMessage());
		dto.setErrorCode(1170);
		dto.setType("BusinessValidationException");
		
		return new ResponseEntity<ErrorDTO>(dto, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
