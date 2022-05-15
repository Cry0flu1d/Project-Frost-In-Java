package projectfrost.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class PFItems implements ContentList {
    public static Item
        frostite;
        //frostanium,

    public static void load() {
        frostite = new Item("frostite", Color.valueOf("9EF4FF")) {{
			hardness = 2f;
        }};
    }
    
}