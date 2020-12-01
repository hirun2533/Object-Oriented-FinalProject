package controller;

import model.CommandHistory;
import model.ShapePaintFactory;
import model.interfaces.IShape;
import model.interfaces.IUndoRedo;
import model.interfaces.RunCommand;
import view.gui.ShapeSetting;

public class BuildCommand implements RunCommand,IUndoRedo {
	
	IShape shape;
	ShapeSetting shapesetUp;
	ShapePaintFactory shapePaintfactory = new ShapePaintFactory();
	
    
	
	public BuildCommand(ShapeSetting shapesetUp)
	{
		this.shapesetUp = shapesetUp;
		
	}
	
	@Override
	public void undo() {
		shapesetUp.shapeList.ShapeRemove(shape);
		shapesetUp.shapeList.PaintNewShape();
		
	}

	@Override
	public void redo() {
		shapesetUp.shapeList.ShapeAdd(shape);
		shapesetUp.shapeList.PaintNewShape();
		
	}
	@SuppressWarnings("unused")
	@Override
	public void run()
	{		

		shape = shapePaintfactory.PaintShape(shapesetUp);
		
		shape.PaintShape();	
		
		shapesetUp.shapeList.ShapeAdd(shape);
		
		CommandHistory.add(this);
	}

	

}
