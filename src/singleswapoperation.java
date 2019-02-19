
public class singleswapoperation {
	public static void swap(int a[]) {
		int temp=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i]>a[j]) {
					//System.out.println("a of i "+a[i]+"  a of j  "+a[j]);
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				//System.out.println(" after wap  a of i "+a[i]+"  a of j  "+a[j]);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		int a[]= {1,5,3,3,7};
		System.out.println("before swap");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}
        swap(a);
        System.out.println("after swap");
        for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}
	}

}
