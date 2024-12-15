package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.response;

import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto carDetailDto) {
}
