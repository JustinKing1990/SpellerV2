/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistlab;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SpellerV2 {

    
 public MyLinkedList<String>[] dictionary = new MyLinkedList[26];

    public void dictionary(){
        try{
            for (int i = 0; i < 26; i++) {
                dictionary[i] = new MyLinkedList<String>();   
            }//for
        String word = "";
        File dictionaryIn = new File("random_dictionary.txt");
        Scanner input = new Scanner(dictionaryIn);
        int i = 0;
        while(input.hasNext()){
           word = input.next().trim().toLowerCase();
           dictionary[word.charAt(0) - 97].addFirst(word);
           i++;
        }//while  
        }//try
        catch(Exception e){
            System.out.println("Error: " + e);
        }//catch
    }//dictionary

    public void oliverClean(){
        try{
        File oliverIn = new File("oliver.txt");
        File oliverOut = new File("oliverclean.txt");
        PrintWriter print = new PrintWriter(oliverOut);
        Scanner input = new Scanner(oliverIn);
        Scanner output = new Scanner(oliverOut);
        String temp = "";
        while (input.hasNext()){
            temp = input.nextLine();
            String replaceAll = temp.replaceAll("\\p{Punct}", " ").replaceAll("\\d", " ");
            print.println(replaceAll);
        }//while
        }//try
        catch(Exception e){
            System.out.println("Error: " + e);
        }//catch
    }//oliverClean 

    public void oliver(){
        try{
        File oliver = new File("oliverclean.txt");
        Scanner input = new Scanner(oliver);
        String[] oliverTxt = new String[997668];
        int count = 0;
        int wrong = 0;
        int i = 0;
        while(input.hasNext()){
            oliverTxt[i] = input.next().trim().toLowerCase();
            i++;
        }//while
        //this loop will take each of the entries of the oliver array, and compare it with the dictionary
            for (int j = 0; j <  oliverTxt.length; j++) {
                String s = oliverTxt[j];
                if(dictionary[oliverTxt[j].charAt(0)-97].contains(s))
                count++;
            else
                wrong++;
            }//for
            System.out.println("There is a total of " + count + " correctly spelled words");
            System.out.println("There is a total of " + wrong + " incorrectly spelled words");
        }//try
        catch(Exception e){
            System.out.println("Error: " + e);
        }//catch
    }//oliver

        public static void main(String[] args) {
        SpellerV2 ans = new SpellerV2();
        ans.dictionary();
        ans.oliverClean();
        ans.oliver();
   }
    
}

