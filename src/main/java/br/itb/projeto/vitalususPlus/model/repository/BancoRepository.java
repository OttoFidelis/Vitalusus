package br.itb.projeto.vitalususPlus.model.repository;

import br.itb.projeto.vitalususPlus.model.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
}
