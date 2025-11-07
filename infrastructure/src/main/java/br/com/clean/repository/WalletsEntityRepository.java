package br.com.clean.repository;

import br.com.clean.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletsEntityRepository extends JpaRepository<WalletsEntity, Long> {
}
