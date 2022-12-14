package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResources {
    @Autowired
    IProdutoRepository iProdutoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return iProdutoRepository.findAll();
    }
    @GetMapping("/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
        return iProdutoRepository.findById(id);
    }

    @PostMapping("/produto")
    public Produto salvarProduto(@RequestBody @Validated Produto produto){
        return iProdutoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    public void deletarProduto(@RequestBody @Validated Produto produto){
        iProdutoRepository.delete(produto);
    }

    @PutMapping("/produto")
    public Produto atualizarProduto(@RequestBody @Validated Produto produto){
        return iProdutoRepository.save(produto);
    }

}
