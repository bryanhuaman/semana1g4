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

    @Override
    public UsuariosEntity updateUsuario(Long id, UsuariosEntity request) {
       //Primero valido que exista el usuario
        boolean existe = usuariosRepository.existsById(id);
        if(existe){
            //recupero mi usuario
            Optional usuario = usuariosRepository.findById(id);//Para ya no parsear(en la linea 52) se puede poner Optional<UsuarioEntity>

            //setear datos a actualizar
            //Actualizar
            UsuariosEntity usuariosEntity = usuariosRepository.save(getUpdate((UsuariosEntity) usuario.get(), request));//Parsea el optional a UsuarioEntity

            return usuariosEntity;
        }
        return null;
    }
    private UsuariosEntity getUpdate(UsuariosEntity update, UsuariosEntity request){
        update.setNombres(request.getNombres());
        update.setApellidos(request.getApellidos());
        update.setEstado(request.getEstado());
        return update;
    }


    @Override
    public UsuariosEntity deleteUsuario(Long id) {
        Optional<UsuariosEntity> usuario = usuariosRepository.findById(id);

        if(usuario.isPresent()){
            usuario.get().setEstado(0);
            return usuariosRepository.save(usuario.get());
        }


        return null;
    }
}
