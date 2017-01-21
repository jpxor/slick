package jpx.slick.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test_SlickLayout {

	public static void main(String[] args) 
	{
		runTest();
	}

	public static boolean runTest() 
	{
		boolean pass = true;
		System.out.println("Test: SlickLayout");
		//======================================
		pass &= layoutTest();
		//======================================
		System.out.println("      > " + (pass?"PASS":"FAIL"));
		System.out.println();
		return pass;
	}

	
	private static boolean layoutTest() 
	{
		JPanel comp1 = new RandomColorPanel( new Dimension( 100, 36 ) );
		JPanel comp2 = new RandomColorPanel( new Dimension( 100, 36 ) );
		JPanel comp9 = new RandomColorPanel( new Dimension( 100, 36 ) );
		
		JPanel comp3 = new RandomColorPanel( new Dimension( 100, 100 ) );
		JPanel comp4 = new RandomColorPanel( new Dimension( 100, 100 ) );
		JPanel comp5 = new RandomColorPanel( new Dimension( 100, 100 ) );
		
		JPanel comp6 = new RandomColorPanel( new Dimension( 100, 175 ) );
		JPanel comp7 = new RandomColorPanel( new Dimension( 600, 100 ) );
		JPanel comp8 = new RandomColorPanel( new Dimension( 100, 138 ) );
		
		JPanel comp10 = new RandomColorPanel( new Dimension( 100, 100 ) );
		JPanel comp11 = new RandomColorPanel( new Dimension( 100, 100 ) );
		
		JPanel comp12 = new RandomColorPanel( new Dimension( 100, 100 ) );
		JPanel comp13 = new RandomColorPanel( new Dimension( 200, 100 ) );
		
		JFrame parent = new JFrame();
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		SlickLayout sl = new SlickLayout();
		parent.setLayout( sl ); 
		
		parent.add(comp1, new SlickConstraint(0, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		parent.add(comp2, new SlickConstraint(5, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		parent.add(comp9, new SlickConstraint(5, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		
		parent.add(comp3, new SlickConstraint(1, SlickConstraint.HorizontalFill, SlickConstraint.VerticalFill) ); 
		parent.add(comp4, new SlickConstraint(1, SlickConstraint.HorizontalPack, SlickConstraint.VerticalFill) );
		parent.add(comp5, new SlickConstraint(1, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		
		parent.add(comp6, new SlickConstraint(2, SlickConstraint.HorizontalPack, SlickConstraint.VerticalPack) ); 
		parent.add(comp7, new SlickConstraint(2, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack).setAlignmentY(0.5f) );
		parent.add(comp8, new SlickConstraint(2, SlickConstraint.HorizontalPack, SlickConstraint.VerticalPack).setAlignmentY(1.0f) ); 
		
		parent.add(comp10, new SlickConstraint(4,SlickConstraint.HorizontalPack, SlickConstraint.VerticalFill ));
		parent.add(comp11, new SlickConstraint(4,SlickConstraint.HorizontalFill, SlickConstraint.VerticalFill )); 
		
		parent.add(comp12, new SlickConstraint(3,SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack ));
		parent.add(comp13, new SlickConstraint(3,SlickConstraint.HorizontalPack, SlickConstraint.VerticalPack ));

		parent.pack(); 
		parent.setVisible(true);

		//parent.dispose();
		
		return false;
	}
	
	@SuppressWarnings("serial")
	static class RandomColorPanel extends JPanel
	{
		static final Random random = new Random();
		
		public RandomColorPanel(Dimension dims)
		{
			final float hue = random.nextFloat();
			
			// Saturation between 0.1 and 0.3
			final float saturation = (random.nextInt(2000) + 2500) / 10000f;
			
			final float luminance = 0.9f;
			
			final Color color = Color.getHSBColor(hue, saturation, luminance);
			
			this.setBackground(color);
			this.setPreferredSize(dims); 
		}
	}


}
