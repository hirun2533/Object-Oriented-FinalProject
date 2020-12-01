package model;


import model.interfaces.IShape;
import model.interfaces.RunCommand;
import view.gui.ShapeSetting;

public class BuildSelectCommand implements RunCommand {
	Point BeginPoint;
	Point StopPoint;
	ShapeSetting shapesetUp;

	int x; 
	int y; 
	int width; 
	int high;
	int BeginX;
	int BeginY;
	int StopX;
	int StopY;

	
	public BuildSelectCommand(ShapeSetting shapesetUp)
	{
		this.shapesetUp = shapesetUp;
     	this.BeginX = shapesetUp.BeginPoint.getX();
	    this.BeginY = shapesetUp.BeginPoint.getY();
	    this.StopX = shapesetUp.StopPoint.getX();
	    this.StopY = shapesetUp.StopPoint.getY();
	    this.x = Math.min(BeginX, StopX);
		this.y = Math.min(BeginY, StopY); 
		this.width = Math.abs(StopX - BeginX);
		this.high = Math.abs(StopY - BeginY);
	}
	
	@Override
	public void run()
	{		
	 shapesetUp.shapeList.getSelectShape().clear();		 
		 
	 for (IShape Selectshape : shapesetUp.shapeList.getListShape())
	 
		    { 	
		 
		    int getX = Selectshape.getX();
		 	int getY = Selectshape.getY();
		 	int getHigh = Selectshape.Height();
		 	int getWidth = Selectshape.Width();
		 	if (x < getWidth  + 
					getX && 
					x + width > getX && 
				y < getHigh  + 
					 getY && 
					y + high > getY)
				
			{
			
				shapesetUp.shapeList.ShapeSelectAdd(Selectshape);
				
				
			}
			 	
		}
		
	 		 shapesetUp.shapeList.PaintNewShape();
	
	}

}
