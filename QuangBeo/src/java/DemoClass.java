/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class DemoClass {

    public static void main(String[] args) {
        int rightExpect = 0;
        String[] answerRight = {"1","2"};
        String[] answers = {"1"};
        for (int i = 0; i < answerRight.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                System.out.println(answerRight[i].trim().equalsIgnoreCase(answers[j].trim()));
                if (answerRight[i].trim().equalsIgnoreCase(answers[j].trim())) {
                    rightExpect = rightExpect + 1;
                }
            }
        }
    }
}
