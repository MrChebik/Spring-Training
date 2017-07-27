package ru.mrchebik.contacts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mrchebik.contacts.model.Contact;
import ru.mrchebik.contacts.repository.ContactRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by mrchebik on 15.03.17.
 */
@Controller
@RequestMapping("/")
public class ContactController {
    private final ContactRepository repository;

    @Autowired
    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Contact> contacts = repository.findAll();
        model.put("contacts", contacts);

        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact) {
        repository.save(contact);

        return "redirect:/";
    }
}
