package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long>{

}
