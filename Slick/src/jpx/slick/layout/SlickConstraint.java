/*
 *	MIT License
 *
 *	Copyright (c) 2017 Josh Simonot
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 *	of this software and associated documentation files (the "Software"), to deal
 *	in the Software without restriction, including without limitation the rights
 *	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *	copies of the Software, and to permit persons to whom the Software is
 *	furnished to do so, subject to the following conditions:
 *	
 *	The above copyright notice and this permission notice shall be included in all
 *	copies or substantial portions of the Software.
 *	
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *	SOFTWARE.
 */

package jpx.slick.layout;

/**
 * Constraint object for SlickLayout
 * @author Josh
 *
 */
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
	 * @param HorizontalSizing
	 * @param VerticalSizing
	 */
	public SlickConstraint(int row, HorizontalSizing hSizing, VerticalSizing vSizing)
	{
		this.row = row;
		this.hSizing = hSizing;
		this.vSizing = vSizing;
	}
	
	/**
	 * 
	 * @param weight
	 * @return
	 */
	public SlickConstraint setFillWeightHorizontal(float weight)
	{
		fillWeightHorizontal = weight;
		return this;
	}
	
	/**
	 * 
	 * @param weight
	 * @return
	 */
	public SlickConstraint setFillWeightVertical(float weight)
	{
		fillWeighVertical = weight;
		return this;
	}
	
	/**
	 * 
	 * @param align [0,1]
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
