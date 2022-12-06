package org.apple.item.service;

import org.apple.item.model.Items;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public Optional<List<Items>> getItemList() {
        List<Items> list = Arrays.asList(
                new Items(UUID.randomUUID().toString(),"mobile",87666),
                new Items(UUID.randomUUID().toString(),"Jeans",2000),
                new Items(UUID.randomUUID().toString(),"Tv",20000));

        return Optional.of(list);
    }
}
