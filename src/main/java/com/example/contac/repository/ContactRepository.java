package com.example.contac.repository;

import com.example.contac.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public Contact findContactByPhoneNumber(String phoneNumber);
}
