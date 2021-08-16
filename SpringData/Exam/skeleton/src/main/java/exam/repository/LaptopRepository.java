package exam.repository;

import exam.model.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    Optional<Laptop> getOneByMacAddress(String macAddress);
@Query( "select l from Laptop l ORDER BY l.cpuSpeed desc ,l.ram DESC ,l.storage desc , l.macAddress")
    Set<Laptop> exportLaptops();
}
