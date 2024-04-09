package com.codigo.miprimeraapig4.service;

import com.codigo.miprimeraapig4.entity.UsuariosEntity;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {

    UsuariosEntity crearUsuario(UsuariosEntity usuariosEntity);

    List<UsuariosEntity> getAllUsuarios();

    UsuariosEntity findById(Integer usuarioId);
}
