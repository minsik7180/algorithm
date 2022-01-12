package 클래스;

import java.util.Scanner;

public class PhysicalExamination {
	static final int VMAX = 21;
	
	
	static class PhyscData{ //내부 클래스 선언
		String name; //이름 
		int height;  // 키
		double vision;  //시력
		
		PhyscData(String name, int height, double vision){  //PhyscData 의 생성자
			this.name = name; 
			this.height = height;
			this.vision = vision;
		}	
	}
	static void visionstar(double vision) {
		for(int i=0; i<vision; i++) {
			System.out.print("*");
		}
	}
	 
	// 키의 평균값을 구함
	static double aveHeight(PhyscData[] dat) {  //배열을 받고 배열의 값을 다 더한뒤 배열의 길이로 나누는 함수 == 평균
		double sum =0;
		
		for(int i=0; i<dat.length; i++) 
			sum += dat[i].height;
			
		return sum/dat.length;
		
	}
	//시력 분포를 구함
	static void distVision(PhyscData[] dat, int[] dist) {
		
		int i=0;
		dist[i] = 0;
		for(i =0; i<dat.length; i++)
			if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX /10.0)// 시력 0.0 ~ 2.1
				dist[(int)(dat[i].vision * 10)]++; // 시력 분포도 
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		PhyscData[] x = {                      //PhyscData 클래스 배열 생성 , 생성자로 초기화 
				new PhyscData("박현규",162,0.3),
				new PhyscData("함진아",173,0.7),
				new PhyscData("최윤미",175,2.0),
				new PhyscData("홍연의",171,1.5),
				new PhyscData("이수진",168,0.4),
				new PhyscData("김영준",174,1.2),
				new PhyscData("박용규",169,1.2),
		};
		int[] vdist = new int[VMAX]; //시력분포 인덱스가 시력임
		
		System.out.println("신체검사 리스트");
		System.out.println("이름      키   시력");
		System.out.println("------------------");
		
		for(int i=0; i<x.length; i++) 
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
			
		System.out.printf("\n평균 키: %5.1fcm\n", aveHeight(x));
		distVision(x,vdist);
		
		System.out.println("\n시력 분포");
		for(int i=0; i<VMAX; i++) {
//			System.out.printf("%3.1f~ :%2d명\n" ,i /10.0, vdist[i]);
			System.out.printf("%3.1f~ : " , i/10.0);
			visionstar(vdist[i]);
			System.out.println();			
		}	
	}
	
}
