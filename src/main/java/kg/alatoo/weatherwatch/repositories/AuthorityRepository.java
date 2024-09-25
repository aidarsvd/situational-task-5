package kg.alatoo.weatherwatch.repositories;

import kg.alatoo.weatherwatch.entities.UserAuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<UserAuthorityEntity, Long> {

    List<UserAuthorityEntity> findAllByNameIn(Collection<String> name);

    Optional<UserAuthorityEntity> findByName(String name);

}
