package cunoc.codeChallenge4.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cunoc.codeChallenge4.models.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {

    public Optional<Driver> findOneByName(String name);
}
