package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class Item {
    //pk 알려줌   //pk 키 어떻게 생성하는지 알려줌
    @Id         @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name" , length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    //JPA 사용시 기본생성자 필수
    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
