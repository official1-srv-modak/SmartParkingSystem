package com.modakdev.smartparkingsystem.api;

import com.modakdev.smartparkingsystem.api.service.ParkingLotService;
import com.modakdev.smartparkingsystem.api.service.impl.ParkingLotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {


    private final ParkingLotServiceImpl parkingLotService;

    @Autowired
    public Controller(ParkingLotServiceImpl parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping("/")
    public String viewParkingSpots(Model model)
    {
        model.addAttribute("spots", parkingLotService.getAllSpots());
        return "index";
    }

    @PostMapping("/reserve/{id}")
    public String reserveSpot(@PathVariable int id, RedirectAttributes redirectAttributes)
    {
        parkingLotService.reserveSpot(id);
        redirectAttributes.addFlashAttribute("message", "spot "+ id + " has been reserved.");
        return "redirect:/";
    }

    @PostMapping("/release/{id}")
    public String releaseSpot(@PathVariable int id, RedirectAttributes redirectAttributes)
    {
        parkingLotService.releaseSpot(id);
        redirectAttributes.addFlashAttribute("message", "spot "+ id + " has been release.");
        return "redirect:/";
    }
}
