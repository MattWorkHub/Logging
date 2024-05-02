package logging.controllers;
import logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private BasicService basicService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public ResponseEntity<String> getHello(){
        String saluto = "Benvenuti";
        LOGGER.info("Welcome message requested");
        return ResponseEntity.ok().body(saluto);
    }

    @GetMapping("/exp")
    public ResponseEntity<String> getExponent(){
        LOGGER.info("Calculation done");
        return ResponseEntity.ok().body(String.valueOf(basicService.exponent()));
    }

    @GetMapping("/get-errors")
    public ResponseEntity<String> getErrors() {
        LOGGER.error("An error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }


}