package com.votacao.repository;

import com.votacao.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {


    Optional<Partner> findClientByCpf(String cpf);
}
