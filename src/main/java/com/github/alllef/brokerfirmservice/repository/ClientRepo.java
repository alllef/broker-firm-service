package com.github.alllef.brokerfirmservice.repository;

import com.github.alllef.brokerfirmservice.entity.person.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {

}
