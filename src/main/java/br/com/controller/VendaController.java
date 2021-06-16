package br.com.controller;

import br.com.constant.Constant;
import br.com.model.Estoque;
import br.com.model.Produto;
import br.com.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import br.com.service.EstoqueService;
import br.com.service.ProdutoService;
import br.com.service.VendaService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;


    @PostMapping(Constant.API_VENDA)
    public void save(@RequestBody Venda venda, Estoque estoque){
        vendaService.sendVendaRabbit(venda);
    }

    @GetMapping(Constant.API_VENDA)
    public List<Venda> findAll(){
        return vendaService.findAll();
    }

    @PutMapping(Constant.API_VENDA)
    public void update (@RequestBody Venda venda){
        vendaService.save(venda);
    }

    @DeleteMapping(Constant.API_VENDA + "/{id}")
    public void delete(@PathVariable("id") String id){
        vendaService.delete(id);
    }

    @GetMapping(Constant.API_VENDA + "/{id}")
    @Cacheable("venda")
    public Optional<Venda> findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return vendaService.findById(id);
    }
}
