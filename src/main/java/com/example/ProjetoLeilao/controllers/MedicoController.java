package com.example.ProjetoLeilao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("Medico")
public class MedicoController {

   @Autowired
    private MedicoRepository medicoRepository;

}
