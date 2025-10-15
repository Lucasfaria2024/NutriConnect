package br.com.nutriconnect.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nutriconnect.api.domain.Consulta;
import java.util.List;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
    List<Consulta> findByPacienteId (Long pacienteId);

}
