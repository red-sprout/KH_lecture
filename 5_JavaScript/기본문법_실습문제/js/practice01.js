function selectCheckBox() {
    const result = document.getElementById("result");
    const check = document.querySelectorAll(".select input");
    const label = document.querySelectorAll(".select label");

    result.innerHTML = "";
    let isFirst = true;
    for (let i in check) {
        if (check[i].checked) {
            if (!isFirst) {
                result.innerHTML += ", "
            }
            isFirst = false;
            result.innerHTML += `${label[i].textContent}`;
        }
    }
}

function allCheck() {
    let allCheckBox = document.getElementById("all");
    let hobbyList = document.getElementsByName("hobby");
    for (let checkBox of hobbyList) {
        checkBox.checked = allCheckBox.checked;
    }
}

function checkBoxTrigger() {
    let allCheckBox = document.getElementById("all");
    let hobbyList = document.getElementsByName("hobby");

    let isAllChecked = true;
    for(let checkBox of hobbyList) {
        if(!checkBox.checked) {
            isAllChecked = false;
            break;
        }
        
    }
}