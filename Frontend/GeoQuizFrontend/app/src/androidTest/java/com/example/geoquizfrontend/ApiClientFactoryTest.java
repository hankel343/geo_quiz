package com.example.geoquizfrontend;

import static org.junit.Assert.assertNotNull;

import com.example.geoquizfrontend.services.ApiService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import retrofit2.Retrofit;

@RunWith(JUnit4.class)
public class ApiClientFactoryTest {

    private ApiClientFactory apiClientFactory;

    @Before
    public void setup() {
        apiClientFactory = new ApiClientFactory();
    }

    @Test
    public void testGetApiClientSeed() {
        Retrofit apiClientSeed = apiClientFactory.GetApiClientSeed();
        assertNotNull(apiClientSeed);
    }

    @Test
    public void testGetGeoQuizApi() {
        ApiService apiService = apiClientFactory.GetGeoQuizApi();
        assertNotNull(apiService);
    }
}

