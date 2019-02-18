$(document).ready(function () {
    showOptionsExample();
});

//二级联动测试数据
let computers = [
    {"brand":"华为","name":"huawei001","value":"111"},
    {"brand":"华为","name":"huawei002","value":"111"},
    {"brand":"华为","name":"huawei003","value":"111"},
    {"brand":"华硕","name":"huashuo001","value":"11111"},
    {"brand":"华硕","name":"huashuo002","value":"11111"},
    {"brand":"华硕","name":"huashuo003","value":"11111"},
    {"brand":"戴尔","name":"daier001","value":"25462"},
    {"brand":"戴尔","name":"daier002","value":"25462"},
    {"brand":"小米","name":"xiaomi001","value":"23131"},
    {"brand":"小米","name":"xiaomi002","value":"23131"}
];

let map = {};

//前端二级联动菜单数据处理
function deal(){
    //每次处理之前处理结果对象，防止累计结果
    map = {};
    for(let i = 0; i < computers.length; i++){
        let obj = [];
        let computer = computers[i];
        //如果一级菜单名称对象不存在
        if(!map[computer.brand]){
            obj.push({
                name: computer.name,
                data: [computer]
            });
            map[computer.brand] = obj;
        }else{
            let temObj = map[computer.brand];
            //如果一级菜单名称对象已存在，向其data对象中追加数组
            for(let j = 0; j < temObj.length; j++){
                let dj = temObj[j];
                //遍历现有data数据中是否有与之相同的二级菜单名称
                if(computer.name !== dj.name){
                    temObj.push({
                        name:computer.name,
                        data: [computer]
                    });
                    break;
                }
            }
        }
    }
}

//回显二级联动框数据
function showOptionsExample(){
    //清空下拉框
    $("#pcOrderBrand").empty();
    $("#pcOrderBrand").html("<option>==请选择==</option>");
    $("#pcOrderName").empty();
    //构建数据
    deal();
    //填充一级表单
    $.each(map,function (i, result) {
        let brand = i;
        let brandOption = "<option value='"+brand+"'>"+brand+"</option>";
        $("#pcOrderBrand").html($("#pcOrderBrand").html()+brandOption);
    });
}
//二级菜单监听触发
$("#pcOrderBrand").bind("change",function () {
    $("#pcOrderName").empty();
    let brand = $("#pcOrderBrand").val();
    $.each(map,function (i, result) {
        if(brand===i){
            $.each(result,function (i, row) {
                let name = row.name;
                let pcNameOption = "<option value='"+name+"'>"+name+"</option>";
                $("#pcOrderName").append(pcNameOption);
            });
        }
    });
});








