package mmartins.murillo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mmartins.murillo.domain.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    public List<Item> findByName(String name);
}
