//arka fucker gomlumon

import java.util.Scanner;
class Room
{
int l,b,h;

void getc(int len,int bre,int hei)

{
l=len;
b=bre;
h=hei;
}
int volume()
{
int vol;
vol=l*b*h;
return vol;
}
}
class RoomDemo extends Room
{
void display()
{
System.out.println("the volume is : "+volume());
}
}
class Main{
public static void main(String args[])
{
RoomDemo ob=new RoomDemo();
int a,b,c;
System.out.println("enter the length breadh and height respectively");
Scanner sc= new Scanner(System.in);
a=sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();
ob.getc(a,b,c);
ob.display();
}
}
