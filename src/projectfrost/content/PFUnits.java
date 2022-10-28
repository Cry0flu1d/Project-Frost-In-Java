package projectfrost.content;

import arc.graphics.Color;
import arc.struct.ObjectSet;
import mindustry.ai.types.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.weapons.*;

import static projectfrost.ProjectFrost.name;

public class PFUnits {
    public static  UnitType sharder,subzero,cargoFlare;
    static{
        EntityMapping.nameMap.put(name("sharder"), EntityMapping.idMap[4]);
        EntityMapping.nameMap.put(name("subzero"), EntityMapping.idMap[24]);
        EntityMapping.nameMap.put(name("cargoFlare"), EntityMapping.idMap[3]);
    }


    public static void load() {
        subzero = new UnitType("subzero"){{
            speed = 0.6f;
            hitSize = 8;
            drag = 0.2f;
            hitSize = 11f;
            rotateSpeed = 3f;
            targetAir = true;
            health = 800;
            flying = false;
            immunities = ObjectSet.with( StatusEffects.freezing);
            outlineColor = Color.valueOf("464A59FF");

            legCount = 4;
            legLength = 11f;
            legForwardScl = 0.6f;
            legMoveSpace = 1.2f;
            legBaseOffset = 5;
            legExtension = -5;
            legSpeed = 0.4f;
            legLengthScl = 0.96f;
            rippleScale = 1;
            legSplashDamage = 0;
            legSplashRange = 0;
            hovering = true;
            armor = 0f;
            //ammoType = new ItemAmmoType(PFItems.frostite);

            shadowElevation = 0.4f;
            groundLayer = 75f;
            allowLegStep = true;
            faceTarget = true;
            range = 128f;

            buildSpeed = 0.9f;
            itemCapacity = 60;

            weapons.add(new Weapon("subzero-plasma-shotgun"){{

                shootY = 3f;
                inaccuracy = 15f;
                reload = 50f;
              
                recoil = 3f;
                x = 6f;
                y = -2f;
                layerOffset = -1;
                mirror = alternate = top = rotate = false;
                shootSound = Sounds.shotgun;
                shootCone = 10f; 
                shoot.shots = 6;
                shoot.shotDelay = 1.5f;
                lifetime = 50f;
                bullet = new BasicBulletType(){{
                    buildingDamageMultiplier = 0.01f;
                    sprite = "circle-bullet";
                    damage = 11f;
                    speed = 4.4f;
                    width = height = 8;
                        despawnEffect = new WaveEffect(){{
                            sizeFrom = 0;
                            sizeTo = 10;
                            lifetime = 20;
                            strokeFrom = 8;
                            strokeTo = 0;
                            sides = 16;
                            rotation = 180;
                            colorFrom = Color.valueOf("9EF4FFFF");
                            colorTo = Color.valueOf("6FE7F7FF");

                        }};
                        hitEffect = new ParticleEffect(){{
                            line = true;
                            particles = 12;
                            lifetime = 20f;
                            offset = 30f;
                            length = 15f;
                            cone = 50;
                            lenFrom = 5f;
                            lenTo = 1f;
                            colorFrom = Color.valueOf("9EF4FFFF");
                            colorTo = Color.valueOf("6FE7F7FF");
                        }};
                    shootEffect = Fx.none;

                }};
            }});
            weapons.add(new RepairBeamWeapon("subzero-repair"){{
                reload = 120f;              
                x = 6f;
                y = -2f;
                layerOffset = -1;
                mirror = false;
                top = rotate = true;
                shootY = 10f; 
                beamWidth = 0.4f;
                aimDst = 0f;
                shootCone = 10f;
                repairSpeed = 2f / 2f;
                fractionRepairSpeed = 0.02f;
                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Color.cyan;
                healColor = Color.cyan;
                bullet = new BulletType(){{
                    maxRange = 25f;
                }};
                
            }});
            

            /*cargoFlare =  new UnitType("cargo-flare"){{
                controller = u -> new CargoAI();
                isEnemy = false;
                allowedInPayloads = false;
                logicControllable = false;
                playerControllable = false;
                
                lowAltitude = false;
                speed = 3.3f;
                accel = 0.1f;
                drag = 0.03f;
                flying = true;
                health = 210;
                engineOffset = 5.8f;
                hitSize = 10;
                itemCapacity = 30;
                hidden = true;
            }};*/
        }}; 
        
    }
}
