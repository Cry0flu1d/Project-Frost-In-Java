package projectfrost.content;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.type.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.*;






public class PFBlocks {

    public static Block
        //wall
        frostiteWall , largeFrostiteWall,
        //turret

        //factory
        waterCrystalizer,
        //distribution
        frostiteConveyor,frostiteStackConveyor,plastRouter,
        //power
        cryoTransmitter,
        meltingGenerator,
        differentialBattery,largeDifferentialBattery,
        //production
        icyDrill,
        //effect

        //logic

        //enviroment

        //superweapons
        Solarfall,Frostnova,Astigmatism;
    public static void load(){
        //region walls
        frostiteWall = new Wall("frostite-wall"){{
            size = 1;
            health = 460;
            insulated = false;
            absorbLasers = true;
            flashHit = true;
            requirements(Category.defense, with(PFItems.frostite,6));

        }};
        largeFrostiteWall = new Wall("large-frostite-wall"){{
            size = 2;
            health = 460*4;
            insulated = false;
            absorbLasers = true;
            flashHit = true;
            requirements(Category.defense, with(PFItems.frostite,24));

        }};
        //endregion walls
        //region production
        waterCrystalizer = new GenericCrafter("water-crystalizer"){{
            size = 2;
            health = 400;
            hasPower = hasItems = hasLiquids = true;
            craftTime = 90f;
            itemCapacity = 12;
            craftEffect = Fx.pulverizeMedium;
            updateEffect = Fx.smeltsmoke;
            updateEffectChance = 0.05f;

            consumePower(1.5f);
            consumeItem(Items.metaglass, 2);
            consumeLiquid(Liquids.water, 0.4f);
            outputItem = new ItemStack(PFItems.frostite, 3);
            requirements(Category.crafting, with(Items.lead,50 ,Items.silicon,30 ,Items.titanium,50));

        }};
        //TODO a large factory
        //endregion production
        //region distribution
            plastRouter = new StackRouter("plast-router"){{
            requirements(Category.distribution, with(Items.plastanium, 5, Items.silicon, 2, Items.graphite, 2));
            health = 130;
            speed = 4f / 60f;;
            baseEfficiency = 1f;
            underBullets = true;
            solid = false;
        }};
        frostiteConveyor = new Conveyor("frostite-conveyor"){{
                requirements(Category.distribution, with(PFItems.frostite, 1, Items.metaglass, 1));
                health = 60;
                speed = 0.1f;
                displayedSpeed = 12.5f;
        }};
        frostiteStackConveyor = new StackConveyor("frostite-stack-conveyor"){{
            requirements(Category.distribution, with(PFItems.frostite, 1, Items.metaglass, 1, Items.silicon, 1));
            health = 60;
            speed = 3.5f / 60f;
            itemCapacity = 8;
        }};
        //endregion distribution
        //region power
        cryoTransmitter = new PowerNode("cryo-transmitter"){{
            requirements(Category.power, with(Items.titanium, 2, Items.silicon, 2, PFItems.frostite,1));
            health = 100;
            maxNodes = 6;
            laserRange = 9.5f;
            laserColor1 = Color.valueOf("6FE7F7");
            laserColor2 = Color.valueOf("9EF4FF");
        }};
        meltingGenerator = new ConsumeGenerator("melting-generator"){{
            size = 3;
            liquidCapacity = 400f;
            itemDuration = 240f;
            consumeItem(PFItems.frostite,  2);
            consumeLiquid(Liquids.slag, 0.4f);
            hasItems = hasLiquids = true;
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());

        }};
        
        differentialBattery = new Battery("differential-battery"){{
            requirements(Category.power, with( Items.lead, 20,Items.silicon, 6, PFItems.frostite, 6));
            fullLightColor = Color.valueOf("3EE1F0FF");
            emptyLightColor = Color.valueOf("CCEDF0FF");
            consumePowerBuffered(6000f);
            baseExplosiveness = 0.25f;
            health = 200;
        }};
        largeDifferentialBattery = new Battery("large-differential-battery"){{
            size = 3 ;
            requirements(Category.power, with( Items.lead, 100,Items.silicon, 50,Items.titanium, 30, PFItems.frostite, 30));
            fullLightColor = Color.valueOf("3EE1F0FF");
            emptyLightColor = Color.valueOf("CCEDF0FF");
            consumePowerBuffered(64000f);
            baseExplosiveness = 2f;
            health = 1000;
        }};
        //endregion power
        //region production
        icyDrill = new Drill("icy-drill"){{
            requirements(Category.production, with(Items.graphite, 10, Items.metaglass, 6 ,PFItems.frostite, 12));
            tier = 4;
            drillTime = 300f;
            size = 2;
            rotateSpeed = 300f;
            drawRim = hasLiquids = true;
            itemCapacity = 12;
            warmupSpeed = 0.03f;
            heatColor = Color.valueOf("9EF4FFFF");
            liquidCapacity = 20;
            consumeLiquid(Liquids.water, 0.075f).boost();
            updateEffect = new ParticleEffect(){{
                particles = 6;
                lifetime =  30f;
                length = 50f;
                cone = -360;
                strokeFrom = 1;
                lenFrom = 5;
                lenTo = 2;
                colorFrom = Color.valueOf("6FE7F7FF");
                colorTo = Color.valueOf("9EF4FFFF");
            }};
            updateEffectChance = 0.15f;


        }};
        



    
}

}