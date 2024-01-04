package com.company.contactos.contactos.service;

import com.company.contactos.contactos.model.Contacto;

import java.util.List;

public interface IContactoService {
public List<Contacto>listarContactos();
public Contacto buscarContactoById(Integer idContacto);
public void guardarContacto(Contacto  contacto);
public void eliminarContacto(Contacto contacto);



}
