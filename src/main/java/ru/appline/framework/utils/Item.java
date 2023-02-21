package ru.appline.framework.utils;

import lombok.Data;
/** class Item для предмета */
@Data
public class Item {
    private static Item item;
    public static Item getProducts() {
        if (item == null) {
            item = new Item();
        }
        return item;
    }

    private String name;
    private String price;
}
