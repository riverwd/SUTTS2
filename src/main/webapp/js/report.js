const modal = document.getElementById("myModal");
const reportButton = document.getElementById("reportButton");
const closeBtn = document.querySelector(".close");
const confirmBtn = document.getElementById("confirmBtn");
const cancelBtn = document.getElementById("cancelBtn");
const reportReason = document.getElementById("reportReason");

reportButton.addEventListener("click", () => {
    modal.style.display = "block";
});

closeBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

confirmBtn.addEventListener("click", () => {
    // 处理确认逻辑，这里可以提交举报信息到后端
    alert("举报提交成功！");
    modal.style.display = "none";
});

cancelBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

window.addEventListener("click", (event) => {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});
