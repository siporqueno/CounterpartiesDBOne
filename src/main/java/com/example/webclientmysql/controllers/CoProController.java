package com.example.webclientmysql.controllers;

import com.example.webclientmysql.entities.CounterpartyProduct;
import com.example.webclientmysql.entities.CounterpartyProductId;
import com.example.webclientmysql.repositories.CounterpartyProductRepository;
import com.example.webclientmysql.repositories.CounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/copro") // This means URL's start with /demo (after Application path)
public class CoProController {
    @Autowired // This means to get the bean called counterpartyProductRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CounterpartyProductRepository counterpartyProductRepository;
    @Autowired
    private CounterpartyRepository counterpartyRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewCounterpartyProduct(@RequestParam int counterpartyId, @RequestParam String productShortName,
                                     @RequestParam boolean isBuyer, @RequestParam boolean isSeller,
                                     @RequestParam boolean isConsumer, @RequestParam boolean isProducer,
                                     @RequestParam String quantity) {
        // @ResponseBody means the returned String is the response, not a view counterpartyShortName
        // @RequestParam means it is a parameter from the GET or POST request

        CounterpartyProduct cp = new CounterpartyProduct();
        cp.setCounterpartyId(counterpartyId);
        cp.setProductShortName(productShortName);
        cp.setIsBuyer(isBuyer);
        cp.setIsSeller(isSeller);
        cp.setIsConsumer(isConsumer);
        cp.setIsProducer(isProducer);
        cp.setQuantity(quantity);
        counterpartyProductRepository.save(cp);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CounterpartyProduct> getAllCounterpartyProducts() {
        // This returns a JSON or XML with the counterpartyProducts
        return counterpartyProductRepository.findAll();
    }

    @GetMapping(path = "/listdata")
    public String listCoPro(Model model) {
        model.addAttribute("name", "Kanechno Vasya");
        model.addAttribute("counterpartyproducts", counterpartyProductRepository.findAll());
        model.addAttribute("headerCp", "Here are all the entries in the database:");
        return "copro/allcounterpartyproducts";
    }

    @GetMapping(value = "/create")
    public String formAddCounterpartyProduct(Model model) {
        model.addAttribute("copro", new CounterpartyProduct());
        model.addAttribute("headerCp", "Form to add Counterparty Product");
        return "copro/add-cp-through-view";
    }

    @PostMapping(value = "/show-through-view")
    public String submitCounterpartyProduct(@ModelAttribute CounterpartyProduct counterpartyProduct) {
        counterpartyProduct = counterpartyProductRepository.save(counterpartyProduct);
        return "redirect:/copro/submitted/" + counterpartyProduct.getCounterpartyId() + "/" + counterpartyProduct.getProductShortName();
    }

    @GetMapping(value = "/submitted/{coid}/{pro}")
    public String showSubmittedCounterpartyProduct(ModelMap model, @PathVariable("coid") Integer counterpartyId, @PathVariable("pro") String productShortName) {
        CounterpartyProduct counterpartyProduct = counterpartyProductRepository.findById(new CounterpartyProductId(counterpartyId, productShortName)).orElse(new CounterpartyProduct());
        model.addAttribute("counterpartyProduct", counterpartyProduct);
        model.addAttribute("headerCp", "The following entry has been successfully added to the database:");
        return "copro/cp-processed-view";
    }

    @GetMapping(value = "/create-with-co-select")
    public String formAddCounterpartyProductWithCoSelect(Model model) {
        model.addAttribute("headerCp", "Form to add Counterparty Product With Co Select");
        model.addAttribute("copro", new CounterpartyProduct());
        model.addAttribute("allCos", counterpartyRepository.findAll());
        return "copro/add-cp-through-view-with-co-select";
    }

    @GetMapping(path = "/delete-through-view")
    public String formDeleteById(Model model) {
        model.addAttribute("headerCpId", "Form to delete Counterparty Product");
        model.addAttribute("coproId", new CounterpartyProductId());
        model.addAttribute("btn", "Delete");
        return "copro/do-sth-on-cp-by-cpid-view";
    }

    @PostMapping(path = "/delete-through-view")
    public String displayDeletedById(Model model, @ModelAttribute("coproId") CounterpartyProductId counterpartyProductId) {
        CounterpartyProduct counterpartyProduct = counterpartyProductRepository.findById(counterpartyProductId).orElse(new CounterpartyProduct());
        counterpartyProductRepository.deleteById(counterpartyProductId);
        model.addAttribute("counterpartyProduct", counterpartyProduct);
        model.addAttribute("headerCp", "The following entry has been successfully deleted from the database:");
//        return "deleted-through-view";
        return "copro/cp-processed-view";

    }

    @GetMapping(path = "/find-copro-by-coproid-view")
    public String formFindById(Model model) {
        model.addAttribute("headerCpId", "Form to search Counterparty Product by Counterparty and Product");
        model.addAttribute("coproId", new CounterpartyProductId());
        model.addAttribute("btn", "Search");
        return "copro/find-cp-by-cpid-view";
    }

    @PostMapping(path = "/find-copro-by-coproid-view")
    public String displayFoundById(Model model, @ModelAttribute("coproId") CounterpartyProductId counterpartyProductId) {
        CounterpartyProduct counterpartyProduct = counterpartyProductRepository.findById(counterpartyProductId).orElse(new CounterpartyProduct());
//        counterpartyProductRepository.deleteById(counterpartyProductId);
        model.addAttribute("counterpartyProduct", counterpartyProduct);
        model.addAttribute("headerCp", "The following entry has been found in the database:");
//        return "deleted-through-view";
        return "copro/cp-processed-view";
    }

    @GetMapping(path = "/find-copro-by-co-or-pro-etc-view")
    public String formFindByCoEtc(Model model) {
        model.addAttribute("headerCpId", "Form to search Counterparty Product by Counterparty or Product etc.");
        model.addAttribute("coproId", new CounterpartyProductId());
        model.addAttribute("btn", "Search");
        return "copro/form-to-find-cp-by-co-or-pro-etc";
    }

    @PostMapping(path = "/find-copro-by-co-or-pro-etc-view")
    public String displayFoundByCoEtc(Model model, @ModelAttribute("coproId") CounterpartyProductId counterpartyProductId, @RequestParam("searchOption") String searchOption) {
        Integer counterpartyId = counterpartyProductId.getCounterpartyId();
        String productShortName = counterpartyProductId.getProductShortName();
        System.out.println(counterpartyId + "  " + productShortName);
        List<CounterpartyProduct> counterpartyProducts = new ArrayList<>();
        switch (searchOption) {
            case "ByCounterpartyId":
                counterpartyProducts = counterpartyProductRepository.findCounterpartyProductsByCounterpartyId(counterpartyId);
                break;
            case "ByProduct":
                counterpartyProducts = counterpartyProductRepository.findCounterpartyProductsByProductShortName(productShortName);
                break;
            case "ByCounterpartyIdOrProduct":
                counterpartyProducts = counterpartyProductRepository.findCounterpartyProductsByCounterpartyIdOrProductShortName(counterpartyId, productShortName);
                break;
            case "ByCounterpartyIdAndProduct":
                counterpartyProducts = counterpartyProductRepository.findCounterpartyProductsByCounterpartyIdAndProductShortName(counterpartyId, productShortName);
                break;
            default:
                System.out.println("Default option in switch");
        }
//        CounterpartyProduct counterpartyProduct = counterpartyProductRepository.findById(counterpartyProductId).orElse(new CounterpartyProduct());
//        model.addAttribute("counterpartyProduct", counterpartyProduct);
        model.addAttribute("counterpartyproducts", counterpartyProducts);
        model.addAttribute("headerCp", "Entry(ies) found in the database:");
//        System.out.println(searchOption);
        return "copro/allcounterpartyproducts";
    }

    @GetMapping(path = "")
    public String goHome() {
        return "index";
    }

    @GetMapping(path = "/copro")
    public String goToCoPro() {
        return "co-pro";
    }
}
