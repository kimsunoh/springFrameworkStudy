package com.kitri.haksa.service.db;

import java.io.*;
import java.util.List;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaServiceImpl implements HaksaService {

   private BufferedReader in;
   String job[] = {"학번", "과목", "부서"};
   HaksaDao haksaDao;
   boolean flag = true;
   
   public HaksaServiceImpl() {
      in = new BufferedReader(new InputStreamReader(System.in));
   }
   
   public void setHaksaDao(HaksaDao haksaDao) {
      this.haksaDao = haksaDao;
   }

   @Override
   public void menu() {
      while(flag) {
         System.out.println(" ===== 메뉴선택 ===== ");
         System.out.println("1. 등록");
         System.out.println("2. 찾기");
         System.out.println("3. 삭제");
         System.out.println("4. 전체목록");
         System.out.println("-------------------");
         System.out.println("0. 종료");
         System.out.println("-------------------");
         System.out.print("메뉴번호를 입력 : ");
         try {
            int num = Integer.parseInt(in.readLine());
            switch(num) {
            case 1 : registerMenu(); break;
            case 2 : findNameMenu(); break;
            case 3 : deleteMenu(); break;
            case 4 : selectAll(); break;
            default : processExit();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public void registerMenu() {
      System.out.println(" ===== 메뉴선택 ===== ");
      System.out.println("1. 학생");
      System.out.println("2. 교수");
      System.out.println("3. 관리자");
      System.out.println("4. 이전메뉴");
      System.out.println("-------------------");
      System.out.println("0. 종료");
      System.out.println("-------------------");
      System.out.print("메뉴번호를 입력 : ");
      try {
         int num = Integer.parseInt(in.readLine());
         switch(num) {
         case 1 : case 2 : case 3 : { 
            System.out.print("나이 : ");
            int age = Integer.parseInt(in.readLine());
            System.out.print("이름 : ");
            String name = in.readLine();
            System.out.print(job[num - 1] + " : ");
            String value = in.readLine();
            
            HaksaDto haksaDto = new HaksaDto();
            haksaDto.setAge(age);
            haksaDto.setName(name);
            haksaDto.setKey(num);
            haksaDto.setValue(value);
            haksaDao.register(haksaDto);
         } break;
         case 4 : ;break;
         default : processExit();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void findNameMenu() {
      System.out.println("찾을 이름을 입력해 주세요");
      System.out.print("이름 : ");
      try {
         String name = in.readLine();
         HaksaDto haksaDto = haksaDao.findName(name);
         if(haksaDto != null)
            System.out.println("나이 : " + haksaDto.getAge() + "\t이름 : " + haksaDto.getName() + "\t" + haksaDto.getKeyName() + " : " + haksaDto.getValue());
         else
            System.out.println(name + "님은 존재하지 않습니다.");
         System.out.print("계속하시려면 1, 종료하시려면 0을 입력하세요 : ");
         int num = Integer.parseInt(in.readLine());
         if(num == 0)
            processExit();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void deleteMenu() {
      System.out.println("삭제할 이름을 입력해 주세요");
      System.out.print("이름 : ");
      try {
         String name = in.readLine();
         int cnt = haksaDao.delete(name);
         if(cnt != 0)
            System.out.println(name + "님은 삭제하였습니다.");
         else
            System.out.println(name + "님은 존재하지 않습니다.");
         System.out.print("계속하시려면 1, 종료하시려면 0을 입력하세요 : ");
         int num = Integer.parseInt(in.readLine());
         if(num == 0)
            processExit();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void selectAll() {
      List<HaksaDto> list = haksaDao.selectAllList();
      int size = list.size();
      if(size != 0) {
//         for(int i=0;i<size;i++) {
//            HaksaDto dto = list.get(i);
//         }
         for(HaksaDto haksaDto : list) {
            System.out.println("나이 : " + haksaDto.getAge() + "\t이름 : " + haksaDto.getName() + "\t" + haksaDto.getKeyName() + " : " + haksaDto.getValue());
         }
      } else {
         System.out.println("회원이 없습니다.");
      }
   }

   @Override
   public void processExit() {
      try {
         if(in != null)
            in.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      flag = false;
      System.exit(0);
   }

}