package br.com.nutriconnect.api.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Consulta {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate dataConsulta;
    private String anotacoes;

    @ManyToOne
    @JoinColumn (name = "paciente_id")
    private Paciente paciente;
    
}
