package com.codigo.miprimeraapig4.repository;

import com.codigo.miprimeraapig4.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long> {


}
