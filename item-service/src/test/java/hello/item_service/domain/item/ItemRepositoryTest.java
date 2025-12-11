package hello.item_service.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Item item = new Item("itemA",10000,1);

        //when
        itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(item.getId());

        assertThat(item).isEqualTo(findItem);
    }
    @Test
    void findAll(){
        Item item1 = new Item("itemA",10000,1);
        Item item2 = new Item("itemB",20000,2);

        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> result = itemRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1,item2);

    }
    @Test
    void updateItem(){
        Item item1 = new Item("itemA",10000,1);
        Item savedItem = itemRepository.save(item1);
        Long itemid = savedItem.getId();

        Item updateParam = new Item("itemC",20000,1);

        itemRepository.update(itemid, updateParam);

        Item findItem = itemRepository.findById(itemid);
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());

    }
}
