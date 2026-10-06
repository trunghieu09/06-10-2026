/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IcloudService;

import java.util.*;

/**
 *
 * @author Trung Hieu
 */
public class ComputeService extends CloudService {

    private int cpuCores;
    private double runtimeHours;

    public ComputeService() {
    }

    public ComputeService(int cpuCores, double runtimeHours) {
        this.cpuCores = cpuCores;
        this.runtimeHours = runtimeHours;
    }

    public ComputeService(int cpuCores, double runtimeHours, String id, double baseMonthlyFee, Date startDate, boolean isActive, int monthsUsed) {
        super(id, baseMonthlyFee, startDate, isActive, monthsUsed);
        this.cpuCores = cpuCores;
        this.runtimeHours = runtimeHours;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public double getRuntimeHours() {
        return runtimeHours;
    }

    public void setRuntimeHours(double runtimeHours) {
        this.runtimeHours = runtimeHours;
    }

    @Override
    public void addService() {
        super.addService();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter cpu cores: ");
        setCpuCores(sc.nextInt());
        System.out.print("runtime hours: ");
        setRuntimeHours(sc.nextDouble());
    }

    @Override
    public void updateService() {
        super.updateService();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter cpu cores: ");
        setCpuCores(sc.nextInt());
        System.out.print("runtime hours: ");
        setRuntimeHours(sc.nextDouble());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("cpu cores: " + this.getCpuCores());
        System.out.println("runtime hours: " + this.getRuntimeHours());
    }

    @Override
    public double calculateMonthlyCost() {
        double baseCost = this.getBaseMonthlyFee() * this.getMonthsUsed();
        if (this.getCpuCores() >= 16) {
            baseCost += baseCost * 0.25;
        } else if (this.getCpuCores() >= 8) {
            baseCost += baseCost * 0.15;
        } else {
            baseCost += baseCost * 0.05;
        }
        if (this.getRuntimeHours() > 200) {
            baseCost += (this.getRuntimeHours() - 200) * 0.5;
        }
        return baseCost;
    }
}
