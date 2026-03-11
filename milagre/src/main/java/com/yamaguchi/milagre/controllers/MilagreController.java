package com.yamaguchi.milagre.controllers;

import com.yamaguchi.milagre.models.MilagreModel;
import com.yamaguchi.milagre.services.MilagreService;
import jdk.internal.net.http.ResponseTimerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/milagres")
public class MilagreController {

    @Autowired
    private MilagreService milagreService;

    @PostMapping
    public ResponseEntity<MilagreModel> criar(@RequestBody MilagreModel milagreModel){
        MilagreModel requeste = milagreService.criar(milagreModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(milagreModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<MilagreModel>> milagreModelList(){
        List<MilagreModel> requeste = milagreService.findAll();
        return  ResponseEntity.ok().body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        milagreService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MilagreModel> atualizar(@PathVariable Long id,@RequestBody MilagreModel milagreModel){
        MilagreModel requeste = milagreService.atualizar(id, milagreModel);
        return ResponseEntity.ok().body(requeste);
    }

}
