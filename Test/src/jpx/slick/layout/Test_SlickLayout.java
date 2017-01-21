package jpx.slick.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
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
		JPanel comp1 = new RandomColorPanel( new Dimension( 100, 36 ), "1" );
		JPanel comp2 = new RandomColorPanel( new Dimension( 100, 36 ), "2" );
		JPanel comp3 = new RandomColorPanel( new Dimension( 100, 36 ), "3" );
		
		JPanel comp4 = new RandomColorPanel( new Dimension( 100, 100 ), "4" );
		JPanel comp5 = new RandomColorPanel( new Dimension( 100, 100 ), "5" );
		JPanel comp6 = new RandomColorPanel( new Dimension( 100, 100 ), "6" );
		
		JPanel comp7 = new RandomColorPanel( new Dimension( 100, 175 ), "7" );
		JPanel comp8 = new RandomColorPanel( new Dimension( 600, 100 ), "8" );
		JPanel comp9 = new RandomColorPanel( new Dimension( 100, 138 ), "9" );
		
		JPanel comp10 = new RandomColorPanel( new Dimension( 100, 100 ), "10" );
		JPanel comp11 = new RandomColorPanel( new Dimension( 100, 100 ), "11" );
		
		JPanel comp12 = new RandomColorPanel( new Dimension( 100, 100 ), "12" );
		JPanel comp13 = new RandomColorPanel( new Dimension( 200, 100 ), "13" ); 
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		frame.setLayout( new SlickLayout() ); 
		
		frame.add(comp1, new SlickConstraint(0, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		frame.add(comp2, new SlickConstraint(5, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		frame.add(comp3, new SlickConstraint(5, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		
		frame.add(comp4, new SlickConstraint(1, SlickConstraint.HorizontalFill, SlickConstraint.VerticalFill) ); 
		frame.add(comp5, new SlickConstraint(1, SlickConstraint.HorizontalPack, SlickConstraint.VerticalFill) );
		frame.add(comp6, new SlickConstraint(1, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) ); 
		
		frame.add(comp7, new SlickConstraint(2, SlickConstraint.HorizontalPack, SlickConstraint.VerticalPack) ); 
		frame.add(comp8, new SlickConstraint(2, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack).setAlignmentY(0.5f) );
		frame.add(comp9, new SlickConstraint(2, SlickConstraint.HorizontalPack, SlickConstraint.VerticalPack).setAlignmentY(1.0f) ); 
		
		frame.add(comp10, new SlickConstraint(4,SlickConstraint.HorizontalPack, SlickConstraint.VerticalFill ));
		frame.add(comp11, new SlickConstraint(4,SlickConstraint.HorizontalFill, SlickConstraint.VerticalFill )); 
		
		frame.add(comp12, new SlickConstraint(3,SlickConstraint.HorizontalFill, SlickConstraint.VerticalFill ));
		frame.add(comp13, new SlickConstraint(3,SlickConstraint.HorizontalPack, SlickConstraint.VerticalFill ));
		
		frame.pack(); 
		
		//expected results: 
		String c1 = "1[x=0,y=0,width=800,height=36]";
		String c2 = "2[x=0,y=511,width=400,height=36]";
		String c3 = "3[x=400,y=511,width=400,height=36]";
		String c4 = "4[x=0,y=36,width=350,height=100]";
		String c5 = "5[x=350,y=36,width=100,height=100]";
		String c6 = "6[x=450,y=36,width=350,height=100]";
		String c7 = "7[x=0,y=136,width=100,height=175]";
		String c8 = "8[x=100,y=173,width=600,height=100]";
		String c9 = "9[x=700,y=173,width=100,height=138]";
		String c10 = "10[x=0,y=411,width=100,height=100]";
		String c11 = "11[x=100,y=411,width=700,height=100]";
		String c12 = "12[x=0,y=311,width=600,height=100]";
		String c13 = "13[x=600,y=311,width=200,height=100]";
		
		boolean pass = true;
		pass &= c1.equals( comp1.toString() );
		pass &= c2.equals( comp2.toString() );
		pass &= c3.equals( comp3.toString() );
		pass &= c4.equals( comp4.toString() );
		pass &= c5.equals( comp5.toString() );
		pass &= c6.equals( comp6.toString() );
		pass &= c7.equals( comp7.toString() );
		pass &= c8.equals( comp8.toString() );
		pass &= c9.equals( comp9.toString() );
		pass &= c10.equals( comp10.toString() );
		pass &= c11.equals( comp11.toString() );
		pass &= c12.equals( comp12.toString() );
		pass &= c13.equals( comp13.toString() );
		
		//frame.setVisible(true);
		frame.dispose();
		
		return pass;
	}
	
	@SuppressWarnings("serial")
	static class RandomColorPanel extends JPanel
	{
		static final Random random = new Random();
		
		private final String name;
		
		public RandomColorPanel(Dimension dims, String name)
		{			
			final float saturation = (random.nextInt(2000) + 3000) / 10000f;
			final float luminance = 0.9f;
			final float hue = random.nextFloat();
			final Color color = Color.getHSBColor(hue, saturation, luminance);
			
			this.name = name;
			this.setBackground(color);
			this.setPreferredSize(dims); 
		}
		
		public String toString()
		{
			Rectangle bounds = this.getBounds();
			return name + "[x=" + bounds.x +",y="+bounds.y+",width="+bounds.width+",height="+bounds.height+"]";
		}
	}


}
