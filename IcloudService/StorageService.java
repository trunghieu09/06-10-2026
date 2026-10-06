/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IcloudService;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Trung Hieu
 */
public class StorageService extends CloudService {

    private int storageGB;
    private boolean encryptionEnable;

    public StorageService() {
    }

    public StorageService(int storageGB, boolean encryptionEnable) {
        this.storageGB = storageGB;
        this.encryptionEnable = encryptionEnable;
    }

    public StorageService(int storageGB, boolean encryptionEnable, String id, double baseMonthlyFee, Date startDate, boolean isActive, int monthsUsed) {
        super(id, baseMonthlyFee, startDate, isActive, monthsUsed);
        this.storageGB = storageGB;
        this.encryptionEnable = encryptionEnable;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    public boolean isEncryptionEnable() {
        return encryptionEnable;
    }

    public void setEncryptionEnable(boolean encryptionEnable) {
        this.encryptionEnable = encryptionEnable;
    }

    @Override
    public void addService() {
        super.addService();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter storageGB: ");
        setStorageGB(sc.nextInt());
        System.out.print("Enter encryption enable (true/false):  ");
        setEncryptionEnable(sc.nextBoolean());
    }

    @Override
    public void updateService() {
        super.updateService();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter storageGB: ");
        setStorageGB(sc.nextInt());
        System.out.print("Enter encryption enable: ");
        setEncryptionEnable(sc.nextBoolean());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("storageGB: " + this.getStorageGB());
        System.out.println("encryption enable: " + this.isEncryptionEnable());
    }

    @Override
    public double calculateMonthlyCost() {
        double baseCost = this.getBaseMonthlyFee() * this.getMonthsUsed();
        if (this.getStorageGB() >= 1000) {
            baseCost += baseCost * 0.2;
        } else if (this.getStorageGB() >= 500) {
            baseCost += baseCost * 0.1;
        } else {
            baseCost += baseCost * 0.05;
        }
        return baseCost;
    }
}
