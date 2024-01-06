package com.antonbondoc.service;

import com.antonbondoc.config.ObjectMapperConfig;
import com.antonbondoc.config.WeatherApiConfig;
import com.antonbondoc.model.CurrentWeatherVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class WeatherServiceDefault implements WeatherService {

    private final ObjectMapper objectMapper = ObjectMapperConfig.createConfiguredObjectMapper();

    @Override
    public CurrentWeatherVO getCurrentWeather() {
        log.info("Getting current weather");
        AtomicReference<CurrentWeatherVO> currentWeatherVO = new AtomicReference<>();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = "https://api.openweathermap.org/data/2.5/weather";

            // Request Parameters
            URI uri = new URIBuilder(url)
                    .addParameter("q", WeatherApiConfig.CITY + "," + WeatherApiConfig.COUNTRY_CODE)
                    .addParameter("appId", WeatherApiConfig.APP_ID)
                    .build();

            HttpGet httpGet = new HttpGet(uri);

            log.info("Calling [GET] {}", url);
            httpClient.execute(httpGet, response -> {
                HttpEntity httpEntity = response.getEntity();
                String responseBody = EntityUtils.toString(httpEntity);

                log.info("The response body is: {}", responseBody);

                // Maps the response body to CurrentWeatherVO
                currentWeatherVO.set(objectMapper.readValue(responseBody, CurrentWeatherVO.class));

                EntityUtils.consume(httpEntity);    // Closes the entity
                return null;
            });

        } catch (JsonMappingException e) {
            log.error("Json mapping error: {}", e.getMessage());
        } catch (JsonProcessingException e) {
            log.error("Json processing error: {}", e.getMessage());
        } catch (URISyntaxException e) {
            log.error("Failed to create URI | {}", e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("CRITICAL: Fail to call API");
        }

        return currentWeatherVO.get();
    }
}
