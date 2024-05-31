package org.example.agendacontactos.Service;

import org.example.agendacontactos.Entity.Contacto;

import java.util.List;

public interface IContactoService {
    public List<Contacto> listarContactos();
    public Contacto buscarContactoPorID(Integer idContacto);
    public void guardarContacto(Contacto contacto);
    public void eliminarContacto(Contacto contacto);
}
