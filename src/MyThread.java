import java.awt.*;

public class MyThread extends Thread{
    Graphics g;
    MyList ml;

    public MyThread(MyList ml){
        this.ml=ml;
        g=ml.cv.getGraphics();
    }

    public void run(){


                ml.mdb.remplirTab(ml.model);
                try{
                    axesXY(50,"Genre","Nbr");
                    histogramme(50);
                    sleep(1000);
                }
                catch(Exception e){}






    }
    public void histogramme(int nbrPersonnes){
        g.setColor(Color.blue);
        g.fillRect(100,300,50,150);

        g.setColor(Color.pink);
        g.fillRect(250,250,50,200);

    }
    public void axesXY(int nbrPersonnes,String labelX,String labelY){
        g.setColor(Color.green);
        g.drawLine(25,450,450,450);
        g.drawLine(445,460,450,450);
        g.drawLine(445,440,450,450);

        g.drawLine(25,25,25,450);
        g.drawLine(15,35,25,25);
        g.drawLine(35,35,25,25);

        g.setColor(Color.red);
        g.drawString(labelX, 425, 425);
        g.drawString(labelY, 35, 35);
        g.setColor(Color.yellow);
        g.drawString(Integer.toString(nbrPersonnes), 55, 100);
        g.drawLine(10,100,40,100);



    }

}
