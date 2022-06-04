package projectfrost.content;


import arc.graphics.g2d.*;
import arc.math.Mathf;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;


public class PFEffects {
    public static
    Effect
         farlightShot;
  
    public static void load() {
        farlightShot = new Effect(60f, 80f, e -> {
            color(Pal.lancerLaser);
            stroke(e.fin() * 1.5f);
            Lines.circle(e.x, e.y, 4f + e.fout() * 60f);
    
            Fill.circle(e.x, e.y, e.fin() * 7);
    
            randLenVectors(e.id, 14, 40f * e.fout(), (x, y) -> {
                lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fslope() * 4f + 2);
                Fill.circle(e.x + x, e.y + y, e.fin() * 5f);
                Drawf.light(e.x + x, e.y + y, e.fin() * 15f, Pal.lancerLaser, 0.6f);
            });
    
            color();
    
            Fill.circle(e.x, e.y, e.fin() * 7);
            Drawf.light(e.x, e.y, e.fin() * 15f, Pal.lancerLaser, 0.6f);
        }).followParent(true).rotWithParent(true);

        
    }
    
}