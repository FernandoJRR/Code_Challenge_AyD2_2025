package cunoc.codeChallenge4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cunoc.codeChallenge4.models.Driver;
import cunoc.codeChallenge4.services.DriverService;

@RestController
@RequestMapping("driver")
public class DriverControllers {

    @Autowired
    private DriverService driverService;

    @GetMapping()
    public ResponseEntity<List<Driver>> getDriver() {
        List<Driver> drivers = this.driverService.getDrivers();
        return new ResponseEntity<>(drivers, HttpStatus.CREATED);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> postDriver(@RequestBody Driver driver){
        Driver createdDriver;
        try {
            createdDriver = this.driverService.createDriver(driver);
            return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
        }
    }
}
