package projectfrost;


import arc.util.*;
import mindustry.mod.*;
import projectfrost.content.*;

public class ProjectFrost extends Mod{

    public ProjectFrost(){
        //TODO
    }

    @Override
    public void loadContent(){
        Log.info("Loading ProjectFrost...");
        PFUnits.load();
        PFItems.load();
        PFBullets.load();
        PFBlocks.load();
        PFEffects.load();

    }

}