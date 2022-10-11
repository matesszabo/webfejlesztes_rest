package hu.unideb.inf.orairest.Controllers;

import hu.unideb.inf.orairest.Entities.AutoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AutoController {


    @GetMapping("/autok")
    public ResponseEntity<List<AutoEntity>> getAllTutorials(@RequestParam(required = false) String title) {
        return new ResponseEntity<>(Arrays.asList(new AutoEntity(1, "Honda", "Jazz", "KJK-111", "piros", 98)), HttpStatus.OK);
    }

}
