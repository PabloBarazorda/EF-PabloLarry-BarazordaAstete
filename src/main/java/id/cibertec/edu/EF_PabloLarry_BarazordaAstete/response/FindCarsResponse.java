package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.response;

import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code,
                               String error,
                               List<CarDto> cars) {
}
