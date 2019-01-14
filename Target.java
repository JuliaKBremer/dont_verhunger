import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Target extends Actor
{
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
            x -= 3;
            break;
          case 1:
            y += 3;
            break;
          case 2:
            x += 3;
            break;
          case 3:
            y -= 3;
            break;
      }
      this.setLocation(x, y);   
    }

}
