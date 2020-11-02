/*package com.actual.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.actual.repository")
@ComponentScan(basePackages = { "com.actual.service"})
public class ElasticConfig {

	@Bean
	public RestHighLevelClient client() {
		final ClientConfiguration clientConfiguration
				= ClientConfiguration.builder()
				.connectedTo("localhost:9200")
				.build();

		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
		return new ElasticsearchRestTemplate(client());
	}
}*/
