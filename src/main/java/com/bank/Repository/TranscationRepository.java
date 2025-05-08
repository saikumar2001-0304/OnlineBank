package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Transcation;

@Repository
public interface TranscationRepository extends JpaRepository<Transcation,Long>{

}
