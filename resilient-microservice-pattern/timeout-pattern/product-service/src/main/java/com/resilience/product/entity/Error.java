/**
 * 
 */
package com.resilience.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jatin.ghataliya
 *
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Error {

	private int errorCode;
	private String errorMessage;
	private String errorDescription;
	
}