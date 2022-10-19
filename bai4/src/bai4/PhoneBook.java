package bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook extends Phone {
    ArrayList<String> PhoneList = new ArrayList<>();

    @Override
    void insertPhone(String name, String phone) {
        if (PhoneList.isEmpty()) {
            PhoneList.add(name + ", " + phone);
        } else {
            String pb = searchPhone(name);
            if (pb != null) {
                if (!pb.contains(phone)) {
                    PhoneList.set(PhoneList.indexOf(pb), pb + " : " + phone);
                }
            } else {
                PhoneList.add(name + ", " + phone);
            }
        }
    }

    @Override
    void removePhone(String name) {
        String pb = searchPhone(name);
        if (pb != null) {
            PhoneList.remove(pb);
            System.out.println("Da xoa nguoi dung " + name + " kem cac so dien thoai khoi danh ba");
        } else {
            System.out.println("Khong tim thay nguoi dung " + name + " trong danh ba");
        }
    }

    @Override
    void updatePhone(String name, String newPhone) {
        String pb = searchPhone(name);
        if (pb != null) {
            if (!pb.contains(newPhone)) {
                PhoneList.set(PhoneList.indexOf(pb), pb.split(",")[0] + ", " + newPhone);
            }
        } else {
            System.out.println("Khong tim thay nguoi dung " + name + " trong danh ba de update");
        }
    }

    @Override
    String searchPhone(String name) {
        for (String pb : PhoneList) {
            if (pb.split(",")[0].equals(name)) {
                return pb;
            }
        }
        return null;
    }

    @Override
    void sort() {
        // sap xep tang dan
        System.out.println("Sap xep tang dan:");
        Collections.sort(PhoneList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(PhoneList);
        System.out.println("Sap xep giam dan:");
        Collections.sort(PhoneList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(PhoneList);
    }
}
