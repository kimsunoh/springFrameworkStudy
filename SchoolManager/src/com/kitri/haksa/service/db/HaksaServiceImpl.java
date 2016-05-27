package com.kitri.haksa.service.db;

import java.io.*;
import java.util.List;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaServiceImpl implements HaksaService {

   private BufferedReader in;
   String job[] = {"�й�", "����", "�μ�"};
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
         System.out.println(" ===== �޴����� ===== ");
         System.out.println("1. ���");
         System.out.println("2. ã��");
         System.out.println("3. ����");
         System.out.println("4. ��ü���");
         System.out.println("-------------------");
         System.out.println("0. ����");
         System.out.println("-------------------");
         System.out.print("�޴���ȣ�� �Է� : ");
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
      System.out.println(" ===== �޴����� ===== ");
      System.out.println("1. �л�");
      System.out.println("2. ����");
      System.out.println("3. ������");
      System.out.println("4. �����޴�");
      System.out.println("-------------------");
      System.out.println("0. ����");
      System.out.println("-------------------");
      System.out.print("�޴���ȣ�� �Է� : ");
      try {
         int num = Integer.parseInt(in.readLine());
         switch(num) {
         case 1 : case 2 : case 3 : { 
            System.out.print("���� : ");
            int age = Integer.parseInt(in.readLine());
            System.out.print("�̸� : ");
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
      System.out.println("ã�� �̸��� �Է��� �ּ���");
      System.out.print("�̸� : ");
      try {
         String name = in.readLine();
         HaksaDto haksaDto = haksaDao.findName(name);
         if(haksaDto != null)
            System.out.println("���� : " + haksaDto.getAge() + "\t�̸� : " + haksaDto.getName() + "\t" + haksaDto.getKeyName() + " : " + haksaDto.getValue());
         else
            System.out.println(name + "���� �������� �ʽ��ϴ�.");
         System.out.print("����Ͻ÷��� 1, �����Ͻ÷��� 0�� �Է��ϼ��� : ");
         int num = Integer.parseInt(in.readLine());
         if(num == 0)
            processExit();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void deleteMenu() {
      System.out.println("������ �̸��� �Է��� �ּ���");
      System.out.print("�̸� : ");
      try {
         String name = in.readLine();
         int cnt = haksaDao.delete(name);
         if(cnt != 0)
            System.out.println(name + "���� �����Ͽ����ϴ�.");
         else
            System.out.println(name + "���� �������� �ʽ��ϴ�.");
         System.out.print("����Ͻ÷��� 1, �����Ͻ÷��� 0�� �Է��ϼ��� : ");
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
            System.out.println("���� : " + haksaDto.getAge() + "\t�̸� : " + haksaDto.getName() + "\t" + haksaDto.getKeyName() + " : " + haksaDto.getValue());
         }
      } else {
         System.out.println("ȸ���� �����ϴ�.");
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