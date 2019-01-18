import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends Actor
{
    public int boxX = 0;
    public int boxY = 0;
    public boolean belegt = false;
    public void act() 
    {
        setItem();
    }
    public void getItem() {
        
    }
    public void setItem() {
        // Variable von Mensch - isTouching() -> Je nach, Picture in Feld, protected!
        if (belegt == false) {
            boxX = getX();
            boxY = getY();
            for (Mensch human : getWorld().getObjects(Mensch.class)){
                switch (human.put_in_inventory) {
                    case "Spear":
                        getWorld().addObject(new Spear(), boxX, boxY);
                        belegt = true;
                        //break;
                }
            }
        }
    }
    private void showText() {
        //switch case isTouching();
    }
}
