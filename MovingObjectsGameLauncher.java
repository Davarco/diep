import java.awt.*;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MovingObjectsGameLauncher {

	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("Oipe.id");
		Map<String,String> environMap = System.getenv();

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		MovingObjectsPanel mop = new MovingObjectsPanel(d);

		Image icon = null;
		try {
			URL url = MovingObjectsGameLauncher.class.getResource("images/ICON.png");
			if (url != null) {
				icon = ImageIO.read(url);
			}
		} catch (Exception ignored) {

		}

		if (icon != null) {
			gameFrame.setIconImage(icon);
		}
		gameFrame.add(mop);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
		mop.repaint();
	}

}