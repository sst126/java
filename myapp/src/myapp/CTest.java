package myapp;

public class CTest {

	public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        int[] ar1=new int[]{8,2,5,11,3,19,12,21,32,9,6,1,3,15,0,7};
      //print first
        System.out.print("��ʼ��{");
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
        int a = 5;//����һ��������
        boolean b = (a<4)&&(a++<10);
        System.out.println("ʹ�ö�·�߼�������Ľ��Ϊ"+b);
        System.out.println("a�Ľ��Ϊ"+a);
    }

    /*
        ð������
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
        }while(blnth==true);//�������������� �ż���ִ��ѭ����
        
        //print after
        System.out.print("ð�����򷨣�ѭ������:");
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
     *��β������
     *��ͷ���� ���м俿 ԭ���ð����ֻͬ�����ҿ��� �ٶȿ�һ�㡣
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
                //������������ĵ���
                if(ar[i]> ar[i+1])
                {
                    int k =0;
                    k=ar[i];
                    ar[i]=ar[i+1];
                    ar[i+1]=k;
                }
            }
            //��С������ ������ ��������֪���� right--
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
        System.out.print("��β������,");
        System.out.print("ѭ������:");
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
     * ѡ������
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
            //�����λ�õ���һ��
            if(blndh){
                vm=ar[a];
                ar[a]=ar[pm];
                ar[pm]=vm;
            }
        }
        
        System.out.print("ѡ�����򷨣�ѭ������:");
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
            //�����λ�õ���һ��
            if(blndh){
                int vm ;
                vm=ar[a];
                ar[a]=ar[pm];
                ar[pm]=vm;
            }
        }
        
        System.out.print("ѡ�����򷨣�ѭ������:");
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
     * �������� �����������������Ƶ����Ų���� 
     * �ӵڶ���Ԫ�ؿ�ʼ ��ǰŲ����
     * һֱŲ���� ��С����ǰ����λ�õ� ֵ��
     */
    public static void insertSort(int[] ar) {
    	int k=0;
    	int ct=0;
    	//�ӵڶ���Ԫ�ؿ�ʼ�͵�һ���Ƚ�
    	for(int i=1;i<=ar.length-1;i++) {
    		k=ar[i];  //��ǰ�����������
    		//�ӵ�ǰԪ�غ�ǰһ��Ԫ����Ƚ�
    		int j=i-1; //��ȡǰ���Ǹ�Ԫ�ص�λ��
    		//���forѭ�� ����whileѭ������ 
    		//whileѭ�� ֻ���ж�
    		//����Ĵ�������ȷ�ɹ�ִ�еġ�
    		/*
    		for(int j=i-1;j>=0;j--) {
    			ct++;
    			if(k< ar[j]) {
    				//������Ų���Ĵ���̫���� ��ô�����ƶ�������
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
    		 * ��������˵�� ��ǰλ�õ� ������kֵ�� ���� 
    		 * ���j������Ǹ�Ԫ�ص�ֵ����Ӧ���滻Ϊk��Ԫ��
    		 */
    		ar[j+1]=k;
    	//pr(ar);
    	}
    	
    	//print after
        System.out.print("�������򷨣�ѭ������:");
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
