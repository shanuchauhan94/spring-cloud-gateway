package org.apple.item.service;

import org.apple.item.model.Items;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Optional<List<Items>> getItemList();
}
