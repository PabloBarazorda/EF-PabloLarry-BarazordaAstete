package id.cibertec.edu.EF_PabloLarry_BarazordaAstete.controller;


import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.dto.CarDto;
import id.cibertec.edu.EF_PabloLarry_BarazordaAstete.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Fabrica")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<CarDto> cars = manageService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error al solicitar los datos");

        }
        return "Fabrica";
    }

}
