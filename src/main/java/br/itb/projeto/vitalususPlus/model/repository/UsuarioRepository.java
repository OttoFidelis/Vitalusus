package br.itb.projeto.vitalususPlus.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.vitalususPlus.model.entity.Usuario;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
    Usuario findByEmail(String email);
    Usuario findByChaveSeguranca(UUID chaveSeguranca);
}
