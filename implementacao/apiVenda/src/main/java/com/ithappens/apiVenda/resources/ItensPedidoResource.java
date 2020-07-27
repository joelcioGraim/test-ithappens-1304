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

import com.ithappens.apiVenda.models.ItensPedido;
import com.ithappens.apiVenda.repository.ItensPedidoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Item de Pedido") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class ItensPedidoResource {

	@Autowired
	ItensPedidoRepository itensPedidoRepository;
		
	@GetMapping("/itensPedido")
	@ApiOperation(value = "Método responsável em trazer todos os Itens de Pedido em uma lista.")
	public List<ItensPedido> getLista(){
		return itensPedidoRepository.findAll();
	}
	
	@GetMapping("/itensPedido/{id}")
	@ApiOperation(value = "Método responsável em trazer um Item de Pedido específico atravez de seu ID.")
	public ItensPedido getId(@PathVariable(value = "id") long id){
		return itensPedidoRepository.findById(id);
	}
	
	@PostMapping("/itensPedido")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo Item de Pedido na base de dados.")
	public ItensPedido salvar(@RequestBody ItensPedido itensPedido){
		return itensPedidoRepository.save(itensPedido);
	}
	
	@PutMapping("/itensPedido")
	@ApiOperation(value = "Método responsável em atualizar um Item de Pedido específico na base de dados.")
	public ItensPedido atualizar(@RequestBody ItensPedido itensPedido){
		return itensPedidoRepository.save(itensPedido);
	}
	
	@DeleteMapping("/itensPedido")
	@ApiOperation(value = "Método responsável em deletar um Item de Pedido na base de dados.")
	public void deletar(@RequestBody ItensPedido itensPedido){
		itensPedidoRepository.delete(itensPedido);
	}
}
