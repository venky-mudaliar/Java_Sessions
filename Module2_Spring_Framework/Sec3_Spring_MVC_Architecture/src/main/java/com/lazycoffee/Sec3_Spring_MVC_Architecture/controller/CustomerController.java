package com.lazycoffee.Sec3_Spring_MVC_Architecture.controller;

import com.lazycoffee.Sec3_Spring_MVC_Architecture.model.Customer;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class CustomerController {

    // Display the customer registration form
    @GetMapping("/customers/register")
    public String showForm(Model model) {
        // Create a new Customer object and add it to the model
        model.addAttribute("customer", new Customer());
        return "customer-form";  // Returns the form view
    }

    // Handle form submission with validation
    @PostMapping("/customers")
    public String handleFormSubmission(
            @Valid @ModelAttribute("customer") Customer customer, 
            BindingResult result, 
            RedirectAttributes redirectAttributes) {
        
        // If validation errors exist, redisplay the form with error messages
        if (result.hasErrors()) {
            return "customer-form";
        }

        // Add a flash attribute to pass data across the redirect
        redirectAttributes.addFlashAttribute("customer", customer);

        // Redirect to the success page after form submission
        return "redirect:/customers/success";
    }

    // Display the success page
    @GetMapping("/customers/success")
    public String showSuccessPage() {
        return "registration-success";
    }
}
