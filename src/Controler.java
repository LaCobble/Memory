//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

import java.awt.event.*;

public class Controler implements MouseListener {

    private Model model;

    Controler(Model m)
    {
        this.model=m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int positionImage =(int)Math.floor(e.getX()/120)+(int)Math.floor(e.getY()/120)*5;
        model.modifier(positionImage);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    
}
