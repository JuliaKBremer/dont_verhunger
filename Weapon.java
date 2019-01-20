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
    public int durability = 3;
    public void act() 
    {
        stick();
        //collect();
    }
      public void stick() {
        if (isTouching(Mensch.class)) {
            Mensch human=(Mensch)getOneIntersectingObject(Mensch.class);
            if (human.equipped == null){   
                human.equipped = this;
                this.setLocation(human.getX(), human.getY());
            }
            
        }
    }
}
