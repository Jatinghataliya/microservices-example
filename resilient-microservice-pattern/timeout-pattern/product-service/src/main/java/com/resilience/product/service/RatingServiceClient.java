package com.resilience.product.service;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.resilience.dto.ProductRatingDto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

@Service
public class RatingServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rating.service.endpoint}")
    private String ratingService;
    
    private Map<String, Long> timeoutApi = new HashMap<>();

    @TimeLimiter(name = "ratingService", fallbackMethod = "getDefault")
    public CompletionStage<ProductRatingDto> getProductRatingDto(int productId){
        Supplier<ProductRatingDto> supplier = () ->
            this.restTemplate.getForEntity(this.ratingService + productId, ProductRatingDto.class)
                    .getBody();
        System.out.println(supplier.get().toString());
        return CompletableFuture.supplyAsync(supplier);
    }

    private static String getApi(String url) {
	    String[] urls = url.split("/");
	    try {
		    if (urls != null && urls.length > 0 ) {
		    	String api =  urls[urls.length - 1];
		    	if (api != null) {
		    		return api;
		    	}
		    }
	    } catch (Exception e) {
	    	return url;
		}
	    return url;
	}
    
	/*
	 * public long getTimeoutApi(String api) { Long timeout = timeoutApi.get(api);
	 * if (timeout != null) { return timeout; } else { //Long apiTimeout =
	 * CommonUtils.getTimeOutApi(api); //timeoutApi.put(api, timeout); //return
	 * apiTimeout; } }
	 */
    
    @TimeLimiter(name = "ratingService", fallbackMethod = "getDefault")
    public ProductRatingDto getProductRatingDtoAsync(int productId){
    	ProductRatingDto supplier =  this.restTemplate.getForEntity(this.ratingService + productId, ProductRatingDto.class)
                    .getBody();
        System.out.println(supplier.toString());
        return supplier;
    }

    private CompletionStage<ProductRatingDto> getDefault(int productId, Throwable throwable){
        return CompletableFuture.supplyAsync(() -> ProductRatingDto.of(0, Collections.emptyList()));
    }

}
