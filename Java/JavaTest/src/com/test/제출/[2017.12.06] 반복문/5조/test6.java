import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class test6 {
	
	public static void main(String[] args)	throws Exception {


		//����6.
		//�䱸����] ���� 1�� 1�� 1�Ϻ��� 2017�� 12�� 6�ϱ��� �� ��ĥ�� �������� ���Ͻÿ�.
		//���] �� 4,563,543�� �������ϴ�.
		//����] Calendar ��� ����
		//���] for�� ���, ���� ���
		//����] ��� %7 = ?


			BufferedReader reader
			= new BufferedReader(new InputStreamReader(System.in));

		int day = 0;
		int sum = 0;

		for(int i=1;i<2018 ;i++){

				if(i==2017){ 
					sum = sum+day-26;
				
					break;
				}//if				

			if(i % 4 != 0){
				day = 365;
			}else if(i % 100 != 0){
				day = 366;
			}else if(i % 400 == 0) {
				day = 366;
			}else{ 
				day = 365;
			}


			sum += day;

		}//for
	System.out.println(sum);
	System.out.println(sum%7);

	}//main
	}//class