// 示例数据（可以从服务器获取）
var data = [];
/*
*   { orderId: 1, materialId: 101, userId: 201, name: "教材1", author: "作者1", price: 29.99 },
    { orderId: 2, materialId: 102, userId: 202, name: "教材2", author: "作者2", price: 39.99 },
    { orderId: 3, materialId: 103, userId: 203, name: "教材3", author: "作者3", price: 19.99 },
    { orderId: 4, materialId: 104, userId: 204, name: "教材4", author: "作者4", price: 49.99 }
* */
// 获取表格的tbody元素
var tbody = document.querySelector("#user-table tbody");

// 遍历数据并动态生成表格行
data.forEach(function(item) {
    var row = document.createElement("tr");
    row.innerHTML = `
        <td>${item.orderId}</td>
        <td>${item.materialId}</td>
        <td>${item.userId}</td>
        <td>${item.name}</td>
        <td>${item.author}</td>
        <td>${item.price}</td>
        <td><button class="evaluation-button"><a href="../evaluate/evaluate.html" >评价</a></button></td>
    `;
    tbody.appendChild(row);
});
