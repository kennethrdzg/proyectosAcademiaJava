package com.kennethrdzg.builder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String name;
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        CharacterBuilder builder = null;
        
        System.out.println("\nCharacter Selection Menu");
        System.out.print("Input your character's name: ");
        name = scanner.nextLine();

        System.out.print("\nSelect your character's race: \n1 - Human\n2 - Elf\n3- Dwarf\nSelection: ");
        while (builder == null) {
            try{
                option = scanner.nextInt();
            }
            catch(InputMismatchException e){
                scanner.next();
                System.err.print("Invalid option, try again: ");  
                continue; 
            }
            
            switch (option) {
                case 1:
                    builder = new HumanBuilder(name);
                    break;
                case 2: 
                    builder = new ElfBuilder(name);
                    break;
                case 3: 
                    builder = new DwarfBuilder(name);
                    break;
                default:
                    System.out.println("Invalid selection, try again: ");
                    break;
            }
        }
        scanner.close();
        
        CharacterDirector director = new CharacterDirector();

        director.constructCharacter(builder);

        PlayerCharacter player = builder.getCharacter();
        System.out.println("\nPlayer Character " + player);
    }
}
