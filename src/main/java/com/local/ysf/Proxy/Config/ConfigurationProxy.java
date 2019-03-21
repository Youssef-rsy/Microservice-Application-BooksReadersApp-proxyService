package com.local.ysf.Proxy.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.local.ysf.Proxy.filter.SimpleFilter;

@Configuration
public class ConfigurationProxy {
	 @Bean
	  public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }
}
