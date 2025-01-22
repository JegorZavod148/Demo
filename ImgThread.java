public class ImgThread extends Thread{

    private Hero hero;
    private int imgStep = 91;

    ImgThread(Hero hero){
        this.hero = hero;
    }

    public void run(){
        for(int index=0;true;index++){
            if (index == 3){
                index = 0;
                hero.backgrounX = 0;
            }

            hero.backgrounX -= imgStep;
            hero.repaint();

            try{
                Thread.sleep(1000/5);
            }
            catch(Exception e){
                System.out.println(e);
                break;
            }
        }
    }
}
