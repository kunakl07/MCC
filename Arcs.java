import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Arcs extends MIDlet
{
  private Display  display;    // The display
  private ArcsCanvas canvas;   // Canvas 
 
  public Arcs()
  {
    display = Display.getDisplay(this);
    canvas  = new ArcsCanvas(this);
  }
 
  protected void startApp()
  {
    display.setCurrent( canvas );
  }
 
  protected void pauseApp()
  { }

  protected void destroyApp( boolean unconditional )
  { }
 
  public void exitMIDlet()
  {
    destroyApp(true);
    notifyDestroyed();
  }
}

class ArcsCanvas extends Canvas implements CommandListener
{
  private Command cmExit;  // Exit midlet
  private Arcs midlet;
 
  public ArcsCanvas(Arcs midlet)
  {
    this.midlet = midlet;
    cmExit = new Command("Exit", Command.EXIT, 1);               // Create exit command & listen for events
    addCommand(cmExit);
    setCommandListener(this);
  } 
  protected void paint(Graphics g)
  {
    g.drawArc(70, 90, 90, 90, 0, 360);
    g.drawRect(60, 80, 120, 120);
    g.drawLine(120,90,120,140);
    //g.fillArc(5, 5, 75, 75, 0, 225);
    //g.drawArc(5, 5, 75, 75, 90, 225);    
    //g.drawArc(25, 35, 30, 50, 90, 225);    
  }

  public void commandAction(Command c, Displayable d)
  {
    if (c == cmExit)
      midlet.exitMIDlet();
  }
}

 
