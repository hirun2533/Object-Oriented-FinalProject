package controller;

import model.BuildCopyCommand;
import model.BuildDeleteCommand;
import model.BuildGroupShape;
import model.BuildPasteCommand;
import model.BuildUngroupShape;
import model.RedoCommand;
import model.ShapeList;
import model.ShapeType;
import model.UndoCommand;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import view.EventName;
import view.gui.ShapeSetting;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
  
	private final IUiModule uiModule;
    private final IApplicationState applicationState;
	private ShapeList shapeList;
	private ShapeSetting ShapeSetting;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList,ShapeSetting ShapeSetting) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.ShapeSetting = ShapeSetting;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.DELETE, () -> new BuildDeleteCommand(shapeList).run());
        uiModule.addEvent(EventName.COPY, () -> new BuildCopyCommand(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new BuildPasteCommand(shapeList).run());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
 //       uiModule.addEvent(EventName.UNGROUP, () -> new BuildUngroupShape(ShapeSetting).run());

    }
}
