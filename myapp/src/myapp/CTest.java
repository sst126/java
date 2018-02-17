package myapp;

public class CTest {

	public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        int[] ar1=new int[]{8,2,5,11,3,19,12,21,32,9,6,1,3,15,0,7};
      //print first
        System.out.print("初始：{");
        for(int i=0;i<ar1.length;i++)
        {
            System.out.print(ar1[i]);
            System.out.print(",");
        }
        
        System.out.println("}");
        //Maopao(ar1);
        //jiweijiu(ar1);
        //SelSort(ar1);
        //SelSort2(ar1);
        insertSort(ar1);
        //dl();
    }
    

    public static void dl(){
        int a = 5;//定义一个变量；
        boolean b = (a<4)&&(a++<10);
        System.out.println("使用短路逻辑运算符的结果为"+b);
        System.out.println("a的结果为"+a);
    }

    /*
        冒泡排序法
    */
    public static void Maopao(int[] ar)
    {
        int ct=0;
        
        //sort start
        boolean blnth=false;
        do{
            ct++;
            blnth=false;
            for(int i=0;i<ar.length -1;i++)
            {
                //check big or small
                if(ar[i]> ar[i+1])
                {
                    int k=0;
                    k=ar[i];
                    ar[i]=ar[i+1];
                    ar[i+1]=k;
                    blnth=true;
                }
            }
        }while(blnth==true);//这里满足的情况下 才继续执行循环体
        
        //print after
        System.out.print("冒泡排序法，循环次数:");
        System.out.print(ct);
        System.out.println("{");
        for(int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]);
            System.out.print(",");
        }
        System.out.println("}");
    }
    
    /*
     *鸡尾酒排序法
     *两头排序 往中间靠 原理和冒泡相同只是左右开工 速度快一点。
    */
    public static void jiweijiu(int[] ar)
    {
        int left=0;
        int right =ar.length-1;
        int ct=0;
        
        while(left <right){
            ct++;
            for(int i =0;i<right;i++)
            {
                //这里进行正常的调换
                if(ar[i]> ar[i+1])
                {
                    int k =0;
                    k=ar[i];
                    ar[i]=ar[i+1];
                    ar[i+1]=k;
                }
            }
            //从小到大了 这里面 最大的数字知道了 right--
            right--;
            for (int i=right;i> left+1;i--){
                if(ar[i-1]> ar[i]){
                    int k;
                    k=ar[i-1];
                    ar[i-1]=ar[i];
                    ar[i]=k;
                }
            }
            left++;
        }
        
        //print first
        System.out.print("鸡尾酒排序法,");
        System.out.print("循环次数:");
        System.out.println(ct);
        System.out.print("{");
        for(int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]);
            System.out.print(",");
        }
        System.out.println("}");
    }
    
    /*
     * 选择排序法
    */
    public static void SelSort(int[] ar){
        int ct=0;
        boolean blndh=false;
        int pm=0;//mini value item indexa
        for(int a=0;a<= ar.length-1;a++){           
            ct++;
            int vm=ar[a]; //mini value
            pm=a;
            for(int i=a;i<= ar.length-1;i++){    
                if(ar[i]<vm ){
                    vm=ar[i];
                    pm=i;
                    blndh=true;
                }
            }
            //这里把位置调换一下
            if(blndh){
                vm=ar[a];
                ar[a]=ar[pm];
                ar[pm]=vm;
            }
        }
        
        System.out.print("选择排序法，循环次数:");
        System.out.print(ct);
        System.out.println("{");
        for(int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]);
            System.out.print(",");
        }
        System.out.println("}");
    }
    
    public static void SelSort2(int[] ar){
        int ct=0;
        boolean blndh=false;
        int pm=0;//mini value item indexa
        for(int a=0;a<= ar.length-1;a++){           
            ct++;
            pm =a;
            for(int i=a;i<= ar.length-1;i++){    
                if(ar[i]<ar[pm] ){
                    pm=i;
                    blndh=true;
                }
            }
            //这里把位置调换一下
            if(blndh){
                int vm ;
                vm=ar[a];
                ar[a]=ar[pm];
                ar[pm]=vm;
            }
        }
        
        System.out.print("选择排序法，循环次数:");
        System.out.print(ct);
        System.out.println("{");
        for(int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]);
            System.out.print(",");
        }
        System.out.println("}");
    }
    
    /*
     * 插入排序法 这个方法的问题在于频繁的挪动， 
     * 从第二个元素开始 往前挪动。
     * 一直挪动到 不小于往前检索位置的 值。
     */
    public static void insertSort(int[] ar) {
    	int k=0;
    	int ct=0;
    	//从第二个元素开始和第一个比较
    	for(int i=1;i<=ar.length-1;i++) {
    		k=ar[i];  //当前的这个拿起来
    		//从当前元素和前一个元素相比较
    		int j=i-1; //获取前面那个元素的位置
    		//这个for循环 不如while循环好用 
    		//while循环 只管判断
    		//下面的代码是正确成功执行的。
    		/*
    		for(int j=i-1;j>=0;j--) {
    			ct++;
    			if(k< ar[j]) {
    				//这样做挪动的次数太多了 怎么减少移动次数？
    				ar[j+1]=ar[j];
    				if(j==0 || ar[j-1]<=k) {
    				ar[j]=k;
    				}
    			}else {
    				break;
    				//ar[j]=k;
    			}
    		*/
    		while(j>=0 && ar[j]>k) {
    			ar[j+1]=ar[j];
    			j--;
    		}
    		/*
    		 * 来到这里说明 当前位置的 并不比k值大 所以 
    		 * 这个j后面的那个元素的值就是应该替换为k的元素
    		 */
    		ar[j+1]=k;
    	//pr(ar);
    	}
    	
    	//print after
        System.out.print("插入排序法，循环次数:");
        System.out.print(ct);
        System.out.println("{");
        for(int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]);
            System.out.print(",");
        }
        System.out.println("}");
    }
    
    
    public static void pr(int[] ar){
    	 System.out.print("{");
         for(int i=0;i<ar.length;i++)
         {
             System.out.print(ar[i]);
             System.out.print(",");
         }
         System.out.println("}");
    }
}
