package com.qnbc.venueReservation.config;


import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MinioClientConfig {

	@Value("${minio.endpoint}")
	private String endpoint;
	@Value("${minio.accessKey}")
	private String accessKey;
	@Value("${minio.secretKey}")
	private String secretKey;

	@Bean
	public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {

		return new MinioClient(endpoint, accessKey, secretKey);
	}


}
