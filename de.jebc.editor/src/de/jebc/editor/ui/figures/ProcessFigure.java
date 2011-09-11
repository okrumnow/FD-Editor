package de.jebc.editor.ui.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class ProcessFigure extends Figure {

	private RectangleFigure rectangle;
	private Label label;

	public ProcessFigure() {
		setLayoutManager(new XYLayout());
		rectangle = new RectangleFigure();
		add(rectangle);
		label = new Label();
		add(label);
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds();
		setConstraint(rectangle, new Rectangle(0, 0, r.width(), r.height()));
		setConstraint(label, new Rectangle(0, 0, r.width(), r.height()));
	}
	
	public Label getLabel() {
		return label;
	}
}
