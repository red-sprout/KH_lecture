function validate() {
    const insertArr = document.getElementsByName("insert");
    for (let i in insertArr) {
        console.log(insertArr[i].value);
    }
}
