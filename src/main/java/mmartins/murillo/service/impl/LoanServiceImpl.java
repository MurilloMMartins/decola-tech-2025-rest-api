package mmartins.murillo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import mmartins.murillo.domain.model.Loan;
import mmartins.murillo.domain.repository.LoanRepository;
import mmartins.murillo.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService{
    
    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan findById(Long id) {
        return loanRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Loan> findByUserId(Long id) {
        return loanRepository.findByUserId(id);
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan create(Loan loan) {
        return loanRepository.save(loan);
    }

}
