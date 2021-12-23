package com.example.ProjetoLeilao.controllers;

import com.example.ProjetoLeilao.Mensagem;
import com.example.ProjetoLeilao.business.VendedorBiz;
import com.example.ProjetoLeilao.entities.Vendedor;
import com.example.ProjetoLeilao.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping()
    public List<Vendedor> listar() {
        List<Vendedor> lista = vendedorRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("{id}")
    public Vendedor buscar(@PathVariable int id) {
        Vendedor vendedor = vendedorRepository.findById(id).get();
        return vendedor;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Vendedor vendedor) {
        VendedorBiz vendedorBiz = new VendedorBiz(vendedor, vendedorRepository);
        Mensagem msg = new Mensagem();

        if(vendedorBiz.isValid()) {
            vendedor.setIdVendedor(0);
            vendedor.setAtivo(true);
            vendedorRepository.save(vendedor);
            vendedorRepository.flush();
            msg.setMensagem("Registro inserido.");
        } else {
            msg.setErros(vendedorBiz.getErros());
            msg.setMensagem("Erro ao incluir funciario: ");
        }

        return msg;
    }

    @PutMapping
    public Mensagem alterar(@RequestBody Vendedor vendedor) {
        vendedorRepository.save(vendedor);
        vendedorRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro alterado.");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar(@RequestBody Vendedor medico) {
        Vendedor excluir = vendedorRepository.findById(medico.getIdVendedor()).get();
        excluir.setAtivo(false);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro excluido.");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id) {
        Vendedor excluir = vendedorRepository.findById(id).get();
        excluir.setAtivo(false);
        vendedorRepository.save(excluir);
        vendedorRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Registro excluido.");
        return msg;
    }
}
