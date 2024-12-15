package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto;

public record CarUpdateDto(
        Integer carId,
        String make,
        String model,
        Integer year,
        String vin,
        String licensePlate,
        String ownerName,
        String ownerContact
) {
}
