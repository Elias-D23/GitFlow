package com.taskzen.services;

import com.taskzen.models.Contact;
import com.taskzen.repositories.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {

    @Autowired
    private IContactRepository contactRepository;

    @Override
    public List<Contact> listContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact showContactById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
}
