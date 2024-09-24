package com.example.contac.repository;

import com.example.contac.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public Contact findContactByPhoneNumber(String phoneNumber);

    @Modifying
    @Query("delete from Contact c where c.phoneNumber=:phoneNumber")
    public void deleteByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
