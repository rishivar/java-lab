import java.util.*;
abstract class Shape
{
	String color;
	public Shape()
	{
		color = "red";
	}
	public Shape(String color)
	{
		this.color = color;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	abstract float getArea();
	abstract float getPerimeter();
}
class Circle extends Shape
{
		private float radius ;
		public Circle()
		{
			super();
			radius = 1.0f;
		}
		public Circle(float radius)
		{
			super();
			this.radius = radius;
		}
		public Circle(float radius, String color)
		{
			super(color);
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
}
class Rectangle extends Shape
{
	private float width;
	private float length;
	public Rectangle()
	{
		super();
		width = 1.0f;
		length =1.0f;
	}
	public Rectangle(float width, float length)
	{
		super();
		this.width = width;
		this.length = length;
	}
	public Rectangle(float width,float length, String color)
	{
		super(color);
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
}
class Square extends Shape
{
	private float side;
	Square()
	{	
		super();
		side = 1.0f;
	}
	Square(float side)
	{
		super();
		this.side = side;
	}
	Square(float side, String color)
	{
		super(color);
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
}
public class TestAbstract
{
	public static void main (String args[])
	{
		float dim1,dim2;
		String color;
		Shape sh;
		Scanner det = new Scanner(System.in);
		System.out.println("************Circle***********");
		System.out.println("Enter the radius");
		dim1 = det.nextFloat();
		System.out.println("Enter the colour");
		color = det.next();
		Circle c = new Circle(dim1,color);
		sh = c;
		System.out.println("*******************CIRCLE DETAILS******************");
		System.out.println("Radius    :" + c.getRadius());
		System.out.println("Color     :" + c.getColor());
		System.out.println("Area      :" + sh.getArea());
		System.out.println("Perimeter :" + sh.getPerimeter());
		
		
		System.out.println("************Rectangle***********");
		System.out.println("Enter the width");
		dim1 = det.nextFloat();
		System.out.println("Enter the length");
		dim2 = det.nextFloat();
		System.out.println("Enter the colour");
		color = det.next();
		Rectangle r = new Rectangle(dim1,dim2,color);
		sh = r;
		System.out.println("*******************RECTANGLE DETAILS******************");
		System.out.println("Width     :" + r.getWidth());
		System.out.println("Length    :" + r.getLength());
		System.out.println("Color     :" + r.getColor());
		System.out.println("Area      :" + sh.getArea());
		System.out.println("Perimeter :" + sh.getPerimeter());
		
		System.out.println("************Square***********");
		System.out.println("Enter the side");
		dim1 = det.nextFloat();
		System.out.println("Enter the colour");
		color = det.next();
		Square s = new Square(dim1,color);
		sh = s;
		System.out.println("*******************SQUARE DETAILS******************");
		System.out.println("Side      :" + s.getSide());
		System.out.println("Color     :" + s.getColor());
		System.out.println("Area      :" + sh.getArea());
		System.out.println("Perimeter :" + sh.getPerimeter());
	}
}
	
	
