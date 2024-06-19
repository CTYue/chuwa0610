##2.  What is the checked exception and unchecked exception in Java, could you give one example?
checked exceptions that are checked at compile-time
unchecked exceptions that are checked at run-time
- Checked Exceptions:
    - IOException
    - SQLException
    - ClassNotFoundException
    - FileNotFoundException
- Unchecked Exceptions:
    - NPE
    - ArrayIndexOutOfBoundsException
    - ArithmeticException
## 3.  Can there be multiple finally blocks?
    - no, in Java, a try block can only be associated with one finally block. 
## 4.  When both catch and finally return values, what will be the final result?
When both the catch and finally blocks contain return statements, 
the final return value will come from the finally block
## 5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?
 - runtime/unchecked exception：Can happen during runtime, the compiler is not required to handle
 - Compile/Checked Exception：Checked during compilation, must be handled explicitly
## 6.  What is the difference between throw and throws?
- Throw is used to throw an exception object within a method or a block of code.
- Throws is used in a function signature,  indicates  it may throw exception  type  in the method
## 7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
- Subclass exceptions must be caught before parent class exceptions. 
If the parent class exception is placed before the subclass exception, 
the subclass exception will not be caught.
- ArithmeticException and NullPointerException are the subclass of RuntimeException.
RuntimeException is subclass of Exception.