package view;

import java.awt.*;

import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.gui.ShapeSetting;

public class StrategyPaintRectangle implements IShape {

	ShapeSetting shapesetUp;
	int x;
	int y;
	int width;
	int height;
	int BeginX;
	int BeginY;
	int StopX;
	int StopY;
	Point BeginPoint;
	Point StopPoint;
	int[] SetarrayX = new int[2];
	int[] SetarrayY = new int[2];

	public StrategyPaintRectangle(ShapeSetting shapesetUp)
	{		
		this.shapesetUp = shapesetUp;
		this.BeginX = shapesetUp.BeginPoint.getX();
		this.BeginY = shapesetUp.BeginPoint.getY();
		this.StopX = shapesetUp.StopPoint.getX();
		this.StopY = shapesetUp.StopPoint.getY();	

		this.width = Math.abs(StopX - BeginX);
		this.height = Math.abs(StopY - BeginY);
		this.BeginPoint = shapesetUp.getBegin();
		this.StopPoint = shapesetUp.getStop();

	}

	@Override
	public void PaintShape()
	{	
		BasicStroke bs = new BasicStroke(3);
		ShapeShadingType shadetype = shapesetUp.shadingType;
		Graphics2D graphic = shapesetUp.graphic;


		switch(shadetype){

		case FILLED_IN:
			graphic.setColor(shapesetUp.primaryColor.getColor());

			graphic.fillRect(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);
			break;

		case OUTLINE:
			graphic.setColor(shapesetUp.primaryColor.getColor());
			graphic.setStroke(bs);
			graphic.drawRect(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);
			break;

		case OUTLINE_AND_FILLED_IN:			
			graphic.setColor(shapesetUp.primaryColor.getColor());
			graphic.fillRect(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);
			graphic.setStroke(bs); 
			graphic.setColor(shapesetUp.secondColor.getColor());
			graphic.drawRect(shapesetUp.BeginPoint.getX(), shapesetUp.BeginPoint.getY(), width, height);

		default:
			break;

		}

	}

	public int CalX() {
		return this.CalX();
	}

	public int CalY() {
		return this.CalY();
	}

	@Override
	public int getX()
	{
		return this.shapesetUp.BeginPoint.getX();
	}

	@Override
	public int getY()
	{
		return this.shapesetUp.BeginPoint.getY();
	}

	@Override
	public int Width()
	{
		return this.width;
	}

	@Override
	public int Height()
	{
		return this.height;
	}

	@Override
	public Point BeginPoint()
	{
		return BeginPoint;
	}

	@Override
	public Point StopPoint()
	{
		return StopPoint;
	}

	@Override
	public void setBeginPoint(int x, int y)
	{
		BeginPoint.setX(x);
		BeginPoint.setY(y);

	}

	@Override
	public void setStopPoint(int x, int y)
	{

		StopPoint.setX(x);
		StopPoint.setY(y);

	}

	@Override
	public ShapeSetting getShapeSetUp()
	{
		return shapesetUp;
	}

	@Override
	public void selectLine() {


	}



}
