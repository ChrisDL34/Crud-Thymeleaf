package com.company.contactos.contactos.repository;

import com.company.contactos.contactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IContactoRepostory  extends JpaRepository<Contacto, Integer> {
}
