package br.com.nutriconnect.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.nutriconnect.api.domain.InfoProduto;
import br.com.nutriconnect.api.repository.InfoProdutoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/infoprodutos")
public class InfoProdutoController {

    @Autowired
    private InfoProdutoRepository infoProdutoRepository;

    @GetMapping
    public List<InfoProduto> listarTodos() {
        return infoProdutoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoProduto> buscarPorId(@PathVariable Long id) {
        Optional<InfoProduto> produtoOptional = infoProdutoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            return ResponseEntity.ok(produtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<InfoProduto> criarInfoProduto(@RequestBody InfoProduto novoInfoProduto) {
        InfoProduto produtoSalvo = infoProdutoRepository.save(novoInfoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfoProduto> atualizarInfoProduto(@PathVariable Long id,
            @RequestBody InfoProduto dadosInfoProduto) {
        Optional<InfoProduto> produtoOptional = infoProdutoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            InfoProduto infoProdutoExistente = produtoOptional.get();

            infoProdutoExistente.setNome(dadosInfoProduto.getNome());
            infoProdutoExistente.setDescricao(dadosInfoProduto.getDescricao());
            infoProdutoExistente.setPreco(dadosInfoProduto.getPreco());

            InfoProduto produtoAtualizado = infoProdutoRepository.save(infoProdutoExistente);
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarInfoProduto(@PathVariable Long id) {
        if (infoProdutoRepository.existsById(id)) {
            infoProdutoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
