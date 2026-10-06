/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IcloudService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Trung Hieu
 */
public abstract class CloudService implements ICloudService {

    private String id;
    private double baseMonthlyFee;
    private Date startDate;
    private boolean isActive;
    private int monthsUsed;

    public CloudService() {
    }

    public CloudService(String id, double baseMonthlyFee, Date startDate, boolean isActive, int monthsUsed) {
        this.id = id;
        this.baseMonthlyFee = baseMonthlyFee;
        this.startDate = startDate;
        this.isActive = isActive;
        this.monthsUsed = monthsUsed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public void setBaseMonthlyFee(double baseMonthlyFee) {
        this.baseMonthlyFee = baseMonthlyFee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getMonthsUsed() {
        return monthsUsed;
    }

    public void setMonthsUsed(int monthsUsed) {
        this.monthsUsed = monthsUsed;
    }

    @Override
    public void addService() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: ");
            setId(sc.nextLine());
            System.out.print("Enter base monthly fee: ");
            setBaseMonthlyFee(sc.nextDouble());
            sc.nextLine();
            SimpleDateFormat pdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Enter start date: ");
            String date = sc.nextLine();
            setStartDate(pdf.parse(date));
            System.out.print("is active (true/fasle):  ");
            setIsActive(sc.nextBoolean());
            System.out.print("Enter months used: ");
            setMonthsUsed(sc.nextInt());
        } catch (ParseException ex) {
            System.out.println("Wrong format!");
        }
    }

    @Override
    public void updateService() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter base monthly fee: ");
            setBaseMonthlyFee(sc.nextDouble());
            sc.nextLine();
            SimpleDateFormat pdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Enter start date: ");
            String date = sc.nextLine();
            setStartDate(pdf.parse(date));
            System.out.print("is active (true/false): ");
            setIsActive(sc.nextBoolean());
            System.out.print("Enter months used: ");
            setMonthsUsed(sc.nextInt());
        } catch (ParseException ex) {
            System.out.print("Wrong format!");
        }
    }

    @Override
    public void displayDetails() {
        SimpleDateFormat pdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + this.getId());
        System.out.println("base monthly fee: " + this.getBaseMonthlyFee());
        System.out.println("start date: " + pdf.format(startDate));
        System.out.println("is active: " + this.isIsActive());
        System.out.println("months used: " + this.getMonthsUsed());
    }

    @Override
    public abstract double calculateMonthlyCost();
}
