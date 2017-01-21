# Slick
## SlickLayout: Java Swing Layout Manager
Mix horizontally and vertically scaled components with fixed size components in a single layout. Add a component by specifying a row and its scaling constraints. In a single row, components are layed out in order of insertion. 

### Examples
#### App Top Level Layout
* The header is fixed height (64) but grows horizontally to fill the width of the frame.
* The navbar is fixed width (200) but grows vertically to fill the height of the frame. 
* The contentPanel has no fixed dimensions. It will fill the as much space as it can. 
```Java
JPanel header = new ColorPanel( Color.decode("#C6C6C6"), new Dimension(900, 64) ); 
JPanel navbar = new ColorPanel( Color.decode("#444444"), new Dimension(200, 550) );
JPanel contentPanel = new ColorPanel( Color.decode("#EEEEEE"), new Dimension(700, 550) );

JFrame frame = new JFrame("Example App Layout");
frame.setLayout( new SlickLayout() ); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

//first row
frame.add( header, new SlickConstraint(0, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) );

//second row
frame.add( navbar, new SlickConstraint(1, SlickConstraint.HorizontalPack, SlickConstraint.VerticalFill) );
frame.add( contentPanel, new SlickConstraint(1, SlickConstraint.HorizontalFill, SlickConstraint.VerticalFill) );

frame.pack();
frame.setVisible(true);
```
![example-app-layout-text][example-app-layout]





[example-app-layout]: https://github.com/jpxor/slick/blob/dev/Examples/res/example-app-layout.png "example-app-layout"
