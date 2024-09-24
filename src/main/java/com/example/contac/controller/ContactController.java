package com.example.contac.controller;

import com.example.contac.dto.ContactDto;
import com.example.contac.service.ContactService;
import com.example.contac.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("create")
    public ResponseEntity<ContactDto> create(@RequestBody ContactDto dto) {
        ContactDto result = new ContactDto();
        result.setName(dto.getName());
        result.setSurname(dto.getSurname());
        result.setPhoneNumber(dto.getPhoneNumber());
        result.setEmail(dto.getEmail());
        contactService.create(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/id/{id}")
    public ResponseEntity<Contact> getById(@PathVariable("id") Long id) {
        Contact contact = contactService.getById(id);
        return ResponseEntity.ok(contact);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> allContact = contactService.getAllContact();
        return ResponseEntity.ok(allContact);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Contact> deleteById(@PathVariable("id") Long id) {
        contactService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateById(@PathVariable("id") Long id, @RequestBody ContactDto dto) {
        Contact result = contactService.updateById(id, dto);
        result.setName(dto.getName());
        result.setSurname(dto.getSurname());
        result.setPhoneNumber(dto.getPhoneNumber());
        result.setEmail(dto.getEmail());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/phone/{phoneNumber}")
    public ResponseEntity<Contact> findByPhoneNumber(@PathVariable String phoneNumber) {
        Contact byNumber = contactService.findByNumber(phoneNumber);
        return ResponseEntity.ok(byNumber);

    }
}
