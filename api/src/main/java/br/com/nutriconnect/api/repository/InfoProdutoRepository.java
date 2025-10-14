package br.com.nutriconnect.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.nutriconnect.api.domain.InfoProduto;

@Repository
public interface InfoProdutoRepository extends JpaRepository<InfoProduto, Long>{

}
