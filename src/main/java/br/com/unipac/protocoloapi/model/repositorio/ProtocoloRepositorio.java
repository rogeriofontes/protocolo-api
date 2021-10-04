package br.com.unipac.protocoloapi.model.repositorio;

import br.com.unipac.protocoloapi.model.domain.Protocolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocoloRepositorio extends JpaRepository<Protocolo, Long> {
}
