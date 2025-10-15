package br.com.nutriconnect.api.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutriconnect.api.domain.Consulta;
import br.com.nutriconnect.api.domain.Paciente;
import br.com.nutriconnect.api.repository.ConsultaRepository;
import br.com.nutriconnect.api.repository.PacienteRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public ResponseEntity<Consulta> criarConsulta(@RequestBody Consulta novaConsulta) {
        Long pacienteId = novaConsulta.getPaciente().getId();
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(pacienteId);

        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Paciente pacienteExistente = pacienteOptional.get();
        novaConsulta.setPaciente(pacienteExistente);

        Consulta consultaSalva = consultaRepository.save(novaConsulta);

        return ResponseEntity.status(201).body(consultaSalva);
    }

    @GetMapping("paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> buscarConsultasPorPaciente(@PathVariable Long pacienteId) {
        if (!pacienteRepository.existsById(pacienteId)) {
            return ResponseEntity.notFound().build();
        }
        List<Consulta> consultasDoPaciente = consultaRepository.findByPacienteId(pacienteId);
        return ResponseEntity.ok(consultasDoPaciente);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> BuscarConsultaPorId(@PathVariable Long id) {
        return consultaRepository.findById(id)
        .map(consulta -> ResponseEntity.ok(consulta))
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta dadosConsulta){
        return consultaRepository.findById(id)
        .map(consultaExistente -> {
            consultaExistente.setAnotacoes(dadosConsulta.getAnotacoes());
            consultaExistente.setDataConsulta(dadosConsulta.getDataConsulta());
            Consulta consultaAtualizada = consultaRepository.save(consultaExistente);
            return ResponseEntity.ok(consultaAtualizada);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Consulta> deletarConsulta(@PathVariable Long id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
}
