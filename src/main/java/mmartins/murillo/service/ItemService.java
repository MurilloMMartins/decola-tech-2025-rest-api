package mmartins.murillo.service;

import java.util.List;

import mmartins.murillo.domain.model.Item;

public interface ItemService {

    Item findById(Long id);

    List<Item> findByName(String name);

    List<Item> findAll();

    Item create(Item item);

}
