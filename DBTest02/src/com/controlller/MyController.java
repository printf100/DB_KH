package com.controlller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DAO.MyDAO;
import com.DTO.MyDTO;

// 요청이 들어오면 해당 요청에 맞는 화면을 뿌려줌
// 일단 여기서는 view까지 ㅇㅅㅇ
public class MyController {

	public static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		sb.append("1. 전체출력\n")
		  .append("2. 선택출력\n")
		  .append("3. 추	가\n")
		  .append("4. 수	정\n")
		  .append("5. 삭	제\n")
		  .append("6. 종	료\n");
		
		System.out.println(sb);
		System.out.println("번호 선택 : ");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		
		int menu = 0;
		MyDAO dao = new MyDAO();
		
		do {
			menu = getMenu();
			
			switch(menu) {
			case 1:
				System.out.println("[ 전체출력 ]");
				List<MyDTO> list = dao.selectList();
				for(MyDTO dto : list) {
					System.out.println(dto);
				}
				break;
				
			case 2:
				System.out.println("[ 선택출력 ]");
				System.out.println("찾을 번호 : ");
				int selectNo = sc.nextInt();
				MyDTO selectDto = dao.selectOne(selectNo);
				System.out.println(selectDto);
				
				break;				
			
			case 3:
				System.out.println("[ 추가 ]");
				System.out.println("번호 입력 : ");
				int insertNo = sc.nextInt();
				System.out.println("이름 입력 : ");
				String insertName = sc.next();
				System.out.println("별명 입력 : ");
				String insertNick = sc.next();
				
				MyDTO insertDto = new MyDTO();
				insertDto.setNo(insertNo);
				insertDto.setName(insertName);
				insertDto.setNickname(insertNick);
				
				int insertRes = dao.insert(insertDto);
				if(insertRes > 0)
					System.out.println(insertRes + "개 INSERT 성공!\n");
				else
					System.out.println(insertRes + "개 INSERT 실패 ,,\n");
				
				break;				
			
			case 4:
				System.out.println("[ 수정 ]");
				System.out.println("수정할 번호 : ");
				int updateNo = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 별명 : ");
				String updateNick = sc.next();
				
				MyDTO updateDto = new MyDTO();
				updateDto.setNo(updateNo);
				updateDto.setName(updateName);
				updateDto.setNickname(updateNick);
				
				int updateRes = dao.update(updateDto);
				if(updateRes > 0)
					System.out.println(updateRes + "개 UPDATE 성공!\n");
				else
					System.out.println(updateRes + "개 UPDATE 실패 ,,\n");
				
				break;			
			
			case 5:
				System.out.println("[ 삭제 ]");
				System.out.println("삭제할 번호 : ");
				int deleteNo = sc.nextInt();
				
				int deleteRes = dao.delete(deleteNo);
				if(deleteRes > 0)
					System.out.println(deleteRes + "개 DELETE 성공!\n");
				else
					System.out.println(deleteRes + "개 DELETE 실패 ,,\n");
				
				break;		
			
			case 6:
				System.out.println("[ 종료 ]");
				sc.close();
				System.exit(0);
			}
			
		} while(menu != 6);
	}
}
