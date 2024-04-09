package com.codigo.miprimeraapig4.service.impl;

import com.codigo.miprimeraapig4.entity.UsuariosEntity;
import com.codigo.miprimeraapig4.repository.UsuariosRepository;
import com.codigo.miprimeraapig4.service.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuariosServiceImpl2 implements UsuariosService {


    UsuariosRepository usuariosRepository;

    @Override
    public UsuariosEntity crearUsuario(UsuariosEntity usuariosEntity) {
        return null;
    }

    @Override
    public List<UsuariosEntity> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public UsuariosEntity findById(Integer usuarioId) {
        return null;
    }

    @Override
    public List<UsuariosEntity> findByName(String nombre) {
        return null;
    }


}
