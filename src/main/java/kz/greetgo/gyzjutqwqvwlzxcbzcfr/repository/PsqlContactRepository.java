package kz.greetgo.gyzjutqwqvwlzxcbzcfr.repository;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.PsqlContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PsqlContactRepository extends JpaRepository<PsqlContact, UUID> {
    @Query("SELECT c FROM PsqlContact c WHERE c.firstPhoneNumber = :parameter OR c.secondPhoneNumber = :parameter OR CAST(c.id AS string) = :parameter")
    PsqlContact findContactsByParameter(@Param("parameter") String parameter);
}
