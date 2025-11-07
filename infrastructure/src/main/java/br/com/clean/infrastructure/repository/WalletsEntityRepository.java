package br.com.clean.infrastructure.repository;

import br.com.clean.infrastructure.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletsEntityRepository extends JpaRepository<WalletsEntity, Long> {
}
