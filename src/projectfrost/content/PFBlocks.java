package projectfrost.content;


import arc.graphics.*;
//import arc.struct.Seq;
import mindustry.world.Block;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;
//import multicraft.*;


import static mindustry.type.ItemStack.*;






public class PFBlocks {

    public static Block
        //wall
        frostiteWall , largeFrostiteWall,
        //turret
        autocannon,farlight,ionization,electron,shimmerspark,
        //factory
        waterCrystalizer,frostSynthesizer,

        largeElectricHeater, heatConduit,
        //distribution
        frostiteConveyor,frostiteStackConveyor,plastRouter,
        flareLoadingPad,flareUnloadingPoint,
        //power
        cryoTransmitter,
        meltingGenerator,
        differentialBattery,largeDifferentialBattery,
        //production
        icyDrill,
        //TODO units
        //effect
        coreFrost,
        //logic
        heatproofProccessor,

        //enviroment
        blueIce,blueIceWall,blueIceBoulder,blueIcePanel,
        //ores
        iceShard,
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
        //region turrets
        farlight = new PowerTurret("farlight"){{
            requirements(Category.turret, with(Items.copper, 1100, Items.titanium, 700, Items.plastanium, 300, Items.silicon, 500, Items.surgeAlloy, 200));
            shootType = new LaserBulletType(){{
                length = 480f;
                damage = 550f;
                width = 42f;

                lifetime = 60f;

                lightningSpacing = 80f;
                lightningLength = 6;
                lightningDelay = 1.5f;
                lightningLengthRand = 12;
                lightningDamage = 80;
                lightningAngleRand = 05f;
                largeHit = true;
                lightColor = lightningColor = Pal.lancerLaser.cpy().a(0.4f);
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};

                chargeEffect = PFFx.farlightShot;
                hitEffect = Fx.hitLancer;
                collidesTeam = true;

                sideAngle = 15f;
                sideWidth = 0f;
                sideLength = 0f;
                buildingDamageMultiplier = 0.15f;
            }};
            size = 4;
            reload = 380f;
            shootCone = 2f;
            rotateSpeed = 2.5f;
            targetAir = true;
            range = 420f;
            shootEffect = new MultiEffect(
                Fx.lightningShoot,
                Fx.shootBigSmoke2);
            heatColor = Color.cyan;
            recoil = 6f;
            health = 1880;
            shootSound = Sounds.laserbig;
            chargeSound = Sounds.lasercharge;
            consumePower(750f / 60f);
            coolant = consumeCoolant(0.8f);
            coolantMultiplier = 0.6f;
        }};
        ionization = new PowerTurret("ionization"){{
            requirements(Category.turret, with(Items.copper, 120, Items.titanium, 80, Items.silicon, 100, Items.graphite, 50));
            range = 210f;

            shoot.firstShotDelay = 30f;

            recoil = 1.8f;
            reload = 72f;
            shake = 1.4f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            size = 2;
            scaledHealth = 240;
            consumePower(420f / 60f);
            targetAir = true;
            moveWhileCharging = false;
            shootSound = Sounds.spark;
            shootType = new BasicBulletType(){{
                shoot = new ShootHelix(){{
                    mag = 0.8f;
                    scl = 6f;
                }};
                sprite = "large-orb";
                hittable = false;
                trailEffect = Fx.missileTrail;
                trailInterval = 2.5f;
                trailParam = 2.2f;
                speed = 4f;
                damage = 45f;
                lifetime = 95f;
                width = height = 12f;
                backColor = Color.white;
                frontColor = Pal.lancerLaser;
                shrinkX = shrinkY = 0f;
                trailColor = Color.valueOf("BFD9FF");
                trailLength = 14;
                trailWidth = 2.2f;
                despawnEffect = Fx.none;
                hitEffect = new MultiEffect(Fx.hitLancer,PFFx.hitPlasmaSmall);
                intervalBullet = new LightningBulletType(){{
                    damage = 12;
                    ammoMultiplier = 1f;
                    lightningColor = Pal.lancerLaser;
                    lightningLength = 2;
                    lightningLengthRand = 5;
                    buildingDamageMultiplier = 0.15f;
                    lightningType = new BulletType(0.0001f, 0f){{
                        lifetime = Fx.lightning.lifetime;
                        hitEffect = Fx.hitLancer;
                        despawnEffect = Fx.none;
                        status = StatusEffects.shocked;
                        statusDuration = 20f;
                        hittable = false;
                        lightColor = Color.cyan;
                        buildingDamageMultiplier = 0.15f;
                    }};
                }};

                bulletInterval = 3f;

                lightningColor = Pal.lancerLaser;
                lightningDamage = 12;
                lightning = 4;
                lightningLength = 2;
                lightningLengthRand = 4;
            }};
        coolant = consumeCoolant(0.2f);
        }};
        electron = new PowerTurret("electron"){{
            requirements(Category.turret, with(Items.lead, 80, Items.titanium, 100, Items.silicon, 100, Items.graphite, 60));
            range = 110f;
            shootType = new BasicBulletType(6f,48f){{
                hitSize = 8f;
                lifetime = 24f;
                pierce = true;
                collidesAir = false;
                shootEffect = PFFx.shootPlasmaFlame;
                hitEffect = PFFx.hitPlasmaSmall;
                despawnEffect = Fx.none;
                //status = StatusEffects.burning;
                //another status in progress
                //status = PFStatusEffects.plasmaInferno;
                //statusDuration = 60f * 4;
                keepVelocity = false;
                hittable = false; 
            }};
            size = 2;
            recoil = 0f;
            reload = 5f;
            coolantMultiplier = 1.25f;
            shootCone = 40f;
            targetAir = false;
            health = 680;
            shootSound = Sounds.flame;
            coolant = consumeCoolant(0.18f);
            consumePower(480f / 60f);
        }};
        shimmerspark = new PowerTurret("shimmerspark"){{
            requirements(Category.turret, with(Items.lead, 220, Items.titanium, 150, Items.graphite, 200, Items.silicon, 200, Items.phaseFabric, 100));
            
            shootType = new BasicBulletType(){{
                shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
                    colorTo = Pal.lancerLaser;
                    sizeTo = 22f;
                    lifetime = 10f;
                    strokeFrom = 3f;
                }});
                smokeEffect = Fx.shootSmokeTitan;
                hitColor = Pal.lancerLaser;

                sprite = "missile-large";
                trailEffect = Fx.missileTrail;
                trailInterval = 2.8f;
                trailParam = 4f;
                pierceCap = 4;
                fragOnHit = false;
                speed = 6f;
                damage = 110f;
                lifetime = 72f;
                width = height = 14f;
                backColor = Pal.lancerLaser;
                frontColor = Color.white;
                shrinkX = shrinkY = 0f;
                trailColor = Pal.lancerLaser;
                trailLength = 10;
                trailWidth = 2f;
                despawnEffect = hitEffect = new ExplosionEffect(){{
                    waveColor = Pal.lancerLaser;
                    smokeColor = Color.gray;
                    sparkColor = Color.valueOf("76a9dc");
                    waveStroke = 5f;
                    waveRad = 30f;
                }};

                intervalBullet = new BasicBulletType(3f, 18){{
                    sprite = "missile";
                    width = 12f;
                    hitSize = 5f;
                    height = 12f;
                    pierce = true;
                    pierceCap = 1;
                    lifetime = 45f;
                    hitColor = backColor = trailColor = Pal.lancerLaser;
                    frontColor = Color.white;
                    trailWidth = 1.8f;
                    trailLength = 4;
                    hitEffect = despawnEffect = new WaveEffect(){{
                        colorFrom = colorTo = Pal.lancerLaser;
                        sizeTo = 3f;
                        strokeFrom = 2f;
                        lifetime = 8f;
                    }};
                    homingPower = 0.2f;
                }};

                bulletInterval = 8f;
                intervalRandomSpread = 24f;
                intervalBullets = 4;
                intervalAngle = 60f;
                intervalSpread = 60f;

            }};

            reload = 140f;
            range = 310f;
            size = 3;
            shootCone = 10f;
            recoil = 2.2f;
            scaledHealth = 180;
            rotateSpeed = 2f;
            coolant = consumeCoolant(0.3f);
            consumePower(600f / 60f);
        }};
        //endregion turrets
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
        
            //TODO data adjustments
        /*frostSynthesizer = new GenericCrafter("frost-synthesizer"){{
                size = 3;
                health = 600;
                hasPower = hasItems = hasLiquids = true;
                craftTime = 60f;
                itemCapacity = 20;
               craftEffect = Fx.pulverizeMedium;
               updateEffect = Fx.smeltsmoke;
               updateEffectChance = 0.07f;

                consumePower(4f);
                consumeItem(Items.metaglass, 3);
                consumeLiquid(Liquids.water, 1.2f);
                outputItem = new ItemStack(PFItems.frostite, 5);
                requirements(Category.crafting, with(Items.lead,50 ,Items.silicon,30 ,Items.titanium,50));

        }};*/
        largeElectricHeater = new HeatProducer("large-electric-heater"){{
            requirements(Category.crafting, with(Items.graphite, 300, Items.tungsten, 200, Items.silicon, 200, Items.oxide, 250, Items.carbide, 80));

            researchCostMultiplier = 2f;

            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
            scaledHealth = 80;
            rotateDraw = false;
            size = 5;
            heatOutput = 30f;
            regionRotated1 = 1;
            consumePower(475f / 60f);
        }};
        heatConduit = new HeatConductor("heat-duct"){{
            requirements(Category.crafting, with(Items.oxide,1 , Items.tungsten, 2));
            researchCostMultiplier = 12; 
            size = 1;

            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput(), new DrawHeatInput("-heat"));
            regionRotated1 = 1;
        }};
        /*why im doing vanilla expansion stuff
            just forget it dude*/
        //endregion production
        //region distribution
            plastRouter = new StackRouter("plast-router"){{
            requirements(Category.distribution, with(Items.plastanium, 5, Items.silicon, 2, Items.graphite, 2));
            health = 130;
            speed = 4f / 60f;
            baseEfficiency = 1f;
            underBullets = true;
            solid = false;
        }};
        frostiteConveyor = new Conveyor("frostite-conveyor"){{
                requirements(Category.distribution, with(PFItems.frostite, 1, Items.metaglass, 1));
                health = 60;
                speed = 0.1f;
                displayedSpeed = 12.5f;
                underBullets = true;
        }};
        frostiteStackConveyor = new StackConveyor("frostite-stack-conveyor"){{
            requirements(Category.distribution, with(PFItems.frostite, 1, Items.metaglass, 1, Items.silicon, 1));
            health = 60;
            speed = 3.5f / 60f;
            itemCapacity = 8;
            underBullets = true;
        }};
        //TODO bad name and extremely imba
        /*flareLoadingPad = new UnitCargoLoader("flare-loading-pad"){{
            requirements(Category.distribution, with(Items.lead, 250, Items.silicon, 200, Items.graphite, 150, Items.plastanium, 100));
            size = 2;
            unitType = PFUnits.cargoFlare;
            buildTime = 24f*60f;
            polyStroke = 1.5f;
            polyRadius = 4;
            polySides = 6;
            consumePower(200f / 60f);
            consumeItem(Items.silicon, 60);
            itemCapacity = 120;

        }};
        flareUnloadingPoint = new UnitCargoUnloadPoint("flare-unloading-point"){{
            requirements(Category.distribution, with(Items.silicon, 50, Items.graphite, 80,Items.titanium, 60));
            size = 1;
            itemCapacity = 60;
        }};*/

        //endregion distribution
        //region power
        cryoTransmitter = new PowerNode("cryo-transmitter"){{
            requirements(Category.power, with(Items.titanium, 3, Items.silicon, 4, PFItems.frostite,2));
            health = 100;
            maxNodes = 7;
            laserRange = 17.5f;
            laserColor1 = Color.valueOf("6FE7F7");
            laserColor2 = Color.valueOf("9EF4FF");
        }};
        meltingGenerator = new ConsumeGenerator("melting-generator"){{
            requirements(Category.power, with( Items.lead, 150,Items.titanium, 120, Items.silicon, 100, PFItems.frostite, 100));
            size = 3;
            liquidCapacity = 400f;
            itemDuration = 240f;
            consumeItem(PFItems.frostite,  2);
            consumeLiquid(Liquids.slag, 0.4f);
            outputLiquid = new LiquidStack(Liquids.cryofluid, 1.5f/60f);
            hasItems = hasLiquids = true;
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());
            powerProduction = 16;
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
        //region units   
        //endregion units
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
            //endregion production
            //region effect
            coreFrost = new CoreBlock("core-frost"){{
                requirements(Category.production, with(Items.copper, 3000, Items.lead, 3000 ,Items.titanium, 1800, Items.silicon, 2200, PFItems.frostite, 2000));
                health = 3200;
                size = 4;
                itemCapacity = 6000;
                unitCapModifier = 16;
                researchCostMultiplier = 0.2f;
                unitType = PFUnits.subzero;
            }};
            //endregion effect
            //region logic


        }};
        heatproofProccessor = new LogicBlock("heatproof-proccessor"){{
            requirements(Category.logic, with(Items.beryllium, 300, Items.silicon, 300, Items.tungsten, 250, Items.oxide, 100));
            
            consumeLiquid(Liquids.nitrogen, 6f / 60f);
            hasLiquids = true;

            instructionsPerTick = 3;
            range = 6 * 18;
            size = 2;
            health = 1200;
            armor = 4f;
            envEnabled = Env.scorching;
        }};
        //endregion logic
        //region environment
        blueIce = new Floor("blue-ice"){{
            dragMultiplier = 0.3f;
            speedMultiplier = 0.85f;
            attributes.set(Attribute.water, 0.75f);
            albedo = 0.8f;
        }};
        blueIceWall = new StaticWall("blue-ice-wall"){{
            blueIce.asFloor().wall = this;
            albedo = 1.25f;
        }};
        blueIceBoulder = new Prop("blue-ice-boulder"){{
            variants = 2;
            blueIce.asFloor().decoration = this;
            albedo = 0.8f;
        }};
        blueIcePanel = new Floor("blue-ice-panel"){{
            variants = 0;
            dragMultiplier = 0.5f;
            speedMultiplier = 0.9f;
            attributes.set(Attribute.water, 0.25f);
            emitLight = true;
            lightRadius = 36f;
            lightColor = Color.cyan.cpy().a(0.22f);

        }};
        iceShard = new OreBlock("ice-shard",PFItems.frostite);
        //endregion environment
    
}

}