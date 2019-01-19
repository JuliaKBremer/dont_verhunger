import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends Actor
{
    static Inventory boxes[] = new Inventory[10];
    public int boxX = 0;
    public int boxY = 0;
    public boolean belegt = false;
    public int number; 
    public void act() 
    {
        setItem();
    }
    public void getItem(int key) {
        GreenfootImage image = new GreenfootImage("gras10.png");
        image.scale(50,50);
        getWorld().getBackground().drawImage(image, this.getX() -20 , this.getY()-20);
        getWorld().getBackground().drawImage(image, this.getX() -10 , this.getY()-10);
    }
        
    
    public void setItem() {
        // Variable von Mensch - isTouching() -> Je nach, Picture in Feld, protected!
        if (belegt == false) {
            boxX = getX();
            boxY = getY();
            for (Mensch human : getWorld().getObjects(Mensch.class)){
                /*switch (human.put_in_inventory) {
                    case "Spear":
                        getWorld().addObject(new Spear(), boxX, boxY);
                        belegt = true;
                        //break;
                }*/
                for (int i = 0; i< human.inventory.length; i++ ) {
                    if (human.inventory[i][0] != null) {
                        GreenfootImage image = human.inventory[i][0].getImage();
                        image.scale(30,30);
                        getWorld().getBackground().drawImage(image, boxes[i].getX() -20 , boxes[i].getY()-20);
                    }
                }
            }
        }
    }
    private void showText() {
        //switch case isTouching();
    }
}
