package jpx.slick;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorPanel extends JPanel 
{
	public ColorPanel(Color color, Dimension dims)
	{		
		this.setBackground(color);
		this.setPreferredSize(dims); 
	}
}
