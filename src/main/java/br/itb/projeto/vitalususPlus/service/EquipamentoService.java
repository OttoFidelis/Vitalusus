package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Equipamento;
import br.itb.projeto.vitalususPlus.model.entity.Equipamento;
import br.itb.projeto.vitalususPlus.model.entity.Patrocinador;
import br.itb.projeto.vitalususPlus.model.repository.EquipamentoRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {
    
    private EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Equipamento> findAll(){
        List<Equipamento> listaEquipamento = equipamentoRepository.findAll();
        return listaEquipamento;
    }
    public Equipamento findById(long id) {
        Optional<Equipamento> equipamento = this.equipamentoRepository.findById(id);
        return equipamento.orElseThrow(() -> new RuntimeException(
                "Aluno não encontrado"
        ));
    }
    public Equipamento save(Equipamento equipamento){
        equipamento.setId(null);
        equipamento.setStatusEquipamento("ATIVO");
			return equipamentoRepository.save(equipamento);
    }
    public List<Equipamento> findAllByPatrocinador(Patrocinador patrocinador){
        return equipamentoRepository.findAllByPatrocinador(patrocinador);
    }
    public void deletar(long id){
        Optional<Equipamento> equipamento= equipamentoRepository.findById(id);
        if(equipamento.isPresent()){
            Equipamento _equipamento = equipamento.get();
            equipamentoRepository.delete(_equipamento);
        }
        throw new RuntimeException("Não foi possível encontrar este equipamento");
    }
    public Equipamento update(long id, Equipamento equipamento){
        Optional<Equipamento> _equipamento= equipamentoRepository.findById(id);
        if(_equipamento.isPresent()){
            Equipamento equipamentoUpdatado = _equipamento.get();
            equipamentoUpdatado.setNome(equipamento.getNome());
            equipamentoUpdatado.setLink(equipamento.getLink());
            equipamentoUpdatado.setStatusEquipamento("ATIVO");
            return equipamentoRepository.save(equipamentoUpdatado);
        }
        throw new RuntimeException("Não foi possível encontrar este equipamento");
    }
}
