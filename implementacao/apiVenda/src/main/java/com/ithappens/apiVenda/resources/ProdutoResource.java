package com.ithappens.apiVenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ithappens.apiVenda.models.Produto;
import com.ithappens.apiVenda.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	/**
	 * Método responsável em trazer todos os objetos em uma lista.
	 * @return
	 */
	@GetMapping("/produtos")
	public List<Produto> getLista(){
		return produtoRepository.findAll();
	}
	
	/**
	 * Método responsável em trazer um objeto específico atravez de seu ID.
	 * @return
	 */
	@GetMapping("/produto/{id}")
	public Produto getId(@PathVariable(value = "id") long id){
		return produtoRepository.findById(id);
	}
	
	/**
	 * Método responsável em fazer a inserção de um novo objeto na base de dados.
	 * @return
	 */
	@PostMapping("/produto")
	public Produto salvar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	/**
	 * Método responsável em atualizar um objeto específico na base de dados.
	 * @return
	 */
	@PutMapping("/produto")
	public Produto atualizar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	/**
	 * Método responsável em fazer a inserção de um novo produto na base de dados.
	 * @return
	 */
	@DeleteMapping("/produto")
	public void deletar(@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
}
