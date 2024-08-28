package com.br.csousa.organizationForAll.repositorys;

import com.br.csousa.organizationForAll.models.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}
