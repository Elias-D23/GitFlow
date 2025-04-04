package com.taskzen.services;

import com.taskzen.models.Contact;

import java.util.List;

public interface IContactService {

    List<Contact> listContacts();

    public Contact showContactById(Integer id);

    public void addContact(Contact contact);

    public void deleteContact(Contact contact);
}
