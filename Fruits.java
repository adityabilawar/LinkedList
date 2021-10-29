//Aditya Bilawar 
//Advanced Topics in Computer Science Honors
//Using LinkedLists and ListIterator

import java.util.LinkedList;
import java.util.ListIterator;

public class Fruits {

LinkedList<String> bowl;

public Fruits() {
bowl = new LinkedList<String>();
bowl.add("Apple");
bowl.add("Banana");
bowl.add("Cherry");
bowl.add("Lemon");
bowl.add("Lime");
bowl.add("Kiwi");
bowl.add("Orange");
bowl.add("Strawberry");
bowl.add("Blueberry");
bowl.add("Mango");
bowl.add("Watermelon");
bowl.add("Papaya");
//bowl.add("blackberry"); commented to make the number of elements even
}

public void display() {
System.out.println(bowl);
}
public void display2() {
for(String s:bowl)
System.out.println(s);
}
public void display3() {
ListIterator<String> iter = bowl.listIterator();
//instantiates object and attaches it to the collection you want
while(iter.hasNext())
System.out.println(iter.next());
}
public void testIterator() {
ListIterator<String> iter = bowl.listIterator();
//iter.remove(); its not pointing at anything officially,
//what it removes is the last thing it traversed
iter.next();
iter.remove();
}
public void displayEveryOther() {
ListIterator<String> iter = bowl.listIterator();
while(iter.hasNext()) {
//System.out.println(iter.next());
if(iter.hasNext())
iter.next();
System.out.println(iter.next());
iter.next();

}
}
public void removeEveryOther() {
ListIterator<String> iter = bowl.listIterator();
while(iter.hasNext()) {
iter.next();
//iter.remove();

if(iter.hasNext())
iter.next();
iter.remove();
System.out.println(iter.next());



}
}
public void displayReverse() {
ListIterator<String> iter = bowl.listIterator();
while(iter.hasNext())
iter.next();
while(iter.hasPrevious())
System.out.println(iter.previous());

}
public void insertA(String fruit) {
//beginning
if (bowl.isEmpty())
bowl.add(fruit);
else if(fruit.compareTo(bowl.getFirst())< 0)
bowl.addFirst(fruit);
// if at end...
else if(fruit.compareTo(bowl.getFirst())> 0)
bowl.addLast(fruit);

//in middle....
else {
ListIterator<String> itr = bowl.listIterator();
while(itr.hasNext() && (itr.next().compareTo(fruit) < 0)) {

}
itr.previous();
itr.add(fruit);
}
}
public void insertB(String fruit) {
ListIterator<String> itr = bowl.listIterator();
while(itr.hasNext()) {
if(fruit.compareTo(itr.next()) <=0) {
itr.previous();
itr.add(fruit);
return;
}
}
itr.add(fruit);
}
public void delete(String letter) {
ListIterator<String> itr = bowl.listIterator();
while(itr.hasNext()) {
String t = itr.next();
if (letter.equals(t.substring(0,1))) {
itr.remove();
//return; if you want to only remove one letter starting with L
//without this all words with the inputted letter would get removed
}
}

}

public boolean doesHave(String letter) {
ListIterator<String> itr = bowl.listIterator();
while(itr.hasNext()) {
String t = itr.next();
if (letter.equals(t.substring(0,1))) {
return true;

}
}
return false;
}

public void findReplace(String letter) {
ListIterator<String> itr = bowl.listIterator();
while(itr.hasNext()) {
String t = itr.next();
if (letter.equals(t.substring(0,1))) {
itr.remove();
itr.add("Joe");

}
}

}

public static void main(String[] args) {
Fruits one = new Fruits();
//System.out.println(one);
//one.display3();
//System.out.println();
//one.testIterator();
//System.out.println();
System.out.println("Original LinkedList");
one.display3();
System.out.println();
System.out.println("Display everyother");
one.displayEveryOther();
System.out.println();
System.out.println("Remove Everyother");
one.removeEveryOther();
System.out.println();
System.out.println("Display Reverse");
one.displayReverse();
System.out.println();
System.out.println("Insert Berry");
one.insertA("berry");
one.display3();
System.out.println();
System.out.println("Insert Zebraberry");
one.insertB("Zebraberry");
one.display3();
System.out.println();
System.out.println("delete fruit starting with l");
one.delete("l");
one.display3();
System.out.println();
System.out.println("Returns true if list has an element starting with A");
System.out.println(one.doesHave("A")); //returns true as apple is there
System.out.println();
System.out.println("Replaces fruit starting with A with joe");
one.findReplace("A"); //replaces apple with joe
one.display3();
}

}