
import java.io.File;
import java.io.IOException; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
class Library{
    public void Login()
    {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        System.out.println("\n\n      ----------------------------------Library Management System----------------------------------\n\n");
        System.out.print("                     Username: ");
        Scanner ur = new Scanner(System.in);
        String user = ur.nextLine();
        System.out.print("                     Paassword: ");
        Scanner lp = new Scanner(System.in);
        String pass = lp.nextLine();
        if(user.matches("Admin")){
            if(pass.matches("asdf1234")){
                Library Ly = new Library();
                Ly.MyMain();
            }
        }else{
            System.out.print("                     wrong usernane or password");
        }
    }
    public void MyMain() 
    {
        System. out. print("\033[H\033[2J");
        System. out. flush(); 
        String dayString;
        System.out.println("\n\n      ----------------------------------Library Management System----------------------------------\n\n");
        System.out.println("                     Press 1 to add Book");
        System.out.println("                     Press 2 to issue a book");
        System.out.println("                     Press 3 to return a book");
        System.out.println("                     Press 4 to Logout");
        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        switch (choice) { 
            case 1: 
            AddBook book = new AddBook(); 
            book.AddaBook();
            break; 
            case 2: 
            IssueBook Ib = new IssueBook();
            Ib.IssueaBook();
            break;
            case 3: 
            ReturnBook Rb = new ReturnBook();
            Rb.ReturnaBook();
            break;
            case 4: 
            Library login= new Library();
            login.Login();
            break;
            default: 
            System.out.print("Invalid input"); 
            break; 
        }
    }
    public static void main(String[] args) 
    {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        System.out.println("\n\n      ----------------------------------Library Management System----------------------------------\n\n");
        System.out.print("                     Username: ");
        Scanner ur = new Scanner(System.in);
        String user = ur.nextLine();
        System.out.print("                     Paassword: ");
        Scanner lp = new Scanner(System.in);
        String pass = lp.nextLine();
        if(user.matches("Admin")){
            if(pass.matches("asdf1234")){
                Library Ly = new Library();
                Ly.MyMain();
            }\
        }else{
            System.out.print("                     wrong usernane or password");
        }
    }
}

