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

import mmartins.murillo.domain.model.Item;
import mmartins.murillo.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable Long id) {
        var item = itemService.findById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Item>> findByName(@PathVariable String name) {
        List<Item> items = itemService.findByName(name);
        return ResponseEntity.ok(items);
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        var itemCreated = itemService.create(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(itemCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(itemCreated);
    }

}
