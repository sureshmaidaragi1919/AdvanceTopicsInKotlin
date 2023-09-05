package com.example.advancetopicsinkotlin.classes


//source https://stackoverflow.com/a/65226315/4328589
/*
* Performance
Enum

Enums don't get garbage collected, they stay in memory for the lifespan of your app. This can be an upside or a downside.

Garbage collection process is expensive. The same is true for object creation, we don't want to create the same objects again and again. So, with enums, you save the cost of garbage collection as well as object creation. This is the upside.

The downside is that the enums stay in memory even when they are not in use, this can keep the memory occupied all the time.

You don't need to worry about all this, if you have 100 to 200 enums in your app. But when you have more than that,
*  you have a decision to make whether you should go for enums depending on the
*  facts such as the number of enums, whether they will be in use all the time and the amount of memory allocated to your JVM.

The comparison of enum values is faster in the when expression because under the hood, it uses tableswitch to
*  compare the objects. So, for the example given in the question, enums should be preferred as they will be faster in this case.

In Android, when the optimization is enabled, the Proguard converts the enums that don't have functions and properties to integers, so you get the type-safety of the enums at compile-time and the performance of the ints at runtime!

Sealed Class

Sealed classes are just regular classes with the only exception that they need to be extended in the
* same package and the same compilation unit. So, their performance is equivalent to regular classes.

Objects of the subtypes of the sealed classes get garbage collected like the objects of regular classes. So, you have to bear the cost of garbage collection as well as object creation.

When you have the low memory constraints, you may consider using sealed classes instead of enums, if you need thousands of objects.
* Because the garbage collector can free up the memory when the objects are not in use.

If you use object declaration for extending the sealed class, the objects act as singletons and they won't be garbage collected, just like enums.

The comparison of sealed class' types is slower in when expression because under the hood it uses
*  instanceof to compare the types. The speed difference between enums and sealed classes, in this case, is very little though. It matters only when you are comparing thousands of constants in a loop.


* */
enum class DeliveryStatus(val trackingId: String?) {
    PREPARING(null),//Here we need the trackingId only for the DISPATCHED and DELIVERED, the PREPARING is forced to have a null value.
    DISPATCHED("2711"),
    DELIVERED("2412")
}


//Sealed classes can extend other classes as well as interfaces:

open class OrderStatus
interface Cancellable

sealed class SDeliveryStatus : OrderStatus(), Cancellable
class Preparing() : SDeliveryStatus()
class Dispatched(val trackingId: String) : SDeliveryStatus()
class Delivered(val trackingId: String, val receiversName: String) : SDeliveryStatus()

//Conclusion
/*
* Here we have different properties for each subtype. Preparing doesn't need properties for our use case, so we have the flexibility to not
*  specify any property unlike forced null values in enums. Dispatched has one property while the Delivered has two properties.
* */



