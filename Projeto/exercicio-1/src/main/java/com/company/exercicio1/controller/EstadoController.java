package com.company.exercicio1.controller;

import com.company.exercicio1.dto.EstadoDTO;
import com.company.exercicio1.dto.RegiaoDTO;
import com.company.exercicio1.form.AtualizacaoEstadoForm;
import com.company.exercicio1.form.EstadoForm;
import com.company.exercicio1.modelo.Estado;
import com.company.exercicio1.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDTO> cadastrarEstado(@RequestBody @Valid EstadoForm estadoForm, UriComponentsBuilder uriComponentsBuilder){
        Estado estado = estadoForm.converter();
        estadoRepository.save(estado);
        URI uri = uriComponentsBuilder.path("/api/states/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstadoDTO(estado));
    }

    @GetMapping
    public List<EstadoDTO> listarEstados(@RequestParam(required = false) String regiao, @RequestParam(required = false) String ordenacao){
        if (regiao == null){
            if (ordenacao == null){
                List<Estado> estados = estadoRepository.findAll();
                return EstadoDTO.converterEstados(estados);
            }
            Sort ordenar = Sort.by(ordenacao).descending();
            List<Estado> estados = estadoRepository.findAll(ordenar);
            return EstadoDTO.converterEstados(estados);
        }else{
            List<Estado> estados = estadoRepository.findByRegiao(regiao);
            return EstadoDTO.converterEstados(estados);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegiaoDTO> consultarEstado(@PathVariable Long id){
        Optional <Estado> estado = estadoRepository.findById(id);
        if (estado.isPresent()){
            return ResponseEntity.ok(new RegiaoDTO(estado.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstadoDTO> atualizarEstado(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstadoForm atualizacaoEstadoForm){
        Optional <Estado> estado = estadoRepository.findById(id);
        if (estado.isPresent()){
            Estado estadoAtualizado = atualizacaoEstadoForm.atualizarEstado(id, estadoRepository);
            return ResponseEntity.ok(new EstadoDTO(estadoAtualizado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removerEstado(@PathVariable Long id){
        Optional <Estado> estado = estadoRepository.findById(id);
        if (estado.isPresent()){
            estadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
