package ru.mrchebik.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrchebik.contacts.model.Contact;

/**
 * Created by mrchebik on 15.03.17.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
