package com.ksobkowiak.shoppingapp.mapper;

import com.ksobkowiak.shoppingapp.dto.ShoppingListDTO;
import com.ksobkowiak.shoppingapp.model.ShoppingList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingListMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "name", source = "entity.name"),
            @Mapping(target = "price", source = "entity.price"),
    })
    ShoppingListDTO listToListDTO(ShoppingList entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "name", source = "dto.name"),
            @Mapping(target = "price", source = "dto.price"),
    })
    ShoppingList listDTOToList(ShoppingListDTO dto);

    List<ShoppingListDTO> map(Iterable<ShoppingList> lists);
}
