class Sort<T extends Comparable<T>>{
	T arr[];

	public Sort(T arr[]){
		this.arr = arr;

		for(int i = 0 ; i < arr.length ; i++)
			for(int j = i + 1 ; j < arr.length ; j++)
				if(arr[i].compareTo(arr[j]) > 0 ){
					T tmp = arr[i];
					arr[i] =  arr[j];
					arr[j] = tmp;
				}
	}

	public void display(){
		for(int i = 0 ; i < arr.length ; i++)
			System.out.println(arr[i] + "\t");

	}
}


class TestSort{
	public static void main(String[] args){

		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int opt = 0;
		int ch = 0;

		while(opt != 4){
			System.out.println("\n\tSort Menu");
			System.out.println("1. Integer Array");
			System.out.println("2. Double Array");
			System.out.println("3. String Array");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			opt = input.nextInt();
			
			switch(opt){
				case 1: {
							int temp;
							int size;
							System.out.print("Enter Size of the Integer Array: ");
							size = input.nextInt();

							Integer arr[] = new Integer[size];
							
							for(int i = 0 ; i < arr.length ; i++)
							{
								System.out.print("Enter Element : ");
								arr[i] = input.nextInt();
							}
							Sort<Integer> s = new Sort<Integer>(arr);

							System.out.println("\nSorted Array: ");
							s.display();
						}
						break;
				case 2: {
							double temp;
							int size;
							System.out.print("Enter Size of Double array: ");
							size = input.nextInt();
							
							Double arr[] = new Double[size];
							
							for(int i = 0 ; i < arr.length ; i++)
							{
								System.out.print("Enter Element : ");
								arr[i] = input.nextDouble();
							}
							Sort<Double> s = new Sort<Double>(arr);

							System.out.println("\nSorted Array: ");
							s.display();
						}
						break;
				case 3: {
							String temp;
							int size;
							System.out.print("Enter Size of String array: ");
							size = input.nextInt();

							String arr[] = new String[size];
							
							for(int i = 0 ; i < arr.length ; i++)
							{
								System.out.print("Enter String : ");
								arr[i] = input.next();
							}
							Sort<String> s = new Sort<String>(arr);

							System.out.println("\nSorted Array: ");
							s.display();
						}
						break;
			}
		}
	}
}
