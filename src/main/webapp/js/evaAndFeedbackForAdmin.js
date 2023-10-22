// 示例数据（可以从服务器获取）
var data = [];
/* { evaluationId: 1, reviewerId: 101, reviewedId: 201, timestamp: "2023-10-21", type: "买家评价教材", content: "这本教材质量很好，印刷清晰！" },
    { evaluationId: 2, reviewerId: 102, reviewedId: 202, timestamp: "2023-10-22", type: "买家评价卖家", content: "卖家态度很好，很亲和！" },
    { evaluationId: 3, reviewerId: 103, reviewedId: 203, timestamp: "2023-10-23", type: "买家反馈问题", content: "在登录是偶尔会卡顿。" }
* */
// 获取表格的tbody元素
var tbody = document.querySelector("#admin-table tbody");

// 遍历数据并动态生成表格行
data.forEach(function(item) {
    var row = document.createElement("tr");
    row.innerHTML = `
        <td>${item.evaluationId}</td>
        <td>${item.reviewerId}</td>
        <td>${item.reviewedId}</td>
        <td>${item.timestamp}</td>
        <td>${item.type}</td>
        <td>${item.content}</td>
    `;
    tbody.appendChild(row);
});
