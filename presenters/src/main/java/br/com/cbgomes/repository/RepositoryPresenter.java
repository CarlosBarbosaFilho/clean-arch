package br.com.cbgomes.repository;

import br.com.cbgomes.domain.EntityPersistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPresenter extends JpaRepository<EntityPersistent, Long> {
}
