package com.codigo.miprimeraapig4.service.impl;

import com.codigo.miprimeraapig4.entity.UsuariosEntity;
import com.codigo.miprimeraapig4.repository.UsuariosRepository;
import com.codigo.miprimeraapig4.service.UsuariosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Convierte en un bean a UsuariosService
public class UsuariosServiceImpl implements UsuariosService {


    private final UsuariosRepository usuariosRepository;

    //Inyecccion por construcctor
    public UsuariosServiceImpl(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UsuariosEntity crearUsuario(UsuariosEntity usuariosEntity) {
        return usuariosRepository.save(usuariosEntity);
    }

    @Override
    public List<UsuariosEntity> getAllUsuarios() {
        return null;
    }

    @Override
    public UsuariosEntity findById(Integer usuarioId) {
        return usuariosRepository.findById(Long.valueOf(usuarioId)).get();
    }

    @Override
    public List<UsuariosEntity> findByName(String nombre) {
        return usuariosRepository.findByNombres(nombre);
    }
}
