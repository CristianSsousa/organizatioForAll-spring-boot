package com.br.csousa.organizationForAll.repositorys;

import com.br.csousa.organizationForAll.models.Local;
import com.br.csousa.organizationForAll.models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    Optional<Object> findByDateAndHour(String date, String hour);

    List<Reserve> findByLocal(Local local);

    Optional<Object> findByDateAndHourAndLocal(String date, String hour, Local local);
}
