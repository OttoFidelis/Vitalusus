package br.itb.projeto.vitalususPlus.model.repository;

import br.itb.projeto.vitalususPlus.model.entity.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvolucaoRepository extends JpaRepository<Evolucao, Long> {
}
