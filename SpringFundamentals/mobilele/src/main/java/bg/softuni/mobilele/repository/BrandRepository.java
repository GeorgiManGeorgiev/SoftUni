package bg.softuni.mobilele.repository;

import bg.softuni.mobilele.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
