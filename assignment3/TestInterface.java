import java.util.*;
interface Shape
{	
	 String getColor();
	 float getArea();
	 float getPerimeter();
}
class Circle implements Shape
{		private String color;
		private float radius ;
		public Circle()
		{	this.color ="Red";
			radius = 1.0f;
		}
		public Circle(float radius)
		{
			this.color = "Red";
			this.radius = radius;
		}
		public Circle(float radius, String color)
		{	
			this.color = color;
			this.radius = radius;
		}
		public float getRadius()
		{
			return radius;
		}
		public void setRadius(float radius)
		{
			this.radius = radius;
		}
		public float getArea()
		{
			return 3.14f * radius * radius;
		}
		public float getPerimeter()
		{
			return 2*3.14f*radius;
		}
public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
}
class Rectangle implements Shape
{	
	private String color;
	private float width;
	private float length;
	public Rectangle()
	{
		this.color = "Red";
		width = 1.0f;
		length =1.0f;
	}
	public Rectangle(float width, float length)
	{
		
		this.color = "Red";
		this.width = width;
		this.length = length;
	}
	public Rectangle(float width,float length, String color)
	{
		
		this.color = color;
		this.width = width;
		this.length =length;
	}
	public float getWidth()
	{
		return width;
	}
	public void setWidth(float width)
	{
		this.width = width;
	}
	public float getLength()
	{
		return length;
	}
	public void setLength(float length)
	{
		this.length = length;
	}
	public float getArea()
	{
		return length * width;
	}
	public float getPerimeter()
	{
		return 2*(length + width);
	}
public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
}
class Square implements Shape
{	private String color;
	private float side;
	Square()
	{	
		
		this.color = "Red";
		side = 1.0f;
	}
	Square(float side)
	{
		
		this.color = "Red";
		this.side = side;
	}
	Square(float side, String color)
	{
		this.color = color;
		this.side = side;
	}
	public float getSide()
	{
		return side;
	}
	public void setSide(float side)
	{	
		this.side = side;
	}
	public float getArea()
	{
		return side*side;
	}
	public float getPerimeter()
	{
		return 4*side;
	}
public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
}
public class TestInterface
{
	public static void main (String args[])
	{
		float dim1,dim2;
		String color;
		Shape[] sh = new Shape[9];
		Scanner det = new Scanner(System.in);
		System.out.println("************Circle***********");
		System.out.println("Enter the radius");
		dim1 = det.nextFloat();
		System.out.println("Enter the colour");
		color = det.next();
		Circle c1 = new Circle(dim1,color);
		sh[0] = c1;
		System.out.println("*******************CIRCLE DETAILS******************");
		System.out.println("Radius    :" + c1.getRadius());
		//System.out.println("Area      :" + sh.getArea());
		//System.out.println("Perimeter :" + sh.getPerimeter());
		Circle c2 = new Circle();
		sh[1] = c2;
		Circle c3 = new Circle(dim1);
		sh[2] = c3;
		System.out.println("************Rectangle***********");
		System.out.println("Enter the width");
		dim1 = det.nextFloat();
		System.out.println("Enter the length");
		dim2 = det.nextFloat();
		System.out.println("Enter the colour");
		color = det.next();
		Rectangle r1 = new Rectangle(dim1,dim2,color);
		sh[3] = r1;
		Rectangle r2 = new Rectangle();
		sh[4] = r2;
		Rectangle r3 = new Rectangle(dim1,dim2);
		sh[5] = r3;
		System.out.println("*******************RECTANGLE DETAILS******************");
		System.out.println("Width     :" + r1.getWidth());
		System.out.println("Length    :" + r1.getLength());
		//System.out.println("Area      :" + sh.getArea());
		//System.out.println("Perimeter :" + sh.getPerimeter());
		
		System.out.println("************Square***********");
		System.out.println("Enter the side");
		dim1 = det.nextFloat();
		System.out.println("Enter the colour");
		color = det.next();
		Square s1 = new Square(dim1,color);
		sh[6] = s1;
		Square s2 =new Square();
		sh[7] = s2;
		Square s3 = new Square(dim1); 
		sh[8] = s3;
		System.out.println("*******************SQUARE DETAILS******************");
		System.out.println("Side      :" + s1.getSide());
		//System.out.println("Area      :" + sh.getArea());
		//System.out.println("Perimeter :" + sh.getPerimeter());
		System.out.println("*******************Area and Perimeter of different shapes*******************");

		for (int i=0 ; i<9;i++)
		{
		System.out.println("Color     :" + sh[i].getColor());
		System.out.println("Area      :" + sh[i].getArea());
		System.out.println("Perimeter :" + sh[i].getPerimeter() + "\n");
		}
	}
}
	
	
