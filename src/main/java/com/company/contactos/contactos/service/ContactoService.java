package com.company.contactos.contactos.service;

import com.company.contactos.contactos.model.Contacto;
import com.company.contactos.contactos.repository.IContactoRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService implements IContactoService{
    @Autowired
    private IContactoRepostory repostory;

    @Override
    public List<Contacto> listarContactos() {
        return repostory.findAll();
    }

    @Override
    public Contacto buscarContactoById(Integer idContacto) {
        return repostory.findById(idContacto).orElse(null);
    }

    @Override
    public void guardarContacto(Contacto contacto) {
    repostory.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
    repostory.delete(contacto);
    }
}
