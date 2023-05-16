package com.resilience.product.config;

public class TimeoutApiResponse {

	
	private long id;
	private String api;
	private String module;
	private String operator;
	private long timeout;
	
	public TimeoutApiResponse(long id, String api, String module, String operator, long timeout) {
		super();
		this.id = id;
		this.api = api;
		this.module = module;
		this.operator = operator;
		this.timeout = timeout;
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
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "TimeoutApiRequest [id= "+id+", api=" + api + ", module=" + module + ", operator=" + operator + ", timeout=" + timeout +"]";
	}
	
}