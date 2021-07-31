package com.platzi.makert.persistence.crud;

import com.platzi.makert.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);
}
