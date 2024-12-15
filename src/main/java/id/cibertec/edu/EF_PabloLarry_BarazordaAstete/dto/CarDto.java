package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto;

import java.util.Date;

public record CarDto(
        Integer carId,
        String licensePlate,
        String ownerName,
        String ownerContact,
        String engineType,
        String color,
        String insuranceCompany,
        String insurancePolicyNumber,
        Date registrationExpirationDate,
        Date serviceDueDate
) {
}
