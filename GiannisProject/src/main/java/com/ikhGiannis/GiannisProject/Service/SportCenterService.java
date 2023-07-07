package com.ikhGiannis.GiannisProject.Service;

// ------------------------------O(n^3)-------------------------------------
//package com.ikhGiannis.GiannisProject.Service;
//
//import com.ikhGiannis.GiannisProject.Model.Court;
//import com.ikhGiannis.GiannisProject.Model.Owner;
//import com.ikhGiannis.GiannisProject.Model.SportCenter;
//import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
//import com.ikhGiannis.GiannisProject.Repository.OwnerRepository;
//import com.ikhGiannis.GiannisProject.Repository.SportCenterRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SportCenterService {
//    private final CourtRepository courtRepository;
//    private final OwnerRepository ownerRepository;
//    private  SportCenterRepository sportCenterRepository;
//
//
//
//    public SportCenterService(SportCenterRepository sportCenterRepository, CourtRepository courtRepository,OwnerRepository ownerRepository) {
//        this.sportCenterRepository = sportCenterRepository;
//        this.courtRepository = courtRepository;
//        this.ownerRepository = ownerRepository;
//    }
//
//    public void bulkInsertTry() {
//        int sportCenterCount = 100;
//        int courtCount = 1000;
//        int ownerCourt = 100;
//
//        for (int k = 0; k < ownerCourt; k++) {
//            Owner owner = new Owner();
//            owner.setOwnerName("Giannis");
//            owner.setSurname("IKH");
//            owner.setPassword(123);
//            owner.setEmail("ikh@ikh.gr");
//            Owner createdOwner = ownerRepository.save(owner);
//
//            for (int i = 0; i < sportCenterCount; i++) {
//                SportCenter sportCenter = new SportCenter();
//                sportCenter.setSportCenterName("Sport Center " + (i + 1));
//                sportCenter.setAddress("ikh " + (i + 1));
//                sportCenter.setOwner(createdOwner);
//                SportCenter createdSportCenter = sportCenterRepository.save(sportCenter);
//
//                for (int j = 0; j < courtCount; j++) {
//                    Court court = new Court();
//                    court.setCourtName("Court " + (j + 1));
//                    court.setCapacity(j + 1);
//                    court.setPrice(10);
//                    court.setSport("basket");
//                    court.setSportCenter(createdSportCenter);
//
//                    courtRepository.save(court);
//                }
//
//
//            }
//
//        }
//    }
//}

// ------------------------------O(n^3)/M---------------------------------------


import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.Owner;
import com.ikhGiannis.GiannisProject.Model.SportCenter;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
import com.ikhGiannis.GiannisProject.Repository.OwnerRepository;
import com.ikhGiannis.GiannisProject.Repository.SportCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Service
public class SportCenterService {
    private final CourtRepository courtRepository;
    private final OwnerRepository ownerRepository;
    private final SportCenterRepository sportCenterRepository;

    @Autowired
    public SportCenterService(SportCenterRepository sportCenterRepository, CourtRepository courtRepository, OwnerRepository ownerRepository) {
        this.sportCenterRepository = sportCenterRepository;
        this.courtRepository = courtRepository;
        this.ownerRepository = ownerRepository;
    }

    public void bulkInsertTry() {
        int sportCenterCount = 100;
        int courtCount = 10000;
        int ownerCourt = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        IntStream.range(0, ownerCourt)
                .parallel()
                .forEach(k -> {
                    Owner owner = new Owner();
                    owner.setOwnerName("Giannis");
                    owner.setSurname("IKH");
                    owner.setPassword(123);
                    owner.setEmail("ikh@ikh.gr");
                    Owner createdOwner = ownerRepository.save(owner);

                    CompletableFuture.runAsync(() -> {
                        IntStream.range(0, sportCenterCount)
                                .forEach(i -> {
                                    SportCenter sportCenter = new SportCenter();
                                    sportCenter.setSportCenterName("Sport Center " + (i + 1));
                                    sportCenter.setAddress("ikh " + (i + 1));
                                    sportCenter.setOwner(createdOwner);
                                    SportCenter createdSportCenter = sportCenterRepository.save(sportCenter);

                                    IntStream.range(0, courtCount)
                                            .forEach(j -> {
                                                Court court = new Court();
                                                court.setCourtName("Court " + (j + 1));
                                                court.setCapacity(j + 1);
                                                court.setPrice(10);
                                                court.setSport("basket");
                                                court.setSportCenter(createdSportCenter);

                                                courtRepository.save(court);
                                            });
                                });
                    }, executorService);
                });

        executorService.shutdown();
    }

}
