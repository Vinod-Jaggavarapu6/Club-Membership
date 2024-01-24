import java.io.File;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
public class MembershipManagement {
    final private Scanner scanner = new Scanner(System.in);
    private int getIntInput(){
        int choice = 0;

        while(choice ==0){
            try {
                choice = scanner.nextInt();
                if (choice ==0) throw new InputMismatchException();
                scanner.nextLine();


            }catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("\nERROR: INVALID INPUT. Please try again");
            }
        }
        return choice;

    }

    private void printClubOptions(){
        System.out.println("\n1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) CLub Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice(){
        int choice;
        System.out.println("\nWELCOME TO MARINO FITNESS CENTER");
        System.out.println("=====================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("\n"+"Please select an option (or Enter -1 to quit): ");
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m){
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;



        System.out.println("\nEnter your name : \n");
        name =  scanner.nextLine();
        printClubOptions();
        System.out.println("Enter the member's Club ID: ");
        club = getIntInput();
        while(club<1 || club>4){
            System.out.println("Enter the member's Club ID: ");
            club = getIntInput();
        }

        if(m.size()>0){
            memberID = m.getLast().getMemberID()+1;
        }else{
            memberID = 1;
        }
        if(club!=4){
            cal = (ID) ->{
               switch(ID){
                   case 1:
                       return 900;
                   case 2:
                       return 950;
                   case 3:
                       return 1000;
                   default:
                       return -1;
               }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S',memberID,name,fees ,club );
            m.add(mbr);
            mem = mbr.toString();
//            FileHandler.overWriteFile(m);
            System.out.println("\nSTATUS: Single Club Member added\n");

        }else{
            cal = (ID) -> {
                if (ID == 4) return 1200;
                else return -1;
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M',memberID,name, fees,100 );
            m.add(mbr);
//            FileHandler.overWriteFile(m);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Multi Club Member added\n");
        }
        return mem;

    }

    public void removeMember(LinkedList<Member> m){
        int memberID;

        System.out.println("\nEnter the member ID you want to remove: \n");
        memberID = getIntInput();

        for (int i = 0;i<m.size();i++){
            if(m.get(i).getMemberID() == memberID){
                //remove
                m.remove(i);
                System.out.println("\nMember has been removed Successfully!!");
                return;
            }
        }
        System.out.println("\nMember ID not found\n");

    }

    public void printMemberInfo(LinkedList<Member> m){
        int memberID;

        System.out.println("\nEnter the member ID you want to Fetch the Info: \n");
        memberID = getIntInput();

        for (int i = 0;i<m.size();i++){
            if(m.get(i).getMemberID() == memberID){
                String[] memberInfo= m.get(i).toString().split(",");
                System.out.println("Member Type = "+memberInfo[0]);
                System.out.println("Member ID = "+memberInfo[1]);
                System.out.println("Member Name = "+memberInfo[2]);
                System.out.println("Membership Fees = "+memberInfo[3]);
                if(memberInfo[0] =="S"){
                    System.out.println("Club ID = "+memberInfo[4]);
                }else   System.out.println("Membership Points = "+memberInfo[4]);

                return;
            }
        }
        System.out.println("\nMember ID not found\n");
    }

}
