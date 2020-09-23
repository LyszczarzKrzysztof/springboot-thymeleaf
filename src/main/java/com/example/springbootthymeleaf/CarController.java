package com.example.springbootthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars;

    public CarController() {
        Car car = new Car("BMW", "E3");
        Car car2 = new Car("Fiat", "126p");
        Car car3 = new Car("Polonez", "Caro");
        Car car4 = new Car("Hyunday", "i30");
        cars = new ArrayList<>();
        cars.addAll(Arrays.asList(car, car2, car3, car4));
    }

    @GetMapping("/car")
    public String get(Model model) {
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        cars.add(car);
        return  "redirect:/car";
    }
}
