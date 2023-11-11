package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.carsDetails.Cardiscription;
import web.model.Car;
import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarController {

    @GetMapping
    public String getCars(@RequestParam(name = "locale", defaultValue = "en", required = false) String locale,
                          @RequestParam(name = "count", defaultValue = "-1", required = false) int count,
                          ModelMap model) {
        Cardiscription cardiscription = new Cardiscription();
        List<Car> allCars = cardiscription.getAllCars();

        if (count >= 5) {
            model.addAttribute("cars", allCars);
        } else if (count > 0 && count < allCars.size()) {
            List<Car> selectedCars = allCars.subList(0, count);
            model.addAttribute("cars", selectedCars);
        } else {
            model.addAttribute("cars", allCars);
        }
        return "cars";
    }
}