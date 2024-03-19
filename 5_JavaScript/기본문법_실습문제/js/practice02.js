function calculate() {
    const num1 = parseInt(document.getElementById("num1").value);
    const num2 = parseInt(document.getElementById("num2").value);
    const operator = document.getElementById("operator").value;

    let result = 0;
    switch (operator) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            result = (num2 === 0) ? null : num1 / num2;
            break;
        case "%":
            result = (num2 === 0) ? null : num1 % num2;
            break;
    }

    changeResult(result);
}

function changeResult(value) {
    const result = document.getElementById("result");
    if (value) {
        result.style.background = "none";
        result.style.color = "black";
        result.value = value;
    } else {
        result.style.background = "red";
        result.style.color = "white";
        result.value = "연산불가";
    }
}