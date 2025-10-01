package PBLJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class IdNotFoundException extends Exception {
    @Override
    public String getMessage() {
       return "ID not Found.";
    }
}

public class HashMapExample {

    public static void main(String[] args) throws IdNotFoundException {
        Map<Integer, String> map = new HashMap<>();

        map.put(101, "Gagnesh");
        map.put(102, "Abhay");
        map.put(103, "Yash");
        map.put(104, "Jaidev");

        try{
            System.out.print("Enter the ID to be searched: ");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();

            if(!map.containsKey(id)){
                throw new IdNotFoundException();
            }
            else{
                System.out.println(map.get(id));
            }
        }catch(IdNotFoundException IdF){
            System.out.println(IdF.getMessage());
        }


    }
}