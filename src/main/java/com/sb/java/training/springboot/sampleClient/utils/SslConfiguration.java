package com.sb.java.training.springboot.sampleClient.utils;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyStore;

@Service
public class SslConfiguration {

    public RestTemplate restTemplate() throws Exception {
        char[] password = "password".toCharArray();
        KeyStore truststore = KeyStore.getInstance("JKS");
        truststore.load(new ClassPathResource("keystore/sampleApp.jks").getInputStream(), password);

        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(
                        truststore,
                        new TrustSelfSignedStrategy()
                ).build();
        SSLConnectionSocketFactory socketFactory =
                new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory).build();
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }
}
