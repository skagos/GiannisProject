package com.ikhGiannis.GiannisProject.Service;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class CourtService {
    private CourtRepository courtRepository;
    private WebClient webClient;

    public CourtService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://countriesnow.space/api/v0.1/countries")
                .build();
    }

    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    public Court getCourtById(int id) {
        Optional<Court> courtOptional = courtRepository.findById(id);
        return courtOptional.orElse(null);
    }

    public Court saveCourt(Court court) {
        return courtRepository.save(court);
    }

    public ResponseEntity<String> createCourt(Court court) {
        return ResponseEntity.ok("Court added successfully");
    }

    public ResponseEntity<String> deleteCourt(Court court) {
        return ResponseEntity.ok("Court deleted successfully");
    }
}


//    public void firstAPICall() {
//        // Create a RestTemplate instance
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Set the URL of the API you want to call
//        String apiUrl = "https://countriesnow.space/api/v0.1/countries/population/cities";
//
//        // Make the API call
//        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
//
//        // Handle the response
//        if (response.getStatusCode().is2xxSuccessful()) {
//            String responseBody = response.getBody();
//            // Process the response body
//            System.out.println(responseBody);
//        } else {
//            System.out.println("API call failed with status code: " + response.getStatusCodeValue());
//        }
//    }



