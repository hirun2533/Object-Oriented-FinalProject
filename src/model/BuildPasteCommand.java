package model;

import java.util.ArrayList;


import model.interfaces.IShape;
import model.interfaces.IUndoRedo;
import model.interfaces.RunCommand;
import view.gui.ShapeSetting;
import controller.BuildCommand;
public class BuildPasteCommand implements RunCommand, IUndoRedo{
	
	
	IShape shape;
	ShapeList shapeList;
	BuildCommand BuildCommand;
	RunCommand runcommand;
	ShapeSetting shapesetup;

	private final ArrayList<IShape> addPaste = new ArrayList<IShape>();


	int startpointX;
	int startPointY;
	int stopPointX;
	int stopPointY;
	private Point BeginPoint;
	private Point StopPoint;
	 ArrayList<IShape> shapeListCopy = new ArrayList<IShape>();;
	 IShape oldshape;
	 IShape newShape;
	 
	 
	public BuildPasteCommand(ShapeList shapeList)
	{
		   this.shapeListCopy = shapeListCopy;
			this.shapeList = shapeList;

	}


	@Override
	public void run() 
	
	   {
		 for(IShape Pasteshape: shapeList.getSelectShape())
		
		 {     
			 	newShape = Pasteshape;
				BeginPoint = Pasteshape.BeginPoint();
				StopPoint = Pasteshape.StopPoint();
		
				BeginPoint.x += 80;
				BeginPoint.y += 80;

				StopPoint.x +=  80;
				StopPoint.y += 80;
	            
				addPaste.add(Pasteshape);
				
		 }           
		  CommandHistory.add(this);
		
        for (IShape Pasteshape : addPaste)
        {   
        	runcommand = new BuildCommand(Pasteshape.getShapeSetUp());      
        	runcommand.run();   
            
        }	

      
	}


	@Override
	public void undo() {
		
		shapeList.ShapeRemove(newShape);
		shapesetup.shapeList.PaintNewShape();
	}


	@Override
	public void redo() {
		
		for(IShape Pasteshape: shapeList.getSelectShape())
			
		 {     
			 	newShape = Pasteshape;
				BeginPoint = Pasteshape.BeginPoint();
				StopPoint = Pasteshape.StopPoint();
		
				BeginPoint.x += 80;
				BeginPoint.y += 80;

				StopPoint.x += 80;
				StopPoint.y += 80;
	            
				addPaste.add(Pasteshape);
				
		 }           
		  CommandHistory.add(this);
		
       for (IShape Pasteshape : addPaste)
       {   
       	runcommand = new BuildCommand(Pasteshape.getShapeSetUp());      
       	runcommand.run();   
       
           
       }	
		
	}
	
	
}
