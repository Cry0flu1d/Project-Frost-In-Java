package projectfrost.content;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.bullet.*;

public class PFBullets {
    public static
    BulletType
        frostshot,frostflame,frostspike;

    public static void load(){
        frostshot = new BasicBulletType(){{
            buildingDamageMultiplier = 0.01f;
            sprite = "circle-bullet";
            damage = 14f;
            speed = 4f;
            width = 8f;
            height = 8f;
            lifetime = 50f;
            //shootEffect = "none";
            //colorFrom = Color.valueOf("9EF4FF");
            //ColorTo = Color.valueOf("6FE7F7");
            //hitEffect = Fx.hitBulletSmall;
            //despawnEffect = Fx.hitBulletSmall;
            //why i cant use this like json fuck
        }};
        frostflame = new BasicBulletType(){{
            //TODO
        }};
        frostspike = new ShrapnelBulletType(){{
            buildingDamageMultiplier = 0.01f;
            damage = 50f;
            pierce = true;
            serrations = 6;
            speed = 4f;
            width = 12f;
            length = 120f;
            lifetime = 50f;
            fromColor = Color.valueOf("9EF4FF");
            toColor = Color.valueOf("6FE7F7");
            shootEffect = Fx.lightningShoot;
            status = StatusEffects.freezing;
            statusDuration = 60f;
        }};
    }

}