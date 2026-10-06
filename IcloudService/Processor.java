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
public class Processor {

    public static void main(String[] args) {
        CloudServiceArrayList a = new CloudServiceArrayList();
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("-------------------MENU--------------------");
            System.out.println("1. Add a StorageService or ComputeService.\n"
                    + "2. Update a cloud service by ID.\n"
                    + "3. Delete a cloud service by ID.\n"
                    + "4. Display all cloud services.\n"
                    + "5. Display active cloud services.\n"
                    + "6. Calculate and display the highest monthly cost among all cloud services.\n"
                    + "0. Exit the program.");
            System.out.println("");
            System.out.print("Enter an option: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1: {
                    System.out.println("1.StorageGB | 2.Compute");
                    System.out.print("Choose: ");
                    int enter = sc.nextInt();
                    if (enter == 1) {
                        StorageService storage = new StorageService();
                        storage.addService();
                        a.addServiceToArrayList(storage);
                    } else if (enter == 2) {
                        ComputeService compute = new ComputeService();
                        compute.addService();
                        a.addServiceToArrayList(compute);
                    } else {
                        System.out.println("invalid!");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter id to update: ");
                    String id = sc.nextLine();
                    a.updateServiceById(id);
                    break;
                }
                case 3: {
                    System.out.print("Enter id to delete: ");
                    String id = sc.nextLine();
                    a.deleteServiceById(id);
                    break;
                }
                case 4: {
                    System.out.println("-------------------DISPLAY-------------------");
                    a.displayAllService();
                    System.out.println("---------------------------------------------");
                    break;
                }
                case 5: {
                    System.out.println("---ALL CLOUD SERVICE---");
                    a.displayActiveServices();
                    break;
                }
                case 6: {
                    System.out.println("Highest monthly cost: "
                            + a.findHighestMonthlyCost());
                    break;
                }
                case 0: {
                    System.out.println("EXIT!");
                    break;
                }
                default:
                    System.out.println("invalid");
            }
        } while (choose != 0);
    }
}
