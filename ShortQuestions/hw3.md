## 2. What is the checked exception and unchecked exception in Java, could you give one example?
- **Checked exception**: Exceptions that are checked at compile time and should be handled by `catch` or `throws`.
Ex: IOException, SQLException, NetworkException.
- **Unchecked exception**: Runtime exceptions. Ex: NullPointerException, IndexOutOfBoundsException.

## 3. Can there be multiple finally blocks?
No, there can only be one finally block

## 4. When both catch and finally return values,what will be the final result?
The return values in the finally block will be the final return result.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
Runtime/unchecked exceptions are those exceptions that are not checked at compile time. Exceptions under Error and RuntimeException classes are unchecked exceptions. Compile/checked exceptions are those that are checked at compile time. They should be handled properly by the `catch` or `throws`.