package com.example.contac.service;

import com.example.contac.dto.ContactDto;
import com.example.contac.repository.ContactRepository;
import com.example.contac.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact create(ContactDto dto) {
        Contact result = new Contact();
        result.setName(dto.getName());
        result.setSurname(dto.getSurname());
        result.setPhoneNumber(dto.getPhoneNumber());
        result.setEmail(dto.getEmail());
        contactRepository.save(result);
        return result;
    }

    public Contact getById(Long id) {
        return contactRepository.findById(id).orElseThrow(null);
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    public Contact updateById(Long id, ContactDto dto) {
        Contact result = contactRepository.findById(id).orElseThrow(null);
        result.setName(dto.getName());
        result.setSurname(dto.getSurname());
        result.setPhoneNumber(dto.getPhoneNumber());
        result.setEmail(dto.getEmail());
        contactRepository.save(result);
        return result;
    }

    public Contact findByNumber(String phoneNumber) {
        return contactRepository.findContactByPhoneNumber(phoneNumber);
    }

}
