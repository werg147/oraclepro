package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList;
		
		//리스트
		personList = phoneDao.getPersonList();
		
		//시작화면
		System.out.println("********************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("********************************************");
		
		int personId;
		String name;
		String hp;
		String company;
		
		//while-switch
		boolean run = true;
		
		while(run) {
			//메뉴출력
			System.out.println("");
			System.out.println("1.리스트   2.등록   3.수정   4.삭제   5.검색   6.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호: ");
			
			int menu = sc.nextInt();
			sc.nextLine(); //콘솔 입출력 오류 방지
			
			switch(menu) {
				//1.리스트
				case 1:
					System.out.println("<1.리스트>");
					
					for(int i=0; i<personList.size(); i++) {
						PersonVo vo = personList.get(i);
						System.out.println(vo.getPersonId() + ".\t" + vo.getName() + "\t" + vo.getHp() + "\t" + vo.getCompany());
					}
					
					break;
			
				//2.등록
				case 2:
					System.out.println("<2.등록>");
					
					System.out.print("이름> ");
					name = sc.nextLine();
					System.out.print("휴대전화> ");
					hp = sc.nextLine();
					System.out.print("회사번호> ");
					company = sc.nextLine();
					
					phoneDao.personInsert(name, hp, company);
					
					System.out.println("[등록되었습니다]");
					break;
					
				//3.수정
				case 3:
					System.out.println("<3.수정>");
					
					System.out.print("번호> ");
					personId = sc.nextInt();
					System.out.print("이름> ");
					name = sc.nextLine();
					System.out.print("휴대전화> ");
					hp = sc.nextLine();
					System.out.print("회사번호> ");
					company = sc.nextLine();
					
					phoneDao.personUpdate(personId, name, hp, company);
					
					System.out.println("[1건 수정되었습니다.]");
					break;
			
				//4.삭제
				case 4:
					System.out.println("<4.삭제>");
					
					System.out.print(">번호 : ");
					personId = sc.nextInt();
					
					phoneDao.personDelete(personId);
					
					System.out.println("[1건 삭제되었습니다.]");
					break;
			
				//5.검색
				case 5:
					System.out.println("<5.검색>");
					
					System.out.print("검색어 > ");
					String keyword = sc.nextLine();
					
					//phoneDao.getPersonList(keyword); //오류
			
				//6.종료
				case 6:
					run = false;
					break;
			
				//예외
				default:
					System.out.println("[다시 입력해 주세요.]");
					break;
				
			}
			
		}
	
		sc.close();

	}

}
