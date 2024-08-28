package com.br.csousa.organizationForAll.repositorys;

import com.br.csousa.organizationForAll.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
