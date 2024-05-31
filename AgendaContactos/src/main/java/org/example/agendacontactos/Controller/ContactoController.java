package org.example.agendacontactos.Controller;

import org.example.agendacontactos.Entity.Contacto;
import org.example.agendacontactos.Service.ContactoService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactoController {
    private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);
    @Autowired
    ContactoService contactoService;

    @GetMapping("/")
    public String iniciar(ModelMap model){
        List<Contacto> contactos = contactoService.listarContactos(); //en la pagina de inicio desplega los contactos en la lista
        contactos.forEach((contacto -> logger.info(contacto.toString()))); //imprime cada uno de los contactos
        model.put("contactos", contactos); // el model es la llave que se va a usar en la vista html para acceder al metodo
        return "index";
    }
    @GetMapping("/agregar")
    public String mostrarAgregar(ModelMap modelMap){
        return "agregar";
    }
    @PostMapping("/agregar")
    public String agregarContacto(@ModelAttribute("contactoForm") Contacto contacto){
        logger.info("Contacto a agregar: "+ contacto);
        contactoService.guardarContacto(contacto);
        return "redirect:/"; //redirigimos al controlador el path de inicio
    }
    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id")int idContacto, ModelMap model){
            Contacto contacto = contactoService.buscarContactoPorID(idContacto);
            logger.info("Contacto a editar (mostrar): "+ contacto);
            model.put("contacto", contacto);
            return "editar"; //editar.html
    }
    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto")Contacto contacto){
        logger.info("Contacto a guardar (editar): "+ contacto);
        contactoService.guardarContacto(contacto);
        return "redirect:/";

    }
    @PostMapping("/eliminar")
    public String eliminar(@ModelAttribute("contacto") Contacto contacto){
        contactoService.eliminarContacto(contacto);
        return "redirect:/";
    }
}
