package controller;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.BuildGroupShape;
import model.BuildMoveCommand;
import model.Point;
import model.BuildSelectCommand;
import model.BuildUngroupShape;
import model.ShapeList;
import model.StartAndEndPointMode;
import model.interfaces.RunCommand;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.EventName;
import view.gui.ShapeSetting;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

public class MouseController extends MouseAdapter{
	
    ShapeSetting shapesetUp;
    ShapeList shapeList;
	ShapeType shapeType;
	Graphics2D graphic;
    RunCommand BuildShape;
    int x;
	int y;
	int width;
	int high;
    Point BeginPoint;
    Point StopPoint;
	PaintCanvasBase paintCanvasbase; 
	ApplicationState application;
	IUiModule uiModule;

    public MouseController(IUiModule uiModule,ShapeList shapeList,PaintCanvasBase paintCanvasbase, ApplicationState application )
    {
    	this.uiModule = uiModule;
        this.application = application;
        this.paintCanvasbase = paintCanvasbase;
        this.shapeList = shapeList; 
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
    	x = e.getX();
        y = e.getY();
    	BeginPoint = new Point(x, y);
    	
//      System.out.println("Pressing");
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@Override
    public void mouseReleased(MouseEvent e)
    {
    	width = e.getX();
        high = e.getY();
        
    	StopPoint = new Point(width, high);
    	
    	graphic = paintCanvasbase.getGraphics2D();

    	shapesetUp = new ShapeSetting(BeginPoint, StopPoint,graphic, application, shapeList);
    	
    	StartAndEndPointMode startAndEndPointMode = application.getActiveStartAndEndPointMode();
    	
    	
    	if (startAndEndPointMode.equals(StartAndEndPointMode.DRAW))
    	{
    		BuildShape = new BuildCommand(shapesetUp);
    	}
    	else if (startAndEndPointMode.equals(StartAndEndPointMode.MOVE))
    	{
    		BuildShape = new BuildMoveCommand(shapesetUp);
    	}
    	
    	else if (startAndEndPointMode.equals(StartAndEndPointMode.SELECT))
    	{
    		BuildShape = new BuildSelectCommand(shapesetUp);

    	}
    	
    	uiModule.addEvent(EventName.GROUP, () -> new BuildGroupShape(shapesetUp).run());
    	uiModule.addEvent(EventName.UNGROUP, () -> new BuildUngroupShape(shapesetUp).run());
    	BuildShape.run();
    }
    
    	
    
    
    
}