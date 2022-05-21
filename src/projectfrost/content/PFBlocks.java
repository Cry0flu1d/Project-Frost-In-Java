package projectfrost.content;

import mindustry.world.Block;
import mindustry.content.*;
import mindustry.type.Category;
import mindustry.type.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.production.*;

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
        //region distributions
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
                displayedSpeed = 14.5f;
        }};
        frostiteStackConveyor = new StackConveyor("frostite-stack-conveyor"){{
            requirements(Category.distribution, with(PFItems.frostite, 1, Items.metaglass, 1, Items.silicon, 1));
            health = 60;
            speed = 3f / 60f;
            itemCapacity = 8;
        }};

    
}
}