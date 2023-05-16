package com.resilience.product.config;

public class TimeoutApiRequest {

	private String api;
	private String module;
	private String operator;
	
	public TimeoutApiRequest(String api, String module, String operator) {
		super();
		this.api = api;
		this.module = module;
		this.operator = operator;
	}
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "TimeoutApiRequest [api=" + api + ", module=" + module + ", operator=" + operator + "]";
	}
	
}