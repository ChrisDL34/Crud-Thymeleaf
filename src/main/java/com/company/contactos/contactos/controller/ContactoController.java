package com.company.contactos.contactos.controller;

import com.company.contactos.contactos.model.Contacto;
import com.company.contactos.contactos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactoController {
    @Autowired
    ContactoService contactoService;
@GetMapping("/")
    public String iniciar(ModelMap model){
    List<Contacto> contactos  = contactoService.listarContactos();
    model.put("contactos", contactos);
    return "index";
}
    // esto nos solicita los contactos y nos devuelve todos los contactos que tengamos en la base de datos.
    // aun no podemos visualizarlo porque no hemos organizado el html para imprimir allá pero ya tenemos toda la info, cada cosa que preguntemos
    // ya nos va a devolver todos los usuarios, y nos devuelve cada parte del usuario que solicitemos.
    // podemos solicitar cualquier parte que queramos de cada usuario. solo con ese codigo y para eso es thymeleaf para mostrarlo en el html

@GetMapping("/agregar")
    public String verAgregar(){
        return "agregar";
    }


    @PostMapping("/agregar")
    public String agregarContacto(@ModelAttribute("contactoForm") Contacto contacto ){
    contactoService.guardarContacto(contacto);
    return  "redirect:/ ";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditarContacto(@PathVariable(value="id") int idContacto, ModelMap model){
    Contacto contacto = contactoService.buscarContactoById(idContacto);
    model.put("contacto",contacto);
    return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contactoForm")Contacto contacto) {
    contactoService.guardarContacto(contacto);
        return  "redirect:/ ";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value="id")int idContacto){
    Contacto contacto = new Contacto();
    contacto.setIdContacto(idContacto);
    contactoService.eliminarContacto(contacto);
        return  "redirect:/ ";
    }


}
