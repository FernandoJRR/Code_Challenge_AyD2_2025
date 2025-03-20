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

    public Driver updateDriver(Driver driver) throws Exception {
        Boolean driverExists = this.driverRepository.existsById(driver.getId());
        if (!driverExists) {
            throw new Exception("El usuario ingrsado no existe");
        }
        Optional<Driver> existantName = this.getDriverByName(driver.getName());
        if (existantName.isPresent()) {
            Driver existantDriver = existantName.get();
            if (existantDriver.getId() != driver.getId()) {
                throw new Exception("El nombre ya existe, por lo que no puedes usarlo");
            }
            return this.driverRepository.save(driver);
        } else {
            return this.driverRepository.save(driver);
        }
    }

    public void deleteDriver(Long id_driver) throws Exception {
        Boolean driverExists = this.driverRepository.existsById(id_driver);
        if (!driverExists) {
            throw new Exception("El usuario ingrsado no existe");
        }
        this.driverRepository.deleteById(id_driver);
    }
}
