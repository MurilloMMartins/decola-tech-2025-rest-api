package mmartins.murillo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import mmartins.murillo.domain.model.Item;
import mmartins.murillo.domain.repository.ItemRepository;
import mmartins.murillo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

}
