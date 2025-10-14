package br.com.nutriconnect.api.controller;

import br.com.nutriconnect.api.domain.Paciente;
import br.com.nutriconnect.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Endpoint para LISTAR TODOS os pacientes
    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    // Endpoint para BUSCAR UM paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            return ResponseEntity.ok(pacienteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para CRIAR um novo paciente
    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente novoPaciente) {
        Paciente pacienteSalvo = pacienteRepository.save(novoPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }

    // Endpoint para ATUALIZAR um paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente dadosPaciente) {
        return pacienteRepository.findById(id)
                .map(pacienteExistente -> {
                    pacienteExistente.setNome(dadosPaciente.getNome());
                    pacienteExistente.setEmail(dadosPaciente.getEmail());
                    Paciente pacienteAtualizado = pacienteRepository.save(pacienteExistente);
                    return ResponseEntity.ok(pacienteAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para DELETAR um paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}