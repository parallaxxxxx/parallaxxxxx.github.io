package cls;

import java.util.List;
import java.util.Scanner;

import dao.MemberDao;
import dto.MemberDto;

public class MemberCls {

    Scanner sc = new Scanner(System.in);
    MemberDao dao = MemberDao.getInstance();

    
	public void insert() {
	       
    	System.out.print("사원 이름 : ");
		String name = sc.next();
		
		System.out.print("부서 : ");
		String dept = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("직업 : ");
		String job = sc.next();
		
		System.out.print("급여 : ");
		int sal = sc.nextInt();
		
		boolean b = dao.addMember(new MemberDto(name, dept, phone, job, sal));
		if(b) {
			System.out.println("정상적으로 추가 되었습니다");
			return;
		}
		
		System.out.println("추가되지 않았습니다");

	}

	public void allprint() {
		
		List<MemberDto> list = dao.getMemList();
    	for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	public void update() {
		

    	System.out.print("수정할 사원의 이름을 입력하세요 >> ");
		String name = sc.next();
		
		System.out.print("수정할 급여를 입력하세요 >> ");
		int sal = sc.nextInt();
		
		boolean b = dao.updateMem(name, sal);
		
		if(b) {
			System.out.println("정상적으로 수정 되었습니다");
			return;
		}
		
		System.out.println("수정되지 않았습니다");
	}
	
	
	public void search() {
		
		System.out.print("검색할 사원의 이름을 입력하세요 >> ");
		String eename = sc.next();
		
		MemberDto dto = dao.getMem(eename);
		if(dto == null) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		System.out.println(dto.toString());
	}
}
