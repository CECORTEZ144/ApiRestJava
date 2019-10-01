package ApiFullRest.Dev.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ApiFullRest.Dev.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {}