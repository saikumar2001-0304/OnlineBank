package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Transaction;

@Repository
public interface TranscationRepository extends JpaRepository<Transaction,Long>{

}
