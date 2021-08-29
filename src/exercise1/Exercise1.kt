package exercise1

import java.util.*

// Exercises by Marc Fearby for the Build Spring Boot Apps with the
// Kotlin Programming Language course on Udemy by Matt Greencroft

fun runExercise1() {
    val dateOfBirth = GregorianCalendar(1974, 1, 1)
    val marc = KotlinPerson(1,"Mr", "Marc", "Fearby", dateOfBirth)
    println("$marc's age is ${marc.age}")

    val john = KotlinPerson(1,"Mr", "John", "Smith")
    println("$john's age is ${john.age}")

    println("The age of someone born on 3rd May 1988 is "
            + KotlinPerson.getAge(GregorianCalendar(1988, 3, 3)))
}