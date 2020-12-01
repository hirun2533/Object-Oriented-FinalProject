package model;

import java.util.ArrayList;
import model.interfaces.IShape;
import model.interfaces.RunCommand;
import view.gui.ShapeSetting;


public class BuildCopyCommand implements RunCommand {

	ShapeList shapeList;

	ArrayList<IShape> selectedShapes;
	ArrayList<IShape> shapeListCopy;


	public BuildCopyCommand(ShapeList shapeList)
	{   

		this.shapeListCopy = shapeListCopy;
		this.shapeList = shapeList;
		this.selectedShapes = shapeList.getSelectShape();
	}

	private void ShapeCopy(ArrayList<IShape> selectedShapes) {


		for (IShape Copyshape : selectedShapes)
		{
			shapeList.DupClipBoard(Copyshape);
		}

	}

	@Override
	public void run() {

		ShapeCopy(selectedShapes);


	}



}
