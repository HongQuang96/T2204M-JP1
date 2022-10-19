package bai4;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

public class ManagePhoneBook {
    static void menu() {
        System.out.println("PHONEBOOK MANAGEMENT SYSTEM");
        System.out.println("1. Insert phone");
        System.out.println("2. Remove phone");
        System.out.println("3. Update phone");
        System.out.println("4. Search phone");
        System.out.println("5. Sort");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        menu();
        PhoneBook pb = new PhoneBook();
        Scanner input = new Scanner(System.in);
        String name, phone;
        while (true) {
            System.out.print("Moi ban chon 1 muc: ");
            switch (input.nextLine()) {
                case "1":
                    System.out.print("Moi nhap ten: ");
                    name = input.nextLine();
                    System.out.print("Moi nhap so dien thoai: ");
                    phone = input.nextLine();
                    pb.insertPhone(name, phone);
                    break;
                case "2":
                    if (pb.PhoneList.isEmpty()) {
                        System.out.println("Danh ba trong!");
                        break;
                    }
                    System.out.print("Moi nhap ten nguoi dung muon xoa: ");
                    name = input.nextLine();
                    pb.removePhone(name);
                    pb.removePhone("DEF");
                    break;
                case "3":
                    if (pb.PhoneList.isEmpty()) {
                        System.out.println("Danh ba trong!");
                        break;
                    }
                    System.out.print("Moi nhap ten nguoi dung muon update: ");
                    name = input.nextLine();
                    System.out.print("Moi nhap so dien thoai muon update: ");
                    phone = input.nextLine();
                    pb.updatePhone(name, phone);
                    break;
                case "4":
                    if (pb.PhoneList.isEmpty()) {
                        System.out.println("Danh ba trong!");
                        break;
                    }
                    System.out.print("Moi nhap ten nguoi dung muon tim: ");
                    name = input.nextLine();
                    String result = pb.searchPhone(name);
                    if (result == null) {
                        System.out.println("Khong tim thay nguoi dung co ten: " + name);
                    } else {
                        System.out.println("Ket qua: " + result);
                    }
                    break;
                case "5":
                    if (pb.PhoneList.isEmpty()) {
                        System.out.println("Danh ba trong!");
                        break;
                    }
                    break;
                case "6":
                    return;
            }
        }
    }
}
