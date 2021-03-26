package shareObject;

import javafx.scene.canvas.GraphicsContext;

public interface Renderable {
	public int getPriority();
	public void render(GraphicsContext gc);
	public boolean isDestroyed();
	public boolean isVisible();
}
