package com.example.webclientmysql.controllers;

import com.example.webclientmysql.entities.Counterparty;
import com.example.webclientmysql.entities.CounterpartyId;
import com.example.webclientmysql.entities.CounterpartyProduct;
import com.example.webclientmysql.entities.CounterpartyProductId;
import com.example.webclientmysql.repositories.CounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return "redirect:/co/submitted/" + counterparty.getId();
    }

    @GetMapping(value = "/submitted/{coid}")
    public String showSubmittedCounterparty(ModelMap model, @PathVariable("coid") Integer counterpartyId) {
        Counterparty counterparty = counterpartyRepository.findById(counterpartyId).orElse(new Counterparty());
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
        Counterparty counterparty = counterpartyRepository
                .findByCounterpartyShortNameAndCountryCodeAndPlace(counterpartyId.getCounterpartyShortName(),
                        counterpartyId.getCountryCode(), counterpartyId.getPlace()).orElse(new Counterparty(-1, counterpartyId));
        System.out.println(counterparty.getCounterpartyShortName());
        System.out.println(counterparty.getCountryCode());
        System.out.println(counterparty.getRegion());
        System.out.println(counterparty.getPlace());
        if (counterparty.getId() != -1) counterpartyRepository.deleteById(counterparty.getId());
        model.addAttribute("counterparty", counterparty);
        model.addAttribute("headerCo", (counterparty.getId() != -1) ? "The following entry has been successfully deleted from the database:" : "The following entry was not present in the database hence could not be deleted");
        return "co/co-processed-view";

    }

    @GetMapping(path = "/find-co-by-name-or-country-etc-view")
    public String formFindCoByNameOrCountryEtc(Model model) {
        model.addAttribute("headerCo", "Form to search Counterparty by Name or Country or Region or Place");
        model.addAttribute("co", new Counterparty());
        model.addAttribute("btn", "Search");
        return "co/form-to-find-co-by-name-or-country-etc";
    }

    @PostMapping(path = "/find-co-by-name-or-country-etc-view")
    public String displayCosFoundByNameOrCountryEtc(Model model, @ModelAttribute("co") Counterparty counterparty, @RequestParam("searchOption") String searchOption) {
        List<Counterparty> counterparties = new ArrayList<>();
        switch (searchOption) {
            case "ById":
                counterparties = counterpartyRepository.findById(counterparty.getId()).stream().collect(Collectors.toList());
                break;
            case "ByName":
                counterparties = counterpartyRepository.findByCounterpartyShortName(counterparty.getCounterpartyShortName());
                break;
            case "ByCountry":
                counterparties = counterpartyRepository.findByCountryCode(counterparty.getCountryCode());
                break;
            case "ByRegion":
                counterparties = counterpartyRepository.findByRegion(counterparty.getRegion());
                break;
            case "ByPlace":
                counterparties = counterpartyRepository.findByPlace(counterparty.getPlace());
                break;
            default:
                System.out.println("Default option in switch");
        }
//        CounterpartyProduct counterpartyProduct = counterpartyProductRepository.findById(counterpartyProductId).orElse(new CounterpartyProduct());
//        model.addAttribute("counterpartyProduct", counterpartyProduct);
        model.addAttribute("counterparties", counterparties);
        model.addAttribute("headerCp", "Entry(ies) found in the database:");
//        System.out.println(searchOption);
        return "co/allcounterparties";
    }
}
