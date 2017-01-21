package jpx.slick.layout;

public class SlickConstraint 
{
	private enum HorizontalSizing{ Fill, Pack };
	private enum VerticalSizing{ Fill, Pack };
	
	public static final HorizontalSizing HorizontalFill = HorizontalSizing.Fill;
	public static final HorizontalSizing HorizontalPack = HorizontalSizing.Pack;
	
	public static final VerticalSizing VerticalFill = VerticalSizing.Fill;
	public static final VerticalSizing VerticalPack = VerticalSizing.Pack;
	
	public final int row;
	public final HorizontalSizing hSizing;
	public final VerticalSizing vSizing;
	
	private float layoutAlignmentY = 0;
	private float fillWeightHorizontal = 1f;
	private float fillWeighVertical = 1f;
	/**
	 * 
	 * @param row
	 * @param hSizing
	 * @param vSizing
	 */
	public SlickConstraint(int row, HorizontalSizing hSizing, VerticalSizing vSizing)
	{
		this.row = row;
		this.hSizing = hSizing;
		this.vSizing = vSizing;
	}
	
	/**
	 * 
	 * @param w
	 * @return
	 */
	public SlickConstraint setFillWeightHorizontal(float w)
	{
		fillWeightHorizontal = w;
		return this;
	}
	
	/**
	 * 
	 * @param w
	 * @return
	 */
	public SlickConstraint setFillWeightVertical(float w)
	{
		fillWeighVertical = w;
		return this;
	}
	
	/**
	 * 
	 * @param align
	 * @return
	 */
	public SlickConstraint setAlignmentY(float align)
	{
		layoutAlignmentY = Math.max( 0, Math.min( 1, align )); 
		return this; 
	}

	/**
	 * 
	 * @return
	 */
	public float getAlignmentY()
	{
		return layoutAlignmentY;
	}
	
	/**
	 * 
	 * @return
	 */
	public float getFillWeightHorizontal()
	{
		return fillWeightHorizontal;
	}
	
	/**
	 * 
	 * @return
	 */
	public float getFillWeightVertical()
	{
		return fillWeighVertical;
	}
	
	
}
