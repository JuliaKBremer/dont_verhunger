import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        spawn();
    }
    public void pflanzeGras()
    {
        for(int i=0; i<1000; i++) {
             for(int k=0; k<800; k++) {
                Gras gras = new Gras();
                addObject(gras, i, k);
            }
        }
    }
    public void spawn() {
        addObject(new Mensch(),100,100);
        addObject(new Pizza(),200,200);
        addObject(new Hippo(),700,500);
        addObject(new Spear(), 100,100);
        //if (Mensch.died == 1) {
        //    addObject(new Died(),500,400);
        //}
    }
}
