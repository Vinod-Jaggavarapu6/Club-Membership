import java.io.*;
import java.util.LinkedList;
public class FileHandler {

    public static LinkedList<Member> readFile(){
        LinkedList<Member> ll = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member mem;
        try(BufferedReader reader = new BufferedReader((new FileReader("members.csv")))){
            lineRead = reader.readLine();
            while(lineRead!=null){
                splitLine = lineRead.split(",");
                if(splitLine[0].equals("S")){
                    mem = new SingleClubMember('S',Integer.parseInt(splitLine[1]),splitLine[2],Double.parseDouble(splitLine[3]),Integer.parseInt(splitLine[4]));
                }else{
                    mem = new MultiClubMember('M',Integer.parseInt(splitLine[1]),splitLine[2],Double.parseDouble(splitLine[3]),Integer.parseInt(splitLine[4]));

                }
                ll.add(mem);
               lineRead = reader.readLine();
            }


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return ll;

    }

    public static void appendFile(String mem){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv",true))){
            writer.write(mem+"\n");

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void overWriteFile(LinkedList<Member> m){
        String s;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp",false))){
            for(int i=0;i<m.size();i++){
                s = m.get(i).toString();
                writer.write(s+"\n");
            }

        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

        try{
            File f = new File("members.csv");
            File nf = new File("members.temp");
            nf.renameTo(f);
            f.delete();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
