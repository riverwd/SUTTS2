var modal = document.getElementById("modal");
var feedbackButton = document.getElementById("feedbackButton");
var closeModal = document.getElementById("closeModal");
var submitButton = document.getElementById("submitButton");
var cancelButton = document.getElementById("cancelButton");
var issueInput = document.getElementById("issueInput");

feedbackButton.onclick = function() {
    modal.style.display = "block";
}

closeModal.onclick = function() {
    modal.style.display = "none";
}

submitButton.onclick = function() {
    // 处理提交逻辑，这里假设提交成功后显示提示信息
    alert("提交成功！");
    modal.style.display = "none";
    issueInput.value = ""; // 清空输入框
}

cancelButton.onclick = function() {
    modal.style.display = "none";
    issueInput.value = ""; // 清空输入框
}

// 当用户点击模态框外部区域时，关闭模态框
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
        issueInput.value = ""; // 清空输入框
    }
}
