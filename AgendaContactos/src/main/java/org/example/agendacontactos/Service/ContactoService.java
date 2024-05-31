package org.example.agendacontactos.Service;

import org.example.agendacontactos.Entity.Contacto;
import org.example.agendacontactos.Repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactoService implements IContactoService{
    @Autowired
    private ContactoRepository contactoRepository; //el repositorio es el que esta conectado a la base de datos

    @Override
    public List<Contacto> listarContactos() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto buscarContactoPorID(Integer idContacto) {
       Contacto contacto = contactoRepository.findById(idContacto).orElse(null);
       return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        contactoRepository.delete(contacto);

    }
}
