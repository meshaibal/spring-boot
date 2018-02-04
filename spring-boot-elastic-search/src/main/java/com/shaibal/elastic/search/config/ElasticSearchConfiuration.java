package com.shaibal.elastic.search.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.util.Assert;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.shaibal.elastic.search.repository")
public class ElasticSearchConfiuration {

	@Value("${elastic.search.host}")
	private String host;
	
	@Value("${elastic.search.port}")
	private int port;
	
	@Value("${elastic.search.cluster.name}")
	private String clusterName;
	
	@PostConstruct
	public void afterPropertySet() {
		Assert.notNull(host, "May be elastic.search.host is missing !!");
		Assert.notNull(port, "May be elastic.search.port is missing !!");
	}
	
	@Bean
	public Client client() throws UnknownHostException {
		Settings settings = Settings.settingsBuilder()
									.put("cluster.name", clusterName)
									.build();
		
		return TransportClient.builder()
							  .settings(settings)
							  .build()
							  .addTransportAddress(
									  new InetSocketTransportAddress(InetAddress.getByName(host), port));
	}
	
	@Bean
	public ElasticsearchOperations  elasticsearchTemplate() throws UnknownHostException {
		return new ElasticsearchTemplate(client());
	}
}