//Class AddBook start
class AddBook{
    int count4=0;
    public void AddaBook(){
        System. out. print("\033[H\033[2J");
        System. out. flush();
        try {

            //file writing
            FileWriter myWriter = new FileWriter("books.txt",true);
            System.out.println("\n\n      ---------------------------------- Add a book ----------------------------------\n\n");
            //Input book Id
            System.out.print("                     Enter the 4 digit Book ID: ");
            Scanner bid = new Scanner(System.in);
            String bookID = bid.nextLine();
            //input Book Name
            System.out.print("                     Enter the Book Name: ");
            Scanner bn = new Scanner(System.in);
            String bookName = bn.nextLine();
            //input Book Author
            System.out.print("                     Enter the book Author: ");
            Scanner ba = new Scanner(System.in);
            String bookAuthor = ba.nextLine();

            File f4 = new File("books.txt");
             Scanner myReader4 = new Scanner(f4);
             while (myReader4.hasNextLine()) {
                String data4 = myReader4.nextLine();
                String s4 = data4;  
                if(s4.contains(bookID)==true){
                    count4++;
                }
            }
            if (count4>0){
                System.out.print("\n\n                     Book already exists");
            }
            else
            {
                FileWriter Writer1 = new FileWriter("IssueBooks.txt",true);
                //writing in file 
                myWriter.write(" \r\n");
                myWriter.write(bookID);
                myWriter.write(" ");
                myWriter.write(bookName);
                myWriter.write(" ");
                myWriter.write(bookAuthor);
                myWriter.close();
                System.out.println("\n\n                     Book added successfully.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //menu
        System.out.println("\n\n      ---------------------------------- Menu ----------------------------------\n\n");
        System.out.print("press 1 to add a book.\r\n      2 for main menu: ");
        Scanner m = new Scanner(System.in);
        int menu = m.nextInt();

        switch (menu) { 
            case 1: 
            AddBook book = new AddBook(); 
            book.AddaBook(); 
            break;

        case 2: 
        Library lib = new Library();
        lib.MyMain();
        break;
        }
    }
}

//end of class AddBook

//start of IssueBook class
class IssueBook{
    int count=0; 
    int count1=0; 
   public void IssueaBook(){
        System. out. print("\033[H\033[2J");
        System. out. flush();
        try {

            //file writing
            FileWriter myWriter = new FileWriter("issuebooks.txt",true);
            System.out.println("\n\n      ---------------------------------- Issue book ----------------------------------\n\n");
            //Input book Id
            System.out.print("                     Enter the student registration Number: ");
            Scanner sreg = new Scanner(System.in);
            String stureg = sreg.nextLine();
            //input Book Name
            System.out.print("                     Enter the Book ID: ");
            Scanner ibi = new Scanner(System.in);
            String IssuedBookID= ibi.nextLine();
            //input Book Author
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
             LocalDateTime now = LocalDateTime.now();
            //reading a file

             File f2 = new File("books.txt");
             Scanner myReader2 = new Scanner(f2);
             while (myReader2.hasNextLine()) {
                String data2 = myReader2.nextLine();
                String s2 = data2;  
                if(s2.contains(IssuedBookID)==true){
                    count1++;
                }
            }
            if (count1<1){
                System.out.print("\n\n                     Book doesn't exists");
            }
            else
            {
             File f1 = new File("IssueBooks.txt");
             Scanner myReader = new Scanner(f1);
             while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s1 = data;  
                if(s1.contains(IssuedBookID)==true){
                    count++;
                }
            }
            if (count>0){
                System.out.print("\n\n                     Book already issued");
            }
            else
            {
                FileWriter Writer1 = new FileWriter("IssueBooks.txt",true);
                //writing in file 
                myWriter.write(" \r\n");
                myWriter.write(stureg);
                myWriter.write(" ");
                myWriter.write(IssuedBookID);
                myWriter.write(" ");
                myWriter.write(dtf.format(now));
                myWriter.close();
                System.out.println("\n\n                     Book added successfully.");
            }
        }
    }catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    //menu
    System.out.println("\n\n      ---------------------------------- Menu ----------------------------------\n\n");
    System.out.print("press 1 to issue a book.\r\n      2 for main menu: ");
    Scanner m = new Scanner(System.in);
    int menu = m.nextInt();

    switch (menu) { 
        case 1: 
        IssueBook ibook = new IssueBook(); 
            ibook.IssueaBook(); 
            break;

        case 2: 
        Library lib = new Library();
        lib.MyMain();
        break;
        }
    }
}
//issue book class end

//return a book
class ReturnBook{
  int count5=0;
    public void ReturnaBook(){
        System. out. print("\033[H\033[2J");
        System. out. flush();
        try {

            //file writing
            FileWriter myWriter = new FileWriter("ReturnBooks.txt",true);
            System.out.println("\n\n      ---------------------------------- Return a book ----------------------------------\n\n");
            //Input book Id
            System.out.print("                     Enter the 4 digit Book ID: ");
            Scanner bid = new Scanner(System.in);
            String bookID = bid.nextLine();
            //input Book Name
            System.out.print("                     Enter the Registration Number: ");
            Scanner stureg= new Scanner(System.in);
            String regno = stureg.nextLine();
            //input Book Author
            

            File f5 = new File("IssueBooks.txt");
             Scanner myReader5 = new Scanner(f5);
             while (myReader5.hasNextLine()) {
                String data5 = myReader5.nextLine();
                String s5 = data5;  
                if(s5.contains(bookID)==true){
                    count5++;
                }
            }
            if (count5<0){
                System.out.print("\n\n                     Book is not issued");
            }
            else
            {
                FileWriter Writer1 = new FileWriter("IssueBooks.txt",true);
                //writing in file 
                myWriter.write(" \r\n");
                myWriter.write(bookID);
                myWriter.write(" ");
                myWriter.write(regno);
                myWriter.write(" ");
               
                myWriter.close();
                System.out.println("\n\n                     Book Returned successfully.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //menu
        System.out.println("\n\n      ---------------------------------- Menu ----------------------------------\n\n");
        System.out.print("press 1 to add a book.\r\n      2 for main menu: ");
        Scanner m = new Scanner(System.in);
        int menu = m.nextInt();

        switch (menu) { 
            case 1: 
            AddBook book = new AddBook(); 
            book.AddaBook(); 
            break;

        case 2: 
        Library lib = new Library();
        lib.MyMain();
        break;
        }
    }
}    
//end return book class
  
                  
