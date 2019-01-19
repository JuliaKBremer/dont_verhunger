import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int damage = 10;
    public void act() 
    {
        stick();
        collect();
    }
    public void collect() {
        
        if (isTouching(Mensch.class)) {
            Mensch human=(Mensch)getOneIntersectingObject(Mensch.class);
            if (this != human.equipped) {
                getWorld().removeObject(this);
            }
        }
    }
    public void stick() {
        if (isTouching(Mensch.class)) {
            Mensch human=(Mensch)getOneIntersectingObject(Mensch.class);
            if (human.equipped == null){   
                human.equipped = this;
                this.setLocation(human.getX(), human.getY());
            }
            
        }
        /*Mensch human=(Mensch)getOneIntersectingObject(Mensch.class);
        if (human.eqipped == null) {
            image = getImage();
        }*/
        /*for (Inventory inventory : getWorld().getObjects(Inventory.class)){
            int invX = inventory.getX();
            int invY = inventory.getY();
            for (Spear spear : getWorld().getObjects(Spear.class)){
                if (!(isTouching(Inventory.class)) && !(spear.getX() == invX && spear.getY() == invY)){
                    if (isTouching(Mensch.class)) {
                        int x = human.getX();
                        int y = human.getY();
                        boolean got_spear = true;
                        if (got_spear) {
                            human.put_in_inventory = "Spear";
                        }
                        this.setLocation(x, y);
                    }
                }
            }
        }*/
    }
}
