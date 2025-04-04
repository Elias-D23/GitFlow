package com.taskzen.controllers;

import com.taskzen.models.Contact;
import com.taskzen.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;


    @GetMapping("/")
    public String index(ModelMap model) {
        List<Contact> contacts = contactService.listContacts();
        contacts.forEach(contact -> logger.info(contact.toString()));
        model.put("contacts", contacts);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String createContact(@ModelAttribute("contactForm") Contact contact) {
        logger.info("The contact added = " + contact);
        contactService.addContact(contact);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(value = "id") int id, ModelMap model) {
        Contact contact = contactService.showContactById(id);
        logger.info("This is the contact" + contact);
        model.put("contact", contact);
        return "edit";
    }

    @PostMapping("/edit")
    public String editContact(@ModelAttribute("contact") Contact contact) {
        logger.info("The contact updated = " + contact);
        contactService.addContact(contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable(value = "id") int id, ModelMap model) {
        Contact contact = contactService.showContactById(id);
        contactService.deleteContact(contact);
        logger.info("The contact deleted = " + contact);
        return "redirect:/";
    }


}