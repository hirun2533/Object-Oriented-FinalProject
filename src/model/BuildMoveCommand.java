package model;


import java.util.ArrayList;
import model.interfaces.IShape;
import model.interfaces.IUndoRedo;
import model.interfaces.RunCommand;
import view.gui.ShapeSetting;

public class BuildMoveCommand implements RunCommand,IUndoRedo {
	
	
	Point BeginPoint;
	Point StopPoint;
	ShapeSetting shapesetUp;
	ArrayList<IShape> shapeMove;
	IShape PreviousShape;
	int BeginX;
	int BeginY;
	int StopX;
	int StopY;
	int CalX;
	int CalY;

	public BuildMoveCommand(ShapeSetting shapesetUp)
	{
		this.shapesetUp = shapesetUp;
		this.BeginX = shapesetUp.BeginPoint.getX();
	    this.BeginY = shapesetUp.BeginPoint.getY();
	    this.StopX = shapesetUp.StopPoint.getX();
	    this.StopY = shapesetUp.StopPoint.getY();
	    this.CalX = StopX - BeginX;
		this.CalY = StopY - BeginY;
	}

	@Override
	public void run()
	{


		shapeMove = new ArrayList<IShape>();
	  	for (IShape Moveshape: shapesetUp.shapeList.getSelectShape())
		{	

	  		PreviousShape = Moveshape;
	  		
			IShape Select = Moveshape;	
			int BeginX = Select.BeginPoint().getX();
			int BeginY = Select.BeginPoint().getY();
			int StopX = Select.StopPoint().getX();
			int StopY = Select.StopPoint().getY();
			
			Select.setBeginPoint(BeginX + CalX, BeginY + CalY);
			Select.setStopPoint(StopX + CalX, StopY + CalY);
			shapeMove.add(Select);
			shapesetUp.shapeList.PaintNewShape();

		}
		
	  	CommandHistory.add(this);	
	}

	@Override
	public void undo() {
		
		shapeMove = new ArrayList<IShape>();
	  	for (IShape Moveshape: shapesetUp.shapeList.getSelectShape())
	{
		IShape Select = Moveshape;	
		PreviousShape = Moveshape;
		int BeginX = Select.BeginPoint().getX();
		int BeginY = Select.BeginPoint().getY();
		int StopX = Select.StopPoint().getX();
		int StopY = Select.StopPoint().getY();
		
		Select.setBeginPoint(BeginX - CalX, BeginY - CalY);
		Select.setStopPoint(StopX - CalX, StopY - CalY);
		shapeMove.add(Select);
		shapesetUp.shapeList.PaintNewShape();

		}
	}

	@Override
	public void redo() {
		shapeMove = new ArrayList<IShape>();
		
	  	for (IShape Moveshape: shapesetUp.shapeList.getSelectShape())
	{
		IShape Select = Moveshape;	
		PreviousShape = Moveshape;
		int BeginX = Select.BeginPoint().getX();
		int BeginY = Select.BeginPoint().getY();
		int StopX = Select.StopPoint().getX();
		int StopY = Select.StopPoint().getY();
		
		Select.setBeginPoint(BeginX + CalX, BeginY + CalY);
		Select.setStopPoint(StopX + CalX, StopY + CalY);
		shapeMove.add(Select);
		shapesetUp.shapeList.PaintNewShape();

		
		}
		
	}	
		
		
		
}