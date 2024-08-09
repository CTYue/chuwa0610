<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lucky Number Generator</title>
<style>
    body {
    font-family: Arial, sans-serif;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    margin: 0;
    background-color: #f4f4f4;
}
    h1 {
    color: #333;
}
    #lucky-number {
    font-size: 2rem;
    color: #007BFF;
    margin-top: 20px;
}
    #input-form {
    display: flex;
    flex-direction: column;
    align-items: center;
}
    input {
    padding: 10px;
    font-size: 1rem;
    margin: 10px 0;
}
    button {
    padding: 10px 20px;
    font-size: 1rem;
    cursor: pointer;
}
</style>
</head>
<body>

<h1>Lucky Number Generator</h1>
<form id="input-form">
    <input type="text" id="user-input" placeholder="Enter your name" required>
        <button type="button" onclick="generateLuckyNumber()">Get Lucky Number</button>
</form>

<div id="lucky-number"></div>

<script>
    function generateLuckyNumber() {
    const userInput = document.getElementById('user-input').value;
    if (userInput.trim() === '') {
    alert('Please enter your name!');
    return;
}

    const now = new Date();
    const dateSum = now.getDate() + (now.getMonth() + 1) + now.getFullYear();
    const timeSum = now.getHours() + now.getMinutes() + now.getSeconds();
    const inputSum = userInput.split('').reduce((acc, char) => acc + char.charCodeAt(0), 0);

    const luckyNumber = (dateSum + timeSum + inputSum) % 100 + 1;
    document.getElementById('lucky-number').textContent = `Your Lucky Number is: ${luckyNumber}`;
}

    // Trigger button click on Enter key press
    document.getElementById('user-input').addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
    event.preventDefault();
    generateLuckyNumber();
}
});
</script>

</body>
</html>
