package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.api;


import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDetailDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarUpdateDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.response.*;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars() {

        try {
            List<CarDto> cars = manageService.getAllCars();
            if (!cars.isEmpty())
                return new FindCarsResponse("01",null, cars);
            else
                return new FindCarsResponse("02","Users not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "an error occurred, please try again", null);
        }
    }

    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "carId", defaultValue = "0") String carId) {

        try {
            Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(carId));
            return optional.map( car ->
                    new FindCarResponse("01", null, car)
            ).orElse(
                    new FindCarResponse("02", "User not found", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "An error occurred, please try again", null);
        }
    }


    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {

        try {
            if (manageService.updateCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "User not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error occurred, please try again");

        }
    }

    @DeleteMapping("/delete/{carId}")
    public DeleteCarResponse deleteCar(@PathVariable String carId) {

        try {
            if (manageService.deleteCarById(Integer.parseInt(carId)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "User not found");
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error occurred, please try again");

        }

    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarUpdateDto carUpdateDto) {

        try {
            if (manageService.addCar(carUpdateDto))
                return new CreateCarResponse("01", null);
            else return new CreateCarResponse("02", "User already exists");
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error occurred, please try again");

        }

    }


}
