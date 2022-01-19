import java.util.Observable;

public class Model extends Observable 
{
    
    private int[] ordre={9,8,0,1,3,1,6,5,4,9,2,2,7,8,0,7,5,4,3,6};
    private boolean[] visible = new boolean[20]; // toutes les cases doivent être à false

    private int nbPaires = 0;
    private int nbCoups = 0;
    private int numZoneIm1;
    private int numZoneIm2;
    private int numclic;

    public int getNbPaires() 
    {
        return nbPaires;
    }

    public int getNbCoups()
    {
        return nbCoups;
    }

    public boolean[] getVisible() 
    {
        return visible;
    }

    public int[] getOrdre() 
    {
        return ordre;
    }

    public void modifier(int numz)
    {
        if (numclic ==2)
        {
            visible[numZoneIm1]=false;
            visible[numZoneIm2]=false;
            numclic = 0;
        }
        if (visible[numz]==false)
        {
            if (numclic == 0)
            {
                numZoneIm1=numz;
                visible[numz]=true;
                numclic = 1;
            }
            else
            {
                numZoneIm2=numz;
                visible[numz]=true;
                numclic = 2;
                if (ordre[numZoneIm1]==ordre[numZoneIm2])
                {
                    nbPaires+=1;
                    nbCoups=nbCoups+1;
                    numclic = 0;
                }
                else{
                    nbCoups++;
                    numclic = 2;
                }
            }
        }
        this.setChanged();              //Informer les vues des changements
        this.notifyObservers();
  }

    public void init() {

        for (int j = 0; j < ordre.length; j++) {
            int r = (int)(Math.random()*ordre.length);
            int tmp = ordre[j];
            ordre[j] = ordre[r];
            ordre[r] = tmp;
        }
        visible = new boolean [20];
        nbCoups = 0;
        nbPaires = 0;

        this.setChanged();              //Informer les vues des changements
        this.notifyObservers(); 
    }
}   
