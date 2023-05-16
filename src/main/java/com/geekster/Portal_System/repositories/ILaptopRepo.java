package com.geekster.Portal_System.repositories;

import com.geekster.Portal_System.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptopRepo extends JpaRepository<Laptop,Long> {

    Laptop findByLaptopName(String laptopName);
}
