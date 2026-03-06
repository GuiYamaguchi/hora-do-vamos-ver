package com.yamaguchi.milagre.controllers;

import com.yamaguchi.milagre.models.MilagreModel;
import com.yamaguchi.milagre.services.MilagreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/milagres")
public class MilagreController {

    @Autowired
    private MilagreService milagreService;

    @PostMapping
    public MilagreModel criar(@RequestBody MilagreModel milagreModel){
        return milagreService.criar(milagreModel);
    }

    @GetMapping
    public List<MilagreModel> milagreModelList(){
        return  milagreService.milagreModelList();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        milagreService.deletar(id);
    }

    @PutMapping("/{id}")
    public MilagreModel atualizar(@PathVariable Long id,@RequestBody MilagreModel milagreModel){
        return milagreService.atualizar(id, milagreModel);
    }

}
