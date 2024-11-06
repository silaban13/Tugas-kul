   package com.lat1;

  import java.util.Scanner;

  class Barang {
      String kode;
      String nama;
      double harga;

      Barang(String kode, String nama, double harga) {
          this.kode = kode;
          this.nama = nama;
         this.harga = harga;
      }
  }

  public class Main {

      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          Barang[] barang = new Barang[100];
          int jumlahData = 0;
          double total = 0;


      do {
              System.out.print("~PENDATAAN~");
              System.out.print("\n");
              System.out.print("Input Jumlah Data       : ");
              jumlahData = scanner.nextInt();
              System.out.print("----------------------------------------");
              System.out.print("\n");
          } while (jumlahData < 1 || jumlahData > 100);
          scanner.nextLine();  

        
          for (int i = 0; i < jumlahData; i++) {
              System.out.print("Input Kode Barang: ");
              String kode = scanner.nextLine();
              System.out.print("Input Nama Barang: ");
              String nama = scanner.nextLine();
              double harga;
             do {
                  System.out.print("Input Harga Barang: ");
                  harga = scanner.nextDouble();
                  System.out.println("");  
              } while (harga < 0);
             scanner.nextLine();  
              barang[i] = new Barang(kode, nama, harga);
          }

        
          System.out.println("\n- Tabel Data Barang -");
          System.out.printf("%-10s %-30s %-10s%n", "Kode", "Nama Barang", "Harga");
          for (int i = 0; i < jumlahData; i++) {
              System.out.printf("%-10s %-30s %-10.2f%n", barang[i].kode, barang[i].nama, barang[i].harga);
          }

        
          String kodeInput;
         do {
             System.out.print("Ingin melakukan Transaksi? [Ya/Tidak]: ");
              kodeInput = scanner.nextLine();

              if (kodeInput.equalsIgnoreCase("Ya")) {
                System.out.println("Anda memilih untuk melakukan transaksi.");
                  System.out.print("Input Kode Barang: ");
                  String kodeBarang = scanner.nextLine();
                 boolean ditemukan = false;

                
                 for (int i = 0; i < jumlahData; i++) {
                      if (barang[i].kode.equals(kodeBarang)) {
                          ditemukan = true;
                         int jmlBarang;
                          do {
                              System.out.print("Input jumlah barang: ");
                              jmlBarang = scanner.nextInt();
                          } while (jmlBarang <= 0);
                          scanner.nextLine();  

                          double subtotal = barang[i].harga * jmlBarang;
                         total += subtotal;
                         System.out.println("Nama Barang: " + barang[i].nama);
                          System.out.printf("Subtotal: %.2f%n", subtotal);
                          break;
                      }
                  }

                  if (!ditemukan) {
                      System.out.println("Barang tidak ditemukan.");
                 }
             } else {
                System.out.println("Anda memilih untuk tidak melakukan transaksi.");
             }

            
             System.out.print("Tambah belanja? [Ya/Tidak]: ");
              kodeInput = scanner.nextLine();
              if (kodeInput.equalsIgnoreCase("Ya")) {
                 System.out.println("Anda memilih untuk menambah belanja.");
             } else {
                 System.out.println("Anda memilih untuk tidak menambah belanja.");
            }
        } while (kodeInput.equalsIgnoreCase("Ya"));

        
         System.out.printf("Total: %.2f%n", total);
          scanner.close();
      }
 }

    
