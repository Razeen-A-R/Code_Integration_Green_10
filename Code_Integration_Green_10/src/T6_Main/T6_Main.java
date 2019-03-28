

import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class T6_Main {
    public static void main(String[] args) {

T6();
 }
    
    public static void T6() {
        Scanner hd=new Scanner(System.in);
        Finch myFinch = new Finch();
        int decimal;
        String octal,hexadecimal = null,binaryend,binary;
        boolean ended = false, yesno = false,digit = false;
        char end;
        
        do {
      	 
        do{
      	  //will keep asking to enter a hexadecimal till valid
            System.out.println("Enter a 2 digit hexadecimal number : ");

                 hexadecimal=hd.nextLine();

              int length = hexadecimal.length();

       
         if(length==2)
        {
        digit = true;
        }
        }while(digit== false);

     try{   

        if(digit==true) {
      	  
    //conversions from hexadecimal input to oct,dec,bin
      	  
        decimal=Integer.parseInt(hexadecimal, 16);

        binary=Integer.toBinaryString(decimal);

        octal=Integer.toOctalString(decimal);

        Integer oct =Integer.parseInt(octal);

        binaryend = "#"+binary;

       //printing conversions
       
        System.out.println("Decimal : " + decimal);

        System.out.println("Binary : " + binary);

        System.out.println("Octal : " + octal);

       

        //colours
        int red = decimal;

        int green = (red%80) +60;

        int blue = (red + green)/2;

        System.out.println("Red: " + red);

        System.out.println("Green: " + green);

        System.out.println("Blue: " + blue);
        
        //finch speak

        System.out.println("The dance will begin now");
        myFinch.saySomething("The dance will begin now");

        myFinch.setLED(red, green, blue);

        System.out.println("Red: " + red);

        System.out.println("Green: " + green);

        System.out.println("Blue: " + blue);

      //for loop to read binary right to left and then move at speed depending on the oct value

        int binlength = binaryend.length()-1;

        for(int i=binlength;i>=0;i--) {

               if(binaryend.charAt(i)=='1') {

                     //move forwards
              	 

               System.out.println("forward");
               if(oct<=60) {

                   myFinch.setWheelVelocities(oct + 30,oct + 30,800);

   }else if(oct>255){

                   myFinch.setWheelVelocities(255,255,800);

   }else {

                   myFinch.setWheelVelocities(oct,oct,800);
   }

        }

               else if(binaryend.charAt(i)=='0') {

//-speed as backward moving 
        System.out.println("backwards");
        if(oct<=60) {

            myFinch.setWheelVelocities(-(oct + 30),-(oct + 30),800);

            
}else if(oct>255){
            myFinch.setWheelVelocities(-255,-255,800);
}else {
            myFinch.setWheelVelocities(-oct,-oct,800);
}
}else if(binaryend.charAt(i)=='#') {
      	 
            if(oct<=60) {

                System.out.println("The speed of the finch was " + (oct + 30));

}else if(oct>255){

                System.out.println("The speed of the finch was 255");

}else {

                System.out.println("The speed of the finch was " + oct);
}

               System.out.println("dance has ended");      
               myFinch.buzz(350, 2500);
 
                     System.out.println("Do you want to re-run programme (Y/N) :");

                     end = hd.next().charAt(0);

                     if(end=='y'||end=='Y') {

                            yesno = true;

                     digit=false;
                   
               }else {

                     System.out.println("end");

                     ended = true;

                     yesno = true;
               }

                     hd.nextLine();
        }

        }

        }     

    //catches error if input isnt hexadecimal
     }catch (Exception e){
  		System.out.println("Thats not a hexadecimal!");
     }
     //loops entire code unless they choose end 
        }while(ended==false);
//closes scanner to prevent leak however VM should take care of it
        hd.close();
    }
}
