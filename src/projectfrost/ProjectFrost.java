package projectfrost;


import arc.util.*;
import mindustry.mod.*;
import projectfrost.content.*;

public class ProjectFrost extends Mod{
    public static String name(String name){
		return "project-frost-" + name;
	}
    public ProjectFrost(){
        //TODO
    }

    @Override
    public void loadContent(){
        Log.info("Loading ProjectFrost...");
        PFUnits.load();
        PFItems.load();
        PFBlocks.load();
        PFFx.load();

    }

}