package org.apple.item.controller;

import org.apple.item.model.Items;
import org.apple.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Items>> getItems() {
        return itemService.getItemList().map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }


}
