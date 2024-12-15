package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.service;

import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDetailDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int carId) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int carId) throws Exception;

    boolean addCar(CarUpdateDto carUpdateDto) throws Exception;
}
