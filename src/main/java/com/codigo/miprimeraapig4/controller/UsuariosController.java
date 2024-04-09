package com.codigo.miprimeraapig4.controller;

import com.codigo.miprimeraapig4.entity.UsuariosEntity;
import com.codigo.miprimeraapig4.service.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/g4")
//@AllArgsConstructor //Para hacer el construcctor de UsuariosService(Cuando no se usa el Autowired)
public class UsuariosController {

    //Inyeccion de dependencia(No se instancia, solo se define una variable para usarla, lo que se inyecta tiene que ser un bean)
    //Inyeccion por construcctor -> @AllArgsConstructor, se usa "private final" -> metodo antiguo
    //private final UsuariosService usuariosService;

    //Se usa para definir que con que implementacion (En caso exista mas de una implementacion de ususarios service) debe trabajar esa inyeccion de usuariosService
    //Otra forma de inyeccion de dependecias
    @Qualifier("usuariosServiceImpl")//El nombre de la implementacion comienza en minuscula
    @Autowired
    private UsuariosService usuariosService;


    @Qualifier("usuariosServiceImpl2")
    @Autowired
    private UsuariosService usuariosService2;



    @PostMapping("/crearusuario")
    public ResponseEntity<UsuariosEntity> crear(@RequestBody UsuariosEntity entity){
        UsuariosEntity usuariosEntity = usuariosService.crearUsuario(entity);
        return ResponseEntity.ok(usuariosEntity);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<UsuariosEntity>> getAll(){
        List<UsuariosEntity> usuariosEntity = usuariosService2.getAllUsuarios();
        return ResponseEntity.ok(usuariosEntity);
    }
    @GetMapping("/buscarusuario/{id}")
    public ResponseEntity<UsuariosEntity> buscarxId(@PathVariable Integer id) {
        UsuariosEntity usuariosEntity = usuariosService.findById(id);
        return ResponseEntity.ok(usuariosEntity);
    }

    //Yo COMO USUARIO, REQUIERO UN EDPOINT QUE ME DEVUELVA LA
    // LISTA DE USUARIOS QUE EXISTAN POR UN NOMBRE, PARA PODER IDENTIFICAR A LOS USUARIOS MEDIANTE SU NOMBRE.
    @GetMapping("/listanombre")
    public ResponseEntity<List<UsuariosEntity>> buscarPorNombre(@RequestParam String nombres) {
        List<UsuariosEntity> usuariosEntity = usuariosService.findByName(nombres);
        return ResponseEntity.ok(usuariosEntity);
    }

}
