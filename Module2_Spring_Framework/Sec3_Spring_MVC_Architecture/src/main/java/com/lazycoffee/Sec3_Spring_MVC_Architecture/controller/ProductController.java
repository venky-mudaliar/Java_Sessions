package com.lazycoffee.Sec3_Spring_MVC_Architecture.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.lazycoffee.Sec3_Spring_MVC_Architecture.model.Product;
import com.lazycoffee.Sec3_Spring_MVC_Architecture.utils.ProductData;
@Controller
public class ProductController {
	
	// Get a single product by ID
    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        // Retrieve product data using the simulated dataset
        Product product = ProductData.getProductById(id);

        if (product != null) {
            model.addAttribute("product", product);
            return "product-details";
        } else {
            return "error";  // Handle case where product is not found
        }
    }

    // Get the list of all products
    @GetMapping("/products")
    public ModelAndView getAllProducts(Model model) {
        // Retrieve the list of all products
        List<Product> products = ProductData.getAllProducts();

        // Add the list of products to the model
        model.addAttribute("products", products);
        
        // Create a ModelAndView object
        ModelAndView mav = new ModelAndView("product-list");
        mav.addObject("products", products);


        // Return the view name for the product list
        return mav;
    }
}
