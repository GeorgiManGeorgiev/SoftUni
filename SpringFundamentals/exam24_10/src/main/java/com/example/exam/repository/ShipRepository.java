package com.example.exam.repository;

import com.example.exam.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query("select s from Ship as s")
    List<Ship> getAllShips();

    Optional<List<Ship>> getShipsByUserId(Long id);

    @Query("select distinct s from Ship s where s.user.id <> ?1")
    Optional<List<Ship>> getShipsOfOtherUsers(Long id);


    Ship getShipById(Long id);
}
