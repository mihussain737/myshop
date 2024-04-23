package com.myshop.exception;

import java.time.LocalDateTime;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class ErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String errorCode;

}
