package com.example.prova.controller;

import com.example.prova.model.Produto;
import com.example.prova.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Produto consultarProdutoPorId(@PathVariable Integer id) {
        return produtoService.consultarProdutoPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Integer id, @RequestBody Produto detalhesProduto) {
        return produtoService.atualizarProduto(id, detalhesProduto);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Integer id) {
        produtoService.excluirProduto(id);
    }
}
