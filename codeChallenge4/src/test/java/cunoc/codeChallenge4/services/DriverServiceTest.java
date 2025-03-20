package cunoc.codeChallenge4.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import cunoc.codeChallenge4.models.Driver;
import cunoc.codeChallenge4.repositories.DriverRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverService driverService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDriver_Exito() throws Exception {
        Driver nuevoDriver = new Driver();
        nuevoDriver.setName("Juan");
        nuevoDriver.setAge(18);

        when(driverRepository.findOneByName("Juan")).thenReturn(Optional.empty());
        when(driverRepository.save(any(Driver.class))).thenReturn(nuevoDriver);

        Driver result = driverService.createDriver(nuevoDriver);

        assertNotNull(result);
        assertEquals("Juan", result.getName());
        assertEquals(18, result.getAge());
        verify(driverRepository, times(1)).save(nuevoDriver);
    }

    @Test
    void createDriver_Falla_CuandoNombreExiste() {
        Driver driverExistente = new Driver();
        driverExistente.setName("Pedro");
        driverExistente.setAge(23);

        when(driverRepository.findOneByName("Pedro")).thenReturn(Optional.of(driverExistente));

        Exception exception = assertThrows(Exception.class, () -> driverService.createDriver(driverExistente));
        assertEquals("El nombre ya existe", exception.getMessage());
        verify(driverRepository, never()).save(any(Driver.class));
    }

    @Test
    void updateDriver_Exito() throws Exception {
        Driver driverExistente = new Driver();
        driverExistente.setId(1L);
        driverExistente.setName("Pedro");
        driverExistente.setAge(23);

        when(driverRepository.existsById(driverExistente.getId())).thenReturn(true);
        when(driverRepository.findOneByName("Pedro")).thenReturn(Optional.of(driverExistente));
        when(driverRepository.save(any(Driver.class))).thenReturn(driverExistente);

        Driver updatedDriver = driverService.updateDriver(driverExistente);

        assertNotNull(updatedDriver);
        assertEquals("Pedro", updatedDriver.getName());
        verify(driverRepository, times(1)).save(driverExistente);
    }

    @Test
    void updateDriver_Falla_CuandoDriverNoExiste() {
        Driver driverInexistente = new Driver();
        driverInexistente.setId(99L);
        driverInexistente.setName("Carlos");
        driverInexistente.setAge(30);

        when(driverRepository.existsById(driverInexistente.getId())).thenReturn(false);

        Exception exception = assertThrows(Exception.class, () -> driverService.updateDriver(driverInexistente));

        assertEquals("El usuario ingrsado no existe", exception.getMessage());
        verify(driverRepository, never()).save(any(Driver.class));
    }
}
