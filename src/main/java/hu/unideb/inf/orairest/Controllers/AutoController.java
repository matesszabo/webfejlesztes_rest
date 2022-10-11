package hu.unideb.inf.orairest.Controllers;

import hu.unideb.inf.orairest.Entities.AutoEntity;
import hu.unideb.inf.orairest.Entities.TulajdonosEntity;
import hu.unideb.inf.orairest.Repository.AutoRepo;
import hu.unideb.inf.orairest.Repository.TulajdonosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AutoController {

    @Autowired
    AutoRepo autoRepo;

    @Autowired
    TulajdonosRepository tulajdonosRepository;

    @GetMapping("/autok")
    public ResponseEntity<List<AutoEntity>> getAllAuto() {
        return new ResponseEntity<>(Arrays.asList(new AutoEntity(1, "Honda", "Jazz", "KJK-111", "piros", 98)), HttpStatus.OK);
    }

    @GetMapping("/initDb")
    public ResponseEntity initDb() {
        try {
            tulajdonosRepository.save(new TulajdonosEntity("Kiss József", "ZERH01PA", Date.from(Instant.now())));
            autoRepo.save(new AutoEntity("Honda", "Jazz", "KJK-111", "piros", 98));

            TulajdonosEntity t1 = tulajdonosRepository.getReferenceById(1l);
            AutoEntity a1 = new AutoEntity("Honda", "Jazz", "KJK-111", "piros", 98);
            a1.setTulajdonos(t1);
            autoRepo.save(a1);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

}
