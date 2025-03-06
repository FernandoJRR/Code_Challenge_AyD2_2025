package cunoc.codeChallenge4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cunoc.codeChallenge4.models.Driver;
import cunoc.codeChallenge4.repositories.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getDrivers() {
        return  (List<Driver>) this.driverRepository.findAll();
    }

    public Optional<Driver> getDriverByName(String name) {
        return this.driverRepository.findOneByName(name);
    }

    public Driver createDriver(Driver driver) throws Exception {
        Optional<Driver> existantName = this.getDriverByName(driver.getName());
        if (existantName.isPresent()) {
            throw new Exception("El nombre ya existe");
        } else {
            return this.driverRepository.save(driver);
        }
    }
}
