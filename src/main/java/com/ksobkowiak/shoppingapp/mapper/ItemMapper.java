package com.ksobkowiak.shoppingapp.mapper;

import com.ksobkowiak.shoppingapp.model.Item;
import com.ksobkowiak.shoppingapp.dto.ItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="content", source="entity.content"),
    })
    ItemDTO itemToItemDTO(Item entity);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="content", source="dto.content"),
    })
    Item itemDTOToItem(ItemDTO dto);

    List<ItemDTO> map(Iterable<Item> items);
}
