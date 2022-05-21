package projectfrost.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class PFItems  {
    public static Item
        frostite;
        //TODO frostanium,

    public static void load() {
        frostite = new Item("frostite", Color.valueOf("9EF4FF")) {{
			hardness = 2;
        }};
    }
    
}