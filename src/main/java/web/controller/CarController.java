package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class CarController {

    CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showCarList(@RequestParam(value = "count",required = false) Integer count, Model model) {
        List<Car>cars = carService.getCars(Objects.requireNonNullElse(count, 5));
        model.addAttribute("cars", cars);
        return "cars";
    }


}