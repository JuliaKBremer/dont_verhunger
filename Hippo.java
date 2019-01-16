    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    
    public class Hippo extends Target
    {
        public int health = 70;
        public int humanX = 0;
        public int humanY = 0;
        public int selfY = 0;
        public int selfX = 0;
        public int betweenX = 0;
        public int betweenY = 0;
        
        public void act() 
        {
            for (Mensch human : getWorld().getObjects(Mensch.class)){
                    humanX = human.getX();
                    humanY = human.getY();
                }
            selfX = this.getX();
            selfY = this.getY();
            betweenX = Math.abs(humanX - selfX);
            betweenY = Math.abs(humanY - selfY);

            if (betweenX > 100 || betweenY > 100) {
                move();
            }
            if (betweenX < 100 || betweenY < 100) {
                hunt();
            }
            die();
        }    
        private void die() {
            if (health <= 0) {
                getWorld().removeObject(this);
            }
        }
        private void hunt() {
            for (Mensch human : getWorld().getObjects(Mensch.class)){
                    humanX = human.getX();
                    humanY = human.getY();
            }
            selfX = this.getX();
            selfY = this.getY();
            int betweenX = humanX - selfX;
            int betweenY = humanY - selfY;
            
            if ( betweenX < 0 ) {
                this.setLocation(selfX-3,selfY);
            }
            else if ( betweenX > 0 ) {
                this.setLocation(selfX+3,selfY);
            }
            selfX = this.getX();
            if ( betweenY > 0 ) {
                this.setLocation(selfX,selfY+3);
            }
            else if ( betweenY < 0 ) {
                this.setLocation(selfX,selfY-3);
            }
        }
}
