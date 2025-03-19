package mmartins.murillo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mmartins.murillo.domain.model.Loan;
import mmartins.murillo.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Loan> findById(@PathVariable Long id) {
        var loan = loanService.findById(id);
        return ResponseEntity.ok(loan);
    }
    
    @GetMapping("/search/{id}")
    public ResponseEntity<List<Loan>> findByUserId(@PathVariable Long id) {
        List<Loan> loans = loanService.findByUserId(id);
        return ResponseEntity.ok(loans);
    }
    
    @GetMapping
    public ResponseEntity<List<Loan>> findAll() {
        List<Loan> loans = loanService.findAll();
        return ResponseEntity.ok(loans);
    }
    
    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody Loan loan) {
        var loanCreated = loanService.create(loan);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(loanCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(loanCreated);
    }
    
}
