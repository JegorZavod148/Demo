public class ImgThread extends Thread {

    Hero hero;
    private int imgStep = 90;
    private int countFrame = 4;
    private int index = 0;

    ImgThread(Hero myImage){
        this.hero=myImage;
    }

    public void run(){
        for(this.index = 0; true; index++){
            if(this.index == countFrame){
                index = 0;
            }

            hero.backgroundX -= imgStep;
            hero.repaint();

            try{
                Thread.sleep(1000/10);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

    }

}
