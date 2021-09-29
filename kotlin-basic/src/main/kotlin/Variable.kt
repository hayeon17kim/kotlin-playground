// java는 클래스명과 파일명이 일치해야 하지만 코틀린은 아니다.

// top level variable

val name = "Nate";
//val name: String = "Nate"; // type
//val name: String = null // error
var greeting: String? = "Hello"; // nullable

fun main() {
    // local variables
    println("hello kotlin");
    // mutable variable
    var name1: String = "Nate";
    name1 = "Monica"; // updatable
    // immutable(read only) variable
    val name2: String = "Nate";
    // name2 = "Monica"; // cannot update

    if (greeting != null) {
        println(greeting);
    } else {
        println("Hi");
    }

    when (greeting) {
        null -> println("Hi");
        else -> println(greeting);
    }
    println(greeting);
    println(name);

    val greetingToPrint = if (greeting != null) greeting else "Hi";
    // val greetingToPrint = when (greeting) {
    //   null -> "Hi"
    //   else -> greeting
    // }
    println(greetingToPrint);

    greeting = null;
    println(greeting);
    println(name);
}