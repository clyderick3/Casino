package com.github.zipcodewilmington.casino;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CasinoAccountManagerTest {
    CasinoAccountManager casinoAccountManager = new CasinoAccountManager();

    @BeforeAll
    void setup(){
        casinoAccountManager.setDbName("bd.bd");
    }

    @Test
    void createAccount() {
        //When
        casinoAccountManager.createAccount("admin1","admin1");
        CasinoAccount casinoAccount = casinoAccountManager.getAccount("admin1", "admin1");
        //Then
        Assertions.assertEquals("admin1",
                casinoAccountManager.getAccount("admin1","admin1").getAccountName());
    }

    @Test
    void registerAccount() {
        //When
        CasinoAccount casinoAccount = new CasinoAccount("admin2", "admin2");
        casinoAccountManager.registerAccount(casinoAccount);
        //Then
        Assertions.assertEquals(casinoAccount,casinoAccountManager.getAccount("admin2", "admin2"));
    }

    @Test
    void deleteAccount() {
        //When
        casinoAccountManager.createAccount("admin1","admin1");
        casinoAccountManager.deleteAccount(casinoAccountManager.getAccount(
                "admin1", "admin1"));
        //Then
        Assertions.assertNull(casinoAccountManager.getAccount("admin1", "admin1"));
    }
}