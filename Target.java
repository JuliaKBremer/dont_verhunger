import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Actor
{
    /**
     * Act - do whatever the Target wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    
    public void move() {
      int x = getX();
      int y = getY();
      int zahl = (int)(Math.random()*4);
      
      switch (zahl) {
          case 0:
            x--;
            break;
          case 1:
            y++;
            break;
          case 2:
            x++;
            break;
          case 3:
            y--;
            break;
      }
      this.setLocation(x, y);   
    }

}
