package com.recycleme.main;

import com.recycleme.dao.MasyarakatDao;
import com.recycleme.model.masyarakat.Masyarakat;

public class Main {
    public static void main(String[] args) {
        MasyarakatDao masyarakatDao = new MasyarakatDao();

        System.out.println(masyarakatDao.findAll().get(0).getNama());
        System.out.println(masyarakatDao.findAll().get(0).getAlamat());
    }
}
