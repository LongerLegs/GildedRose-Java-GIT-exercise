package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.SwitchItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchItemTest {

    private Item[] items = new Item[] {new SwitchItem("+5 Dexterity Vest", 10, 20)};
    private GildedRose app = new GildedRose(items);

    @Test
    void SellingGroterDanNul() {
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 21);
    }

    @Test
    void SellinKleinerDanNul() {
        app.items[0].sellIn = -1;
        app.items[0].quality = 20;
        app.calculateNextDay();
        assert(app.items[0].sellIn == -2);
        assert(app.items[0].quality == 19);

    }

    @Test
    void SellinGrooter50() {
        app.items[0].sellIn = 10;
        app.items[0].quality = 50;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 50);

    }

}

