package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.service.impl;

import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDetailDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarUpdateDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.entity.Car;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.repository.CarRepository;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach( car -> {
            cars.add(new CarDto(car.getCarId(),
                    car.getLicensePlate(),
                    car.getOwnerName(),
                    car.getOwnerContact(),
                    car.getEngineType(),
                    car.getColor(),
                    car.getInsuranceCompany(),
                    car.getInsurancePolicyNumber(),
                    car.getRegistrationExpirationDate(),
                    car.getServiceDueDate()));
        });
        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map( car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map( car -> {
            car.setLicensePlate(carDto.licensePlate());
            car.setOwnerName(carDto.ownerName());
            car.setOwnerContact(carDto.ownerContact());
            car.setEngineType(carDto.engineType());
            car.setColor(carDto.color());
            car.setInsuranceCompany(carDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDto.registrationExpirationDate());
            car.setServiceDueDate(carDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int carId) throws Exception {

        Optional<Car> optional = carRepository.findById(carId);
        return optional.map( car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }


    @Override
    public boolean addCar(CarUpdateDto carUpdateDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carUpdateDto.carId());
        if (optional.isPresent())
            return false;
        else {
            Car car = new Car();
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());
            car.setVin(carUpdateDto.vin());
            car.setLicensePlate(carUpdateDto.licensePlate());
            car.setOwnerName(carUpdateDto.ownerName());
            car.setOwnerContact(carUpdateDto.ownerContact());
            carRepository.save(car);
            return true;
        }
    }
}
