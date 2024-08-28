package com.br.csousa.organizationForAll.repositorys;

import com.br.csousa.organizationForAll.models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
