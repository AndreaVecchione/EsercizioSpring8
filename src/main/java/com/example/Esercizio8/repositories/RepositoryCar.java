package com.example.Esercizio8.repositories;
import com.example.Esercizio8.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RepositoryCar extends JpaRepository<Car, Long> {

}
