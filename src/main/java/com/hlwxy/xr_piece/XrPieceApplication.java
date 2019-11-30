package com.hlwxy.xr_piece;

import com.hlwxy.xr_piece.system.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class XrPieceApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(XrPieceApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(XrPieceApplication.class, args);
	}
	@Bean
	public MyConfig myConfig(){
		return new MyConfig();
	}

}
