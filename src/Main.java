import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();

        while(choice !=-1){
            switch(choice){
                case 1:
                    mem =  mm.addMembers(members);
                    fh.appendFile(mem);

                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overWriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("\nYou have entered an Invalid Option.\n");

            }
            choice = mm.getChoice();
        }
        System.out.println("Logged Out Successfully :)");
    }
}