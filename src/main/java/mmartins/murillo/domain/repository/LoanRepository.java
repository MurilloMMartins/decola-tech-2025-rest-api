package mmartins.murillo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mmartins.murillo.domain.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
