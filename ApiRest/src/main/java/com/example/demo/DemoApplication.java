package com.example.demo;

import com.rest.dao.CrudUsuario;
import com.rest.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class DemoApplication {

    CrudUsuario dao = new CrudUsuario();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping(value = "/saludo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String saludo(@RequestParam(value = "name", defaultValue = "Alam") String name) {

        return "Curso Java " + name;
    }

    @GetMapping(path = "/mensaje/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String mensaje(@PathVariable String nombre) {
        return "Curso 2022 " + nombre;
    }

    @GetMapping(path = "/suma/{a}/{b}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int suma(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @GetMapping(path = "/getUsuario/{usuario}/{password}/{nombre}/{apellido}/{correo}/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getUsuario(@PathVariable String usuario, @PathVariable String password,
            @PathVariable String nombre, @PathVariable String apellido, @PathVariable String correo,
            @PathVariable String estado) {
        var obj = new Usuario(usuario, password, nombre, apellido, correo, estado);

        return obj;
    }

    @GetMapping(path = "/getAll/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> getAll() {
        List<Usuario> lista = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lista.add(new Usuario("plan1", "987", "Peter", "Pan", "pte@gm.com", "A")
            );
        }
        return lista;
    }

    @PostMapping(path = "/insertar", produces = MediaType.APPLICATION_JSON_VALUE)
    public String insertar(@RequestBody Usuario obj) {
        return obj.toString();
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Usuario obj) {
        var msg = dao.create(obj);
        return msg;
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody Usuario obj) {
        var msg = dao.update(obj);
        return msg;
    }

}
