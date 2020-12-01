package view.gui;

import java.awt.Graphics2D;

import model.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class ShapeSetting  {
	
	
	public ShapeColor primaryColor;
	public ShapeColor secondColor;
	public ApplicationState application;
	public ShapeList shapeList;
	public Graphics2D graphic;
	public Point BeginPoint;
	public Point StopPoint;
	public ShapeType shapeType;
	public ShapeShadingType shadingType;
	public int width;
	public int Height;

	
	public ShapeSetting(Point Begin, Point Stop,Graphics2D graphic, ApplicationState application, ShapeList shapeList)
	

	{	
		this.primaryColor = application.getActivePrimaryColor();
		this.secondColor = application.getActiveSecondaryColor();
		this.BeginPoint = Begin;
		this.StopPoint = Stop;
		this.graphic = graphic;
		this.application = application;
		this.shapeList = shapeList;
		this.shapeType = application.getActiveShapeType();
		this.shadingType = application.getActiveShapeShadingType();
	
		
	}

	public ShapeColor getPrimaryColor() {
		return this.primaryColor;
	}


	public ShapeColor getSecondColor() {
		return this.secondColor;
	}


	public ApplicationState getAppState() {
		return this.application;
	}


	public ShapeList getShapeList() {
		return this.shapeList;
	}
	
	
	public Graphics2D getGraphics2D() {
		return this.graphic;
	}

	public Point getBegin() {
		return this.BeginPoint;
	}


	public Point getStop() {
		return this.StopPoint;
	}

	public ShapeType getShapeType() {
		return this.shapeType;
	}


	public ShapeShadingType getShadingType() {
		return this.shadingType;
	}

	public int Height() {
		
		return this.Height;
	}
	public int width() {
		
		return this.width;
	}

}
