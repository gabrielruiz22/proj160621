package br.com.service;


import br.com.model.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rabbit.EstoqueProducer;
import br.com.repository.EstoqueRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private EstoqueProducer estoqueProducer;

    public void sendEstoqueRabbit(Estoque estoque){
        estoqueProducer.send(estoque);
    }

    public List<Estoque> findAll(){
        return estoqueRepository.findAll();
    }

    public void save(Estoque estoque){
        estoqueRepository.save(estoque);
    }

    public Optional<Estoque> findById(String id){
        return estoqueRepository.findById(id);
    }

    public void delete(String id){
        estoqueRepository.deleteById(id);
    }

    public void deleteAll(){
        estoqueRepository.deleteAll();
    }

}
