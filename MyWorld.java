import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Arrays;
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    public Bar healthbar = new Bar("Player", "health Points", 100, 100);
    public Bar nutritionbar = new Bar("Player", "nutrition Points", 100, 100);
    static final int worldwidth = 800;
    static final int worldheight = 400;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldwidth, worldheight, 1);
        //System.out.println(nutritionbar.referenceText);
        spawn();
        inventory();
    }
    public void pflanzeGras()
    {
        for(int i=0; i<worldwidth; i++) {
            for(int k=0; k<worldheight; k++) {
                Gras gras = new Gras();
                addObject(gras, i, k);
            }
        }
    }

    public void spawn() {
        int randomX = 0;
        int randomY = 0;
        int randomAnzahl = 0;
        int maxcount = 10;
        if ((getObjects(Mensch.class)).size()<1){
            addObject(new Mensch(),(int)(Math.random()*worldwidth),(int)(Math.random()*worldheight));
        }
        randomX = (int)(Math.random()*worldwidth);
        //randomY = (int)();
        //addObject(new Spear(), randomX,100);
        boolean build = false;
        for (int i = 0; i < (int)(Math.random()*5); i++ ) {
            while (!build) {
                randomX = (int)(Math.random()*worldwidth);
                randomY = (int)(Math.random()*worldheight);
                if ((getObjectsAt(randomX, randomY, Actor.class)).size() < 1){ 
                    build = true;
                }
            }
            addObject(new Pizza(),randomX,randomY);
            build = false;
        }
        for (int i = 0; i < (int)(Math.random()*5); i++ ) {
            while (!build) {
                randomX = (int)(Math.random()*worldwidth);
                randomY = (int)(Math.random()*worldheight);
                if ((getObjectsAt(randomX, randomY, Actor.class)).size() < 1){ 
                    build = true;
                }
            }
            addObject(new Banana(),randomX,randomY);
            build = false;
        }
        for (int i = 0; i < (int)(Math.random()*2); i++ ) {
            while (!build) {
                randomX = (int)(Math.random()*worldwidth);
                randomY = (int)(Math.random()*worldheight);
                if ((getObjectsAt(randomX, randomY, Actor.class)).size() < 1){ 
                    build = true;
                }
            }
            addObject(new Spear(),randomX,randomY);
            build = false;
        }
        for (int i = 0; i < (int)(Math.random()*5); i++ ) {
            while (!build) {
                randomX = (int)(Math.random()*worldwidth);
                randomY = (int)(Math.random()*worldheight);
                if ((getObjectsAt(randomX, randomY, Actor.class)).size() < 1){ 
                    build = true;
                }
            }
            addObject(new Hatchet(),randomX,randomY);
            build = false;
        }
        for (int i = 0; i < (int)(Math.random()*5); i++ ) {
            while (!build) {
                randomX = (int)(Math.random()*worldwidth);
                randomY = (int)(Math.random()*worldheight);
                if ((getObjectsAt(randomX, randomY, Actor.class)).size() < 1){ 
                    //System.out.println((getObjectsAt(randomX, randomY, Actor.class)).size());
                    build = true;
                }
            }
            addObject(new Cupcake(),randomX,randomY);
            build = false;
        }
        
        for (int i = 0; i < (int)(Math.random()*1); i++ ) {
            while (!build) {
                randomX = (int)(Math.random()*worldwidth);
                randomY = (int)(Math.random()*worldheight);
                if ((getObjectsAt(randomX, randomY, Actor.class)).size() < 1){ 
                    //System.out.println((getObjectsAt(randomX, randomY, Actor.class)).size());
                    build = true;
                }
            }
            addObject(new Hippo(),randomX,randomY);
            build = false;
        }
        
        for (int i = 0; i < (int)(Math.random()*3); i++ ) {
            while (!build) {
                randomX = (int)(Math.random()*worldwidth);
                randomY = (int)(Math.random()*worldheight);
                if ((getObjectsAt(randomX, randomY, Actor.class)).size() < 1){ 
                    //System.out.println((getObjectsAt(randomX, randomY, Actor.class)).size());
                    build = true;
                }
            }
            addObject(new Pig(),randomX,randomY);
            build = false;
        }
    }
    public void inventory() {
        int invX = worldwidth/10;
        int invY = worldheight- 20;
        int textX =worldwidth/10 +20;
        int textY = worldheight-10;
        //int number = 1;
        
        for (int i = 0; i < 10; i++) {
            Inventory inventory = new Inventory();
            Inventory.boxes[i] = inventory;
            addObject(inventory, invX, invY);
            showText(Integer.toString(i+1), textX, textY);
            invX += worldwidth/12;
            textX += worldwidth/12;
        }
    }
    
    // public void healthbar()
    // {
        // if (bar.getValue() == bar.getMinimumValue())
        // {
            // if (getObjects(GameOver.class).isEmpty()) showGameOver();
            // return;
        // }
    // }
    
    // private void showGameOver()
    // {
        // addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
    // }
}
