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

import com.ithappens.apiVenda.models.PedidoEstoque;
import com.ithappens.apiVenda.repository.PedidoEstoqueRepository;

@RestController
@RequestMapping(value = "/api")
public class PedidoEstoqueResource {

	@Autowired
	PedidoEstoqueRepository pedidoEstoqueRepository;
	
	/**
	 * Método responsável em trazer todos os objetos em uma lista.
	 * @return
	 */
	@GetMapping("/pedidosEstoque")
	public List<PedidoEstoque> getLista(){
		return pedidoEstoqueRepository.findAll();
	}
	
	/**
	 * Método responsável em trazer um objeto específico atravez de seu ID.
	 * @return
	 */
	@GetMapping("/pedidoEstoque/{id}")
	public PedidoEstoque getId(@PathVariable(value = "id") long id){
		return pedidoEstoqueRepository.findById(id);
	}
	
	/**
	 * Método responsável em fazer a inserção de um novo objeto na base de dados.
	 * @return
	 */
	@PostMapping("/pedidoEstoque")
	public PedidoEstoque salvar(@RequestBody PedidoEstoque pedidoEstoque){
		return pedidoEstoqueRepository.save(pedidoEstoque);
	}
	
	/**
	 * Método responsável em atualizar um objeto específico na base de dados.
	 * @return
	 */
	@PutMapping("/pedidoEstoque")
	public PedidoEstoque atualizar(@RequestBody PedidoEstoque pedidoEstoque){
		return pedidoEstoqueRepository.save(pedidoEstoque);
	}
	
	/**
	 * Método responsável em fazer a inserção de um novo pedidoEstoque na base de dados.
	 * @return
	 */
	@DeleteMapping("/pedidoEstoque")
	public void deletar(@RequestBody PedidoEstoque pedidoEstoque){
		pedidoEstoqueRepository.delete(pedidoEstoque);
	}
}
