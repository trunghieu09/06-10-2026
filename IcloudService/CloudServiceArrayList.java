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
public class CloudServiceArrayList {

    ArrayList<CloudService> services = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addServiceToArrayList(CloudService service) {
        services.add(service);
    }

    public void updateServiceById(String id) {
        for (int i = 0; i < services.size(); i++) {
            CloudService service = services.get(i);
            if (service.getId().equalsIgnoreCase(id)) {
                service.updateService();
                System.out.println("update successfully!");
                return;
            }
        }
        System.out.println("Invalid");
    }

    public void deleteServiceById(String id) {
        for (int i = 0; i < services.size(); i++) {
            CloudService service = services.get(i);
            if (service.getId().equalsIgnoreCase(id)) {
                services.remove(i);
                System.out.println("delete successfully!");
                return;
            }
        }
        System.out.println("Invalid");
    }

    public void displayAllService() {
        for (int i = 0; i < services.size(); i++) {
            CloudService service = services.get(i);
            service.displayDetails();
        }
    }

    public void displayActiveServices() {

        for (int i = 0; i < services.size(); i++) {
            CloudService service = services.get(i);
            if (service.isIsActive()) {
                service.displayDetails();
            }
        }
    }

    public double findHighestMonthlyCost() {
        if (services.isEmpty()) {
            return 0;
        }
        CloudService max = services.get(0);
        for (int i = 0; i < services.size(); i++) {
            CloudService service = services.get(i);
            if (service.calculateMonthlyCost() > max.calculateMonthlyCost()) {
                max = service;
            }
        }
        
        return max.calculateMonthlyCost();
    }
}
