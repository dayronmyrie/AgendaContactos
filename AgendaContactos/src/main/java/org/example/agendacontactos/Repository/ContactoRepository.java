package org.example.agendacontactos.Repository;

import org.example.agendacontactos.Entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {  //interectua con la base de datos
}
