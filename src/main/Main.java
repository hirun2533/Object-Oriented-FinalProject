package main;

import java.awt.Graphics2D;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseController;
import model.Point;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.gui.ShapeSetting;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {

	
	private static int x;
	private static int y;
	public  static int width;
	public static int height;
	public static void main(String[] args){
		
		PaintCanvasBase paintCanvas = new PaintCanvas();
		
		IGuiWindow guiWindow = new GuiWindow(paintCanvas);
		Point Begin = new Point(x, y);
		Point Stop = new Point(width, height);
		IUiModule uiModule = new Gui(guiWindow);
		ApplicationState appState = new ApplicationState(uiModule);
		Graphics2D g = paintCanvas.getGraphics2D();
		ShapeList shapeList = new ShapeList();
    	ShapeSetting shapesetting = new ShapeSetting(Begin, Stop, g,  appState, shapeList);
        MouseController mouseClick = new MouseController(uiModule ,shapeList, paintCanvas, appState);     
     	IJPaintController controller = new JPaintController(uiModule, appState, shapeList,shapesetting);
    	paintCanvas.addMouseListener(mouseClick);
        controller.setup();
    
//        
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Filled in rectangle
//        Graphics2D graphics2d = paintCanvas.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
        
        
    }
}
