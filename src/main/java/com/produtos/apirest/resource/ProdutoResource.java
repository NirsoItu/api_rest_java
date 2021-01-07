package com.produtos.apirest.resource;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Criando Swagger da API localhost:8080/swagger-ui.html
@Api(value="API Rest Produtos")
@CrossOrigin(origins = "*")

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value= "Retorna uma lista de produtos")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value= "Retorna um produto")
    public Produto buscarProdutoPorId(@PathVariable(value = "id")long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value= "Salva um produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value= "Deleta um produto pelo id")
    public void deletarProdutoPorId(@PathVariable(value = "id")long id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/produto")
    @ApiOperation(value= "Atualiza um produto")
    public Produto editarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
