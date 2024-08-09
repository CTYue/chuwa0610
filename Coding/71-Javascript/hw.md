2.  Compare  let vs  var with your own code examples
The difference between let and var in JavaScript primarily revolves around scope, hoisting, and reassignment.
1) Scope
var: Function-scoped, meaning it is accessible within the entire function where it is declared.
let: Block-scoped, meaning it is only accessible within the block {} where it is declared.
function scopeTest() {
    if (true) {
        var x = 10; // function-scoped
        let y = 20; // block-scoped
    }
    console.log(x); // 10 (accessible)
    console.log(y); // ReferenceError: y is not defined (not accessible)
}

2) Hoisting
var: Variables declared with var are hoisted to the top of their scope, and they are initialized with undefined.
let: Variables declared with let are also hoisted, but they are not initialized. Accessing them before declaration results in a ReferenceError.

function hoistingTest() {
    console.log(a); // undefined (due to hoisting)
    console.log(b); // ReferenceError: Cannot access 'b' before initialization
    var a = 10;
    let b = 20;
}

3. Reassignment
var: Variables declared with var can be redeclared and reassigned.
let: Variables declared with let can be reassigned but cannot be redeclared in the same scope.

function reassignmentTest() {
    var a = 5;
    var a = 10; // redeclaration allowed
    console.log(a); // 10

    let b = 15;
    // let b = 20; // SyntaxError: Identifier 'b' has already been declared
    b = 20; // reassignment allowed
    console.log(b); // 20
}

5.  Explain Event Loop, Macrotask, and Microtask with code samples.
1. Event Loop
The Event Loop is the mechanism that handles the execution of multiple chunks of your program, including synchronous and asynchronous operations. It continuously checks the call stack (where synchronous code is executed) and the callback queue (where asynchronous code is waiting) to see if there’s anything that needs to be processed.

2. Macrotasks
Macrotasks are larger, more complex operations that include things like:

setTimeout
setInterval
I/O operations (e.g., file reading)
requestAnimationFrame
When a macrotask is complete, it is added to the callback queue, waiting for the event loop to pick it up and execute it.

3. Microtasks
Microtasks are smaller operations that are prioritized over macrotasks. Examples include:

Promises (.then and .catch callbacks)
MutationObserver
After every macrotask, the event loop checks the microtask queue and processes all the microtasks before moving on to the next macrotask.

console.log("Start");

setTimeout(() => {
    console.log("Macrotask 1: setTimeout");
}, 0);

Promise.resolve().then(() => {
    console.log("Microtask 1: Promise");
});

console.log("Synchronous Code");

setTimeout(() => {
    console.log("Macrotask 2: setTimeout");
}, 0);

Promise.resolve().then(() => {
    console.log("Microtask 2: Promise");
});

console.log("End");
