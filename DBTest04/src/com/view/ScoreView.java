package com.view;

import java.util.List;
import java.util.Scanner;

import com.DTO.ScoreDTO;
import com.biz.ScoreBiz;
import com.biz.ScoreBizImpl;

public class ScoreView {

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
		
		ScoreBiz biz = new ScoreBizImpl();
		
		while(select != 6) {
			
			select = getMenu();
			
			switch(select) {
			case 1:
				System.out.println("[ 전체출력 ]");
				
				List<ScoreDTO> list = biz.selectList();
				for(ScoreDTO dto : list) {
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
				System.out.println("국어점수 입력 : ");
				int insertKor = sc.nextInt();
				System.out.println("영어점수 입력 : ");
				int insertEng = sc.nextInt();
				System.out.println("수학점수 입력 : ");
				int insertMath = sc.nextInt();
				
				ScoreDTO insertDto = new ScoreDTO(insertNo, insertName, insertKor, insertEng, insertMath);
				
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
				System.out.println("국어점수 입력 : ");
				int updateKor = sc.nextInt();
				System.out.println("영어점수 입력 : ");
				int updateEng = sc.nextInt();
				System.out.println("수학점수 입력 : ");
				int updateMath = sc.nextInt();
				
				ScoreDTO updateDto = new ScoreDTO(updateNo, updateName, updateKor, updateEng, updateMath);
				
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
