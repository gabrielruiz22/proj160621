package br.com.controller;

import br.com.constant.Constant;
import br.com.model.Estoque;
import br.com.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import br.com.service.EstoqueService;
import br.com.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(Constant.API_ESTOQUE)
    public void save(@RequestBody Estoque estoque){
        estoqueService.sendEstoqueRabbit(estoque);
    }

    @GetMapping(Constant.API_ESTOQUE)
    public List<Estoque> findAll(){
        return estoqueService.findAll();
    }

    @PutMapping(Constant.API_ESTOQUE)
    public void update (@RequestBody Estoque estoque){
        estoqueService.save(estoque);
    }

    @DeleteMapping(Constant.API_ESTOQUE + "/{id}")
    public void delete(@PathVariable("id") String id){
        estoqueService.delete(id);
    }

    @GetMapping(Constant.API_ESTOQUE + "/{id}")
    @Cacheable("estoque")
    public Optional<Estoque> findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return estoqueService.findById(id);
    }
}
