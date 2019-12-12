package com.view;

import java.util.List;
import java.util.Scanner;

import com.DTO.MemberDTO;
import com.biz.MemberBiz;
import com.biz.MemberBizImpl;

// controller + view
public class MemberView {

	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		sb.append("***************\n")
		  .append("* 1. 전체출력 *\n")
		  .append("* 2. 선택출력 *\n")
		  .append("* 3. 추	   가 *\n")
		  .append("* 4. 수	   정 *\n")
		  .append("* 5. 삭	   제 *\n")
		  .append("* 6. 종	   료 *\n")
		  .append("***************\n");
		
		System.out.println(sb);
		System.out.println("INPUT SELECT : ");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		
		int select = 0;
		
		MemberBiz biz = new MemberBizImpl();
		
		while(select != 6) {
			
			select = getMenu();
			
			switch(select) {
			case 1:
				System.out.println("[ 전체출력 ]");
				
				List<MemberDTO> list = biz.selectList();
				for(MemberDTO dto : list) {
					System.out.println(dto);
				}
				
				break;
				
			case 2:
				System.out.println("[ 선택출력 ]");
				System.out.println("찾을 번호 : ");
				int selectNo = sc.nextInt();
				
				System.out.println(biz.selectOne(selectNo));
				
				break;
			
			case 3:
				System.out.println("[ 추	가 ]");
				System.out.println("번호 입력 : ");
				int insertNo = sc.nextInt();
				System.out.println("이름 입력 : ");
				String insertName = sc.next();
				System.out.println("나이 입력 : ");
				int insertAge = sc.nextInt();
				System.out.println("성별 입력 (F / M) : ");
				String insertGen = sc.next();
				sc.nextLine();	// 개행문자를 제거해주기!
				System.out.println("주소 입력 : ");
				String insertLoc = sc.nextLine(); // 주소 안에 띄어쓰기가 있으면 넘어가버리기 때문에 nextLine!
				System.out.println("직업 입력 : ");
				String insertJob = sc.next();
				System.out.println("전화번호 입력 : ");
				String insertTel = sc.next();
				System.out.println("이메일 입력 : ");
				String insertEmail = sc.next();
				
				MemberDTO insertDto = new MemberDTO();
				insertDto.setNo(insertNo);
				insertDto.setName(insertName);
				insertDto.setAge(insertAge);
				insertDto.setGender(insertGen);
				insertDto.setLocation(insertLoc);
				insertDto.setJob(insertJob);
				insertDto.setTel(insertTel);
				insertDto.setEmail(insertEmail);
				
				int insertRes = biz.insert(insertDto);
				if(insertRes > 0) {
					System.out.println(insertRes + "개 INSERT 성공!");
				} else {
					System.out.println(insertRes + "개 INSERT 실패 ,,");
				}
				
				break;				
			
			case 4:
				System.out.println("[ 수	정 ]");
				System.out.println("수정할 번호 입력 : ");
				int updateNo = sc.nextInt();
				System.out.println("이름 입력 : ");
				String updateName = sc.next();
				System.out.println("나이 입력 : ");
				int updateAge = sc.nextInt();
				System.out.println("성별 입력 (F / M) : ");
				String updateGen = sc.next();
				System.out.println("주소 입력 : ");
				String updateLoc = sc.next();
				System.out.println("직업 입력 : ");
				String updateJob = sc.next();
				System.out.println("전화번호 입력 : ");
				String updateTel = sc.next();
				System.out.println("이메일 입력 : ");
				String updateEmail = sc.next();
				
				MemberDTO updateDto = new MemberDTO();
				updateDto.setNo(updateNo);
				updateDto.setName(updateName);
				updateDto.setAge(updateAge);
				updateDto.setGender(updateGen);
				updateDto.setLocation(updateLoc);
				updateDto.setJob(updateJob);
				updateDto.setTel(updateTel);
				updateDto.setEmail(updateEmail);
				
				int updateRes = biz.update(updateDto);
				if(updateRes > 0) {
					System.out.println(updateRes + "개 UPDATE 성공!");
				} else {
					System.out.println(updateRes + "개 UPDATE 실패 ,,");
				}
				
				break;			
			
			case 5:
				System.out.println("[ 삭	제 ]");
				System.out.println("삭제할 번호 : ");
				int deleteNo = sc.nextInt();
				
				int deleteRes = biz.delete(deleteNo);
				if(deleteRes > 0) {
					System.out.println(deleteRes + "개 DELETE 성공!");
				} else {
					System.out.println(deleteRes + "개 DELETE 실패 ,,");
				}
				
				break;		
			
			case 6:
				System.out.println("[ 종	료 ]");
				sc.close();
				System.exit(0);
			}
		}
	}
}
