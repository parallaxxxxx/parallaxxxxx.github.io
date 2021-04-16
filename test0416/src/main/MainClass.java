package main;

import java.util.Scanner;

import cls.MemberCls;

public class MainClass {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        MemberCls mcls = new MemberCls();
        
        while(true){
        	
        	System.out.println("===menu===");
			System.out.println("1. 사원 등록");
			System.out.println("2. 모든 사원 출력");
			System.out.println("3. 사원 수정");
			System.out.println("4. 사원 검색");	
			System.out.println("==========");
            System.out.print(">>> ");
            
            int key = sc.nextInt();
            
            switch(key){
            
            case 1: // 등록
        
            	mcls.insert();
                break;
                
            case 2: // 출력
            	
            	mcls.allprint();
                break;
                
            case 3: // 수정
            	
            	mcls.update();
                break;
                
            case 4: // 검색
          
            	mcls.search();
                break;
                
        }
    }
	}
}
