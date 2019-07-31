package com.example.invoice.Controller;/*package com.example.invoice.Controller;*/
/*import Model.Invoice*/
import com.example.invoice.Model.Invoice;
import com.example.invoice.data.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    private InvoiceRepository invoicerepo;
    @Autowired
    public InvoiceController(InvoiceRepository invoicerepo){
        this.invoicerepo=invoicerepo;
    }
    @ModelAttribute(name="invoice")
    public Invoice show_invoice() {
        return new Invoice();
    }
    @GetMapping
    public String show_register(Model model){
        Invoice invoice=new Invoice();
        model.addAttribute("invoice",invoice);
        return "invoice";
    }
    @PostMapping
    public String processInvoice(@Valid Invoice invoice, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "invoice";
        }
            invoicerepo.save(invoice);
            return "redirect:/invoicebills";
        }

    }
/*private RegisterRepository registerrepo;

    public RegisterController(RegisterRepository registerrepo){
        this.registerrepo=registerrepo;
    }


    /*@ModelAttribute(name="register")
    public Register register(){
        return  new Register();
    }*/
 /*   @GetMapping
    public String show_register(Model model){
        model.addAttribute("register",new Register());
        return "register";
    }
/*
@GetMapping("/register")
public String showRegister(){
    return "register";
}
*/
/*
    @PostMapping
    public String processRegister(@Valid Register register, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }
        registerrepo.save(register);
        return "redirect:/
        ";
    }
}
*/