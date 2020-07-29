package com.example.webclientmysql.controllers;

import com.example.webclientmysql.entities.Counterparty;
import com.example.webclientmysql.entities.CounterpartyId;
import com.example.webclientmysql.repositories.CounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/co")
public class CoController {
    @Autowired
    private CounterpartyRepository counterpartyRepository;

    @GetMapping(path = "/listdata")
    public String listCo(Model model) {
        model.addAttribute("name", "Kanechno Vasya");
        model.addAttribute("counterparties", counterpartyRepository.findAll());
        model.addAttribute("headerCo", "Here are all the entries in the database:");
        return "co/allcounterparties";
    }

    @GetMapping(value = "/create")
    public String formAddCounterparty(Model model) {
        model.addAttribute("co", new Counterparty());
        model.addAttribute("headerCo", "Form to add Counterparty");
        return "co/add-co-through-view";
    }

    @PostMapping(value = "/show-through-view")
    public String submitCounterparty(@ModelAttribute Counterparty counterparty) {
        counterparty = counterpartyRepository.save(counterparty);
        return "redirect:/co/submitted/" + counterparty.getCounterpartyShortName() + "/" + counterparty.getCountryCode()+"/"+counterparty.getPlace();
    }

    @GetMapping(value = "/submitted/{co}/{ccode}/{place}")
    public String showSubmittedCounterparty(ModelMap model, @PathVariable("co") String counterpartyShortName, @PathVariable("ccode") String countryCode, @PathVariable("place") String place) {
        Counterparty counterparty = counterpartyRepository.findById(new CounterpartyId(counterpartyShortName, countryCode, place)).orElse(new Counterparty());
        model.addAttribute("counterparty", counterparty);
        model.addAttribute("headerCo", "The following entry has been successfully added to the database:");
        return "co/co-processed-view";
    }

    @GetMapping(path = "/delete-through-view")
    public String formDeleteCoById(Model model) {
        model.addAttribute("headerCoId", "Form to delete Counterparty");
        model.addAttribute("coId", new CounterpartyId());
        model.addAttribute("btn", "Delete");
        return "co/do-sth-on-co-by-coid-view";
    }

    @PostMapping(path = "/delete-through-view")
    public String displayDeletedCoById(Model model, @ModelAttribute("coId") CounterpartyId counterpartyId) {
        Counterparty counterparty = counterpartyRepository.findById(counterpartyId).orElse(new Counterparty());
        counterpartyRepository.deleteById(counterpartyId);
        model.addAttribute("counterparty", counterparty);
        model.addAttribute("headerCo", "The following entry has been successfully deleted from the database:");
//        return "deleted-through-view";
        return "co/co-processed-view";

    }
}
