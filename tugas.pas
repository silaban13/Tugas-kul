program UjianUTS;
 uses crt;
type
   Pembeli = record
    Nama: string;
     Jumlah: integer;
     Total: longint;
    Discount: longint;
   end;
var
   DaftarPembeli: array[1..100] of Pembeli;
   JumlahPembeli, i: integer;
   HargaSendal: longint;

 begin
   clrscr;
   HargaSendal := 50000;

   write('Masukan Jumlah Pembeli : ');
   readln(JumlahPembeli);

   for i := 1 to JumlahPembeli do
   begin
     writeln('Pembeli ke    : ', i);
     write('Nama           : ');
     readln(DaftarPembeli[i].Nama);
     write('Jumlah         : ');
     readln(DaftarPembeli[i].Jumlah);

     DaftarPembeli[i].Total := DaftarPembeli[i].Jumlah * HargaSendal;

     if DaftarPembeli[i].Total >= 500000 then
       DaftarPembeli[i].Discount := round(0.2 * DaftarPembeli[i].Total)
     else
       DaftarPembeli[i].Discount := 0;
   end;

   writeln;
   writeln('Daftar Pembelian');
   writeln;
   writeln('Harga 1 Sendal = Rp ', HargaSendal, ',-');
   writeln('------------------------------------------------------------------------------------------------------------');
   writeln('No      Nama            Banyaknya          Jumlah            Discount               Total');
   writeln('------------------------------------------------------------------------------------------------------------');

   for i := 1 to JumlahPembeli do
   begin
     write(i:2, '. ');
     write(DaftarPembeli[i].Nama:7);
     write(DaftarPembeli[i].Jumlah:10);
     write(DaftarPembeli[i].Total:20);
     write(DaftarPembeli[i].Discount:20);
     writeln(DaftarPembeli[i].Total - DaftarPembeli[i].Discount:20);
  end;

   writeln('------------------------------------------------------------------------------------------------------------');
  readln;
end.
