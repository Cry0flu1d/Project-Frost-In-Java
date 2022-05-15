package projectfrost.content;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;

public class PFProjectiles implements ContentList{
    public static
    BulletType
        frostshot,frostflame,frostspike;

    public void load(){
        frostshot = new BasicBulletType(){{
            buildingDamageMultiplier = 0.01f;
            sprite = "circle-bullet";
            damage = 14f;
            speed = 4f;
            width = 8f;
            height = 8f;
            lifetime = 50f;
            shootEffect = "none";
            colorFrom = "9EF4FFFF";
            ColorTo = "6FE7F7FF";
            //hitEffect = Fx.hitBulletSmall;
            //despawnEffect = Fx.hitBulletSmall;
        }};
        frostflame = new BasicBulletType(){{
            
        }};
        frostspike = new ShrapnelBulletType(){{
            
        }};
    }

}