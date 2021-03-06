package com.ithappens.apiVenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Estoque") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class PedidoEstoqueResource {

	@Autowired
	PedidoEstoqueRepository pedidoEstoqueRepository;
	
	@GetMapping("/pedidosEstoque")
	@ApiOperation(value = "Método responsável em trazer todos os Pedido de Estoques em uma lista.")
	public List<PedidoEstoque> getLista(){
		return pedidoEstoqueRepository.findAll();
	}
	
	@GetMapping("/pedidoEstoque/{id}")
	@ApiOperation(value = "Método responsável em trazer um Pedido de Estoque específico atravez de seu ID.")
	public PedidoEstoque getId(@PathVariable(value = "id") long id){
		return pedidoEstoqueRepository.findById(id);
	}
	
	@PostMapping("/abrirPedidoEstoque")
	@ApiOperation(value = "Método responsável em fazer a abertura de um novo Pedido de Estoque na base de dados.")
	public PedidoEstoque salvar(@RequestBody PedidoEstoque pedidoEstoque){
		return pedidoEstoqueRepository.save(pedidoEstoque);
	}
	
	@PutMapping("/pedidoEstoque")
	@ApiOperation(value = "Método responsável em atualizar um Pedido de Estoque específico na base de dados.")
	public PedidoEstoque atualizar(@RequestBody PedidoEstoque pedidoEstoque){
		return pedidoEstoqueRepository.save(pedidoEstoque);
	}
	
	@DeleteMapping("/pedidoEstoque")
	@ApiOperation(value = "Método responsável em deletar um Pedido de Estoque na base de dados.")
	public void deletar(@RequestBody PedidoEstoque pedidoEstoque){
		pedidoEstoqueRepository.delete(pedidoEstoque);
	}
}
