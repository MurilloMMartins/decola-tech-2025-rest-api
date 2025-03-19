package mmartins.murillo.service;

import java.util.List;

import mmartins.murillo.domain.model.Loan;

public interface LoanService {
    
    Loan findById(Long id);

    List<Loan> findByUserId(Long id);
    
    List<Loan> findAll();
    
    Loan create(Loan loan);
}
