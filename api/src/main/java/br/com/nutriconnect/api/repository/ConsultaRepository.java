package br.com.nutriconnect.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nutriconnect.api.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    

}
