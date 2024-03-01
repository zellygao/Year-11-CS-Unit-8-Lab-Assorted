import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Assorted {

    /**
     * Challenge 1
     * <p>
     * Takes a list of integer values represented as a mix of both
     * integer and string data types.
     *
     * @param list a list of integer values represented as a mix of both
     *             integer and string data types. E.g. [12, "54", "78", 16]
     * @return the sum of the elements in the list as if all elements were
     * integer data types.
     */
    public static int findSum(List<?> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof String) {
                sum += Integer.parseInt((String) list.get(i));
            } else {
                sum += (int) list.get(i);
            }
        }
        return sum;
    }

    /**
     * Challenge 2
     * <p>
     * Takes a list of integers and strings and returns a new list containing
     * the integers only (filters the strings out).
     *
     * @param list a list of integer and string values. E.g [1, 2, "a", 5]
     * @return a list containing integers only.
     */
    public static List<Integer> filterStrings(List list) {
        ArrayList<Integer> intlist = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof String) {

            } else {
                intlist.add((int) list.get(i));
            }
        }
        return intlist;
    }

    /**
     * Challenge 3
     * <p>
     * Takes a list of strings and returns a new list that includes each element
     * prepended by the correct line number.
     *
     * @param list a list of string values e.g. ["a", "b", "c"]
     * @return a list where each element is prepended by the correct line number
     * e.g. ["1: a", "2: b", "3: c"]
     */
    public static List<String> lineNumbering(List<String> list) {
        ArrayList<String> array = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            array.add(i + 1 + ": " + list.get(i));
        }
        return array;
    }

    /**
     * Challenge 4
     * <p>
     * There is a bus moving in the city which takes and drops some people at each
     * bus stop.
     * <p>
     * You are provided with a list (or array) of integer pairs. Elements of each pair
     * represent the number of people that get on the bus (the first item) and the number
     * of people that get off the bus (the second item) at a bus stop.
     * <p>
     * Your task is to return the number of people who are still on the bus after the last
     * bus stop (after the last array). Even though it is the last bus stop, the bus might
     * not be empty and some people might still be inside the bus, they are probably
     * sleeping there :D
     *
     * @param list a list of integer pairs.
     * @return the number of people who are still on the bus after the last stop.
     */
    //
    public static int busStop(List<Integer[]> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i)[0];
            sum -= list.get(i)[1];
        }
        return sum;
    }

    /**
     * Challenge 5
     * <p>
     * Given an array of ones and zeroes, convert the equivalent binary value to an integer.
     *
     * @param list a list of integer values. Each element is either a 0 or a 1.
     * @return the decimal value of the binary representation of the list.
     * Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
     */
    public static int toBinary(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (int) (Math.pow(2, list.size() - i - 1) * list.get(i));
        }
        return sum;
    }

    /**
     * Challenge 6
     * <p>
     * Your goal is to implement a method which subtracts one list
     * from another and returns the result.
     * <p>
     * It should remove all values from listA, which are present in listB keeping their order.
     * If a value is present in listB, all of its occurrences must be removed from listA.
     *
     * @param listA a list of integer values.
     * @param listB a list of integer values.
     * @return a list that contains the difference between listB and listA.
     * e.g. subtractList([1,2], [1]) returns [2]
     * subtractList([1,2,2,2,3], [2]) returns [1,3]
     */
    public static List<Integer> subtractList(List<Integer> listA, List<Integer> listB) {
        ArrayList<Integer> newlist = new ArrayList<>();
        for (Integer value : listA) {
            if (!listB.contains(value)) {
                newlist.add(value);
            }
        }
        return newlist;
    }

    /**
     * Challenge 7
     * <p>
     * Your goal is to implement a method which takes a list of integers and sorts the odd
     * numbers in ascending order while leaving the even numbers in their original positions.
     *
     * @param list a list of integers.
     * @return a list where the odd integers have been sorted in ascending order and the even
     * integers remain in their original position.
     */
    public static List<Integer> sortOdd(List<Integer> list) {
        ArrayList<Integer> newlist = new ArrayList<Integer>(); // cant declare size bc it will make a bunch of 0
        ArrayList<Integer> oddlist = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 1) {
                oddlist.add(list.get(i));
            }
        }

        Collections.sort(oddlist);
        System.out.println(oddlist);

        int index = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) % 2 == 1) {
                newlist.add(oddlist.get(index));
                index++;
            } else {
                newlist.add(list.get(j));
            }
        }
        System.out.println(newlist);
        return newlist;
    }

    /**
     * Challenge 8
     * <p>
     * Your goal is to implement a method which takes two values (a lower bound and an upper
     * bound) and returns a list of numbers that are between the lower bound and upper bound
     * (inclusive) that have a certain property.
     * <p>
     * The property is as follows:
     * <p>
     * The number 89 is the first integer with more than one digit whose individual digits
     * can sum to the value 89 by raising each digit to the power of the place or column of
     * which it resides. For example, 89 = 8^1 + 9^2. The next number having this property is
     * 135. 135 = 1^1 + 3^2 + 5^3.
     *
     * @param lowerBound an integer representing the lower bound.
     * @param upperBound an integer representing the upper bound.
     * @return a list containing all the numbers between lowerBound and upperBound (inclusive)
     * that meet the property mentioned above.
     * e.g. uniqueNumber(1,10) returns [1,2,3,4,5,6,7,8,9]
     * uniqueNumber(1,100) returns [1,2,3,4,5,6,7,8,9,89]
     */
    public static List<Integer> uniqueNumber(int lowerBound, int upperBound) {
        ArrayList<Integer> newlist = new ArrayList<Integer>();

        for (int i = lowerBound; i <= upperBound; i++) {
            int num = i;
            int sum = 0;
            int place = 1;

            while (num > 0) {
                int digit = num % 10;
                place = (int) Math.floor(Math.log10(num)) + 1; // calculates number of digits in num
                sum += (int) Math.pow(digit, place);
                num = num / 10;
            }
            if (sum == i) {
                newlist.add(i);
            }
        }
        System.out.println(newlist);
        return newlist;
    }

    /**
     * Challenge 9
     * <p>
     * Alice and Bob were on a holiday. Both of them took many pictures of the places they've
     * been, and now they want to show Charlie their entire collection. However, Charlie doesn't
     * like these sessions, since the motif usually repeats. He isn't fond of seeing the Eiffel
     * tower 40 times.
     * <p>
     * He tells them that he will only sit for the session if they show the same motif at most N
     * times. Luckily, Alice and Bob are able to encode the motif as a number. Can you help them
     * to remove numbers such that their list contains each number only up to N times, without
     * changing the order?
     *
     * @param list a list of motifs.
     * @param n    the maximum number of occurrences of a specific motif that is allowed.
     * @return a list containing each motif at most n times.
     * e.g. filterNTimes([1,2,3,1,2,1,2,3], 2) returns [1,2,3,1,2,3]
     * filterNTimes([20,37,20,21], 1) returns [20,37,21]
     */
    public static List<Integer> filterNTimes(List<Integer> list, int n) {
        ArrayList<Integer> newlist = new ArrayList<Integer>();

        for (Integer num : list) {
            int count = 0;
            for (Integer exist : newlist) {
                if (Objects.equals(exist, num)) {
                    count++;
                }
            }
            if (count < n) {
                newlist.add(num);
            }

        }
        return newlist;
    }

    /**
     * Challenge 10
     * <p>
     * Once upon a time, on a way through the old wild mountainous west,…
     * … a man was given directions to go from one point to another. The directions were
     * "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST"
     * and "EAST" too.
     * <p>
     * Going to one direction and coming back the opposite direction right away is a needless
     * effort. Since this is the wild west, with dreadful weather and not much water, it's
     * important to save yourself some energy, otherwise you might die of thirst!
     * <p>
     * How I crossed a mountainous desert the smart way.
     * The directions given to the man are, for example, the following:
     * <p>
     * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
     * <p>
     * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable,
     * better stay to the same place! So the task is to give to the man a simplified version
     * of the plan. A better plan in this case is simply:
     * <p>
     * ["WEST"]
     * <p>
     * Your task is to write a method which will take a list of strings and returns a list
     * of strings with the needless directions removed.
     *
     * @param directions a list of directions.
     * @return a list with the needless directions removed.
     * e.g. wildWest(["NORTH", "SOUTH", "EAST", "WEST"]) returns []
     * wildWest(["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"]) returns
     * ["WEST", "WEST"]
     */
    public static List<String> wildWest(List<String> directions) {
        for (int i = 1; i < directions.size(); i++) {
            if (directions.get(i).length() == directions.get(i - 1).length() && !directions.get(i).equals(directions.get(i - 1))) {
                directions.remove(i);
                directions.remove(i - 1);
                i -= 2;
            }
            if (i == -1) {
                i = 0;
            }
        }
        System.out.println(directions);
        return directions;
    }


    /**
     * Challenge 11
     * <p>
     * There is a queue for the self-checkout tills at the supermarket. Your task is to write a
     * method to calculate the total time required for all the customers to check out!
     * <p>
     * There is only queue serving many tills.
     * The order of the queue never changes.
     * The front person in the queue (the first element in queue) proceeds to a till as soon
     * as it becomes free.
     *
     * @param queue     a list of queue times. Each element represents a customer and how long
     *                  in minutes it will take them to check out.
     * @param tillsOpen the number of tills currently available for customers to use.
     * @return an integer that represents how long it will take for all the customers to check
     * out.
     * e.g. queueTime([5,3,4], 1) returns 12
     * queueTime([10,2,3,3], 2) returns 10
     * queueTime([2,3,10], 2) returns 12
     */
    public static int queueTime(List<Integer> queue, int tillsOpen) {
        int time = 0;
        for (int i = 0; i < queue.size(); i++) {
            if (tillsOpen == 1) {
                time += queue.get(i);
            }
            if (tillsOpen == 2) {
                int min =
                        time += queue.get(0);
                time += queue.get(1);

            }
        }

        System.out.println(time);
        return time;
    }
    
}