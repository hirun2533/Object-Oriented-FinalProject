package model;


import java.util.ArrayList;

import model.interfaces.IShape;
import model.interfaces.IUndoRedo;
import model.interfaces.RunCommand;
import view.gui.ShapeSetting;



public class BuildDeleteCommand implements RunCommand,IUndoRedo {


	public ShapeList shapeList;
	ArrayList<IShape> selectedShapes;
	ShapeSetting shapesetup;
	ArrayList<IShape> DeleteShape = new ArrayList<IShape>();

	public BuildDeleteCommand(ShapeList shapeList)

	{
		this.shapeList = shapeList;

	}

	@Override
	public void run() {


		for (IShape Deleteshape :  shapeList.getSelectShape())
		{   
			DeleteShape.add(Deleteshape);
			shapeList.ShapeRemove(Deleteshape);     
			shapeList.PaintNewShape();
		}

		shapeList.ShapeSelectClear();

		shapeList.PaintNewShape();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		for (IShape shape : DeleteShape)
		{
			shapeList.ShapeAdd(shape);
			shapeList.PaintNewShape();
		}

	}

	@Override
	public void redo() {
		for (IShape shape : DeleteShape)
		{
			shapeList.ShapeRemove(shape);
			shapeList.PaintNewShape();
		}
	}


}
