package com.ikhGiannis.GiannisProject.Service;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import javax.management.Query;
import java.util.List;
import java.util.Optional;


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






