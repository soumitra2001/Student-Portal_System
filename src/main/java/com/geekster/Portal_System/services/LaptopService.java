package com.geekster.Portal_System.services;

import com.geekster.Portal_System.models.Laptop;
import com.geekster.Portal_System.repositories.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepo laptopRepo;
    public Laptop getLaptopByName(String laptopName) {
        return laptopRepo.findByLaptopName(laptopName);
    }

    public void updateLaptopInfo(Laptop laptop) {
        laptopRepo.save(laptop);
    }

    public String postLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
        return "Laptop added successfully!!";
    }

    public List<Laptop> getAllLaptop() {
        return laptopRepo.findAll();
    }

    public String deleteLaptop(Long id) {
        laptopRepo.deleteById(id);
        return "Laptop removed successfully!!";
    }
}
