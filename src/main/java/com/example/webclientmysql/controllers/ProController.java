package com.example.webclientmysql.controllers;

import com.example.webclientmysql.entities.Counterparty;
import com.example.webclientmysql.entities.CounterpartyId;
import com.example.webclientmysql.entities.Product;
import com.example.webclientmysql.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/pro")
public class ProController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/listdata")
    public String listCo(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("headerPros", "Here are all the entries in the database:");
        return "pro/allproducts";
    }

    @GetMapping(value = "/create")
    public String formAddProduct(Model model) {
        model.addAttribute("pro", new Product());
        model.addAttribute("headerPro", "Form to add Product");
        return "pro/add-pro-through-view";
    }

    @PostMapping(value = "/show-through-view")
    public String submitProduct(@ModelAttribute Product product) {
        product = productRepository.save(product);
        return "redirect:/pro/submitted/" + product.getProductShortName();
    }

    @GetMapping(value = "/submitted/{proshortname}")
    public String showSubmittedProduct(ModelMap model, @PathVariable("proshortname") String productShortName) {
        Product product = productRepository.findById(productShortName).orElse(new Product());
        model.addAttribute("product", product);
        model.addAttribute("headerPro", "The following entry has been successfully added to the database:");
        return "pro/pro-processed-view";
    }

    @GetMapping(path = "/delete-through-view")
    public String formDeleteProByShortName(Model model) {
        model.addAttribute("headerPro", "Form to delete Product");
        model.addAttribute("pro", new Product());
        model.addAttribute("btn", "Delete");
        return "pro/do-sth-on-pro-by-short-name-view";
    }

    @PostMapping(path = "/delete-through-view")
    public String displayProDeletedByShortName(Model model, @ModelAttribute("pro") Product product) {
        String productShortName = product.getProductShortName();
        Product productFound = productRepository.findById(productShortName).orElse(new Product(productShortName, "NotFound"));
        if (!productFound.getProductFullName().equals("NotFound")) productRepository.deleteById(productShortName);
        model.addAttribute("product", productFound);
        model.addAttribute("headerPro", (!productFound.getProductFullName().equals("NotFound")) ? "The following entry has been successfully deleted from the database:" : "The following entry was not present in the database hence could not be deleted:");
        return "pro/pro-processed-view";
    }

    @GetMapping(path = "/find-pro-by-short-or-full-name-view")
    public String formFindProByShortOrFullName(Model model) {
        model.addAttribute("headerPro", "Form to search Product by Short/Full Name");
        model.addAttribute("pro", new Product());
        model.addAttribute("btn", "Search");
        return "pro/form-to-find-pro-by-name";
    }

    @PostMapping(path = "/find-pro-by-short-or-full-name-view")
    public String displayProsFoundByShortOrFullName(Model model, @ModelAttribute("pro") Product product, @RequestParam("searchOption") String searchOption) {
        List<Product> products = new ArrayList<>();
        switch (searchOption) {
            // Short Name is Id in Product
            case "ByShortName":
                products.add(productRepository.findById(product.getProductShortName()).orElse(new Product()));
//                products = productRepository.findById(product.getProductShortName()).stream().collect(Collectors.toList());
                break;
            case "ByFullName":
                products = productRepository.findByProductFullName(product.getProductFullName());
                break;
            case "ByShortOrFullName":
                products = productRepository.findByProductShortNameOrProductFullName(product.getProductShortName(), product.getProductFullName());
                break;
            case "ByShortAndFullName":
                products = productRepository.findByProductShortNameAndProductFullName(product.getProductShortName(), product.getProductFullName());
                break;
            default:
                System.out.println("Default option in switch");
        }
//        CounterpartyProduct counterpartyProduct = counterpartyProductRepository.findById(counterpartyProductId).orElse(new CounterpartyProduct());
//        model.addAttribute("counterpartyProduct", counterpartyProduct);
        model.addAttribute("products", products);
        model.addAttribute("headerPros", "Entry(ies) found in the database:");
//        System.out.println(searchOption);
        return "pro/allproducts";
    }
}
