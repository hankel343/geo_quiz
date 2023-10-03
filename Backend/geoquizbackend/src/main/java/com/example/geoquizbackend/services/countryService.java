package com.example.geoquizbackend.services;

import com.example.geoquizbackend.models.CountryData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class countryService {
    private final WebClient client;
    public countryService() {
        client = WebClient.builder()
                .baseUrl("https://restcountries.com/v3.1")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<CountryData[]> getByName(String name) {
        return  client
                .get()
                .uri("/name/{name}", name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CountryData[].class);
    }

    public Mono<CountryData[]> getOne(String name) {
        return client
                .get()
                .uri("/name/{name}", name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CountryData[].class);
    }

    /* Used for API queries */
    public Mono<List<String>> getAllCommonNames() {
        return client
                .get()
                .uri("/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryData.class)
                .map(countryData -> countryData.getName().getCommon())
                .collectList();
    }

    /* Filtered by region */
    public Mono<List<String>> getAllCommonNamesAsia() {
        return client
                .get()
                .uri("/region/Asia")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryData.class)
                .map(countryData -> countryData.getName().getCommon())
                .collectList();
    }

    public Mono<List<String>> getAllCommonNamesAmericas() {
        return client
                .get()
                .uri("/region/Americas")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryData.class)
                .map(countryData -> countryData.getName().getCommon())
                .collectList();
    }

    public Mono<List<String>> getAllCommonNamesAfrica() {
        return client
                .get()
                .uri("/region/Africa")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryData.class)
                .map(countryData -> countryData.getName().getCommon())
                .collectList();
    }

    public Mono<List<String>> getAllCommonNamesOceania() {
        return client
                .get()
                .uri("/region/Oceania")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryData.class)
                .map(countryData -> countryData.getName().getCommon())
                .collectList();
    }

    public Mono<List<String>> getAllCommonNamesEurope() {
        return client
                .get()
                .uri("/region/Europe")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryData.class)
                .map(countryData -> countryData.getName().getCommon())
                .collectList();
    }

    public Mono<List<String>> getAllCommonNamesAntarctic() {
        return client
                .get()
                .uri("/region/Antarctic")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryData.class)
                .map(countryData -> countryData.getName().getCommon())
                .collectList();
    }
}
