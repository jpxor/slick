# Slick
## SlickLayout: Java Swing Layout Manager
Mix horizontally and vertically scaled components with fixed size components in a single layout. Add a component by specifying a row and its scaling constraints. In a single row, components are layed out in order of insertion. 

### Examples
```Java
JPanel header = new ColorPanel( Color.decode("#888888"), new Dimension(900, 40) );
JPanel navbar = new ColorPanel( Color.decode("#444444"), new Dimension(200, 900) );
JPanel contentPanel = new ColorPanel( Color.decode("#EEEEEE"), new Dimension(700, 900) );

JFrame frame = new JFrame();
frame.setLayout( new SlickLayout() ); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

//first row
frame.add( header, new SlickContraint(0, SlickConstraint.HorizontalFill, SlickConstraint.VerticalPack) );

//second row
frame.add( navbar, new SlickContraint(1, SlickConstraint.HorizontalPack, SlickConstraint.VerticalFill) );
frame.add( contentPanel, new SlickContraint(1, SlickConstraint.HorizontalFill, SlickConstraint.VerticalFill) );

frame.pack();
frame.setVisible(true);
```
