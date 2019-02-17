$(document).ready(function () {
    listPC();
});

//刷信新增页面
function fresh(){
   $("#addPro_form")[0].reset();
}

//展示电脑信息列表
function listPC() {
    let search = $("#search").val();
    $("#pclist").html("");
    $.ajax({
        type: "get",
        url: "http://127.0.0.1:9000/pc/list"+"?param="+search,
        success: function (data,status) {
            $("#goods_list").html("");
            if(data==null || data.length===0){
                $("#pclist").html("没有数据！");
            }
            $.each(data,function(i, result){
                let pcid = result.pcId;
                let brand = result.brand;
                switch (brand) {
                    case 1: brand = "华为";break;
                    case 2: brand = "华硕";break;
                    case 3: brand = "戴尔";break;
                    case 4: brand = "小米";break;
                    default:
                }
                let pcName = result.pcName;
                let os = result.os;
                switch (os) {
                    case 1: os = "Windows10";break;
                    case 2: os = "Windows8";break;
                    case 3: os = "Windows7";break;
                    case 4: os = "Ubuntu";break;
                    default:
                }
                let price = result.price;
                let amount = result.amount;
                if(amount>=50){
                    amount = "<span style='color:red;'>"+amount+"</span>"
                }
                let column = "<tr id='"+pcid+"'>"+
                    "<td name='pcId' hidden='hidden'>"+pcid+"</td>"+
                    "<td name='pcName'>"+pcName+"</td>"+
                    "<td name='brand'>"+brand+"</td>"+
                    "<td name='os'>"+os+"</td>"+
                    "<td name='price'>"+price+"</td>"+
                    "<td name='amount' >"+amount+"</td>"+
                    "<td>" +
                    "<a  onclick='updatePC(this)' class='table_btn table_edit edit_btn'  data-toggle='modal' data-target='#myModal'><i class='fa fa-edit'></i><span>编辑</span></a>"+
                    "<a  onclick='deletePC(this)' class='table_btn table_del del_btn'> <i class='fa fa-trash-o'></i><span>删除</span> </a>" +
                    "</td></tr>";
                $("#pclist").html($("#pclist").html() + column);
            });
        },
        error: function (data,status) {
            alert("请求失败："+ data.responseJSON.message);
            $("#pclist").html("没有数据！");
        }
    });
}

//更新电脑信息
function updatePC(obj){
    let pcId = $(obj).parent('td').parent('tr')[0].id;
    let column = $(obj).parent('td').parent('tr').find('td');
    let name = column[1].innerText;
    let brand = column[2].innerText;
    let os = column[3].innerText;
    let price = column[4].innerText;
    let amount = column[5].innerText;
    console.log("id="+pcId+" name="+name+"  brand"+brand+"  os"+os+"   price"+price+"  amount"+amount);
    switch (os) {
        case "Windows10": os = 1;break;
        case "Windows8": os = 2;break;
        case "Windows7": os = 3;break;
        case "Ubuntu": os = 4;break;
        default:
    }
    switch (brand) {
        case "华为": brand = 1;break;
        case "华硕": brand = 2;break;
        case "戴尔": brand = 3;break;
        case "小米": brand = 4;break;
        default:
    }
    console.log("id="+pcId+" name="+name+"  brand"+brand+"  os"+os+"   price"+price+"  amount"+amount);
    $("#pcName").attr("disabled", "disabled");
    $("#pcBrand").attr("disabled", "disabled");
    $("#pcid").val(pcId);
    $("#pcBrand").val(brand);
    $("#pcName").val(name);
    $("#pcPrice").val(price);
    $("input[value = '"+os+"']").prop("checked", true);
}

//删除电脑信息
function deletePC(obj){
    if(!confirm("确定删除?")){
        windows.history.back();
    }
    let pcId = $(obj).parent('td').parent('tr')[0].id;
    $.ajax({
        type: "get",
        url: "http://127.0.0.1:9000/pc/delete" + "?pcId=" + pcId,
        success: function (data, status) {
            alert("删除成功");
            location.reload();
        },
        error: function (data, status) {
            alert("删除失败 ：" + data.responseJSON.message);
        }
    })
}

//新增或更新电脑信息
function save() {
     let pcid = $("#pcid").val();
     let pcBrand = $("#pcBrand  option:selected").val();
     let pcName = $("#pcName").val();
     let os = $("input[name='system']:checked").val();
     let pcPrice = $("#pcPrice").val();

     //参数处理
     let param = {
         brand:pcBrand,
         pcName:pcName,
         os:os,
         price:pcPrice,
         amount:0,
         pcId:pcid
     };
    let ok = {key:true};
     paramCheck(param,ok);
     if(ok.key===false){
         return;
     }
     add(param);
}

//检查电脑信息参数
function paramCheck(param,ok){
    if(param.pcName===""||param.pcName.length===0){
        ok.key = false;
        alert("电脑名称不得为空");
    }
    let checkRe = /^[0-9]+$/;
    let re = new RegExp(checkRe);
    let pass =  re.test(param.price);
    if(!pass){
        ok.key = false;
        alert("金额必须为正整数!");
    }
}

function add(param){
    $.ajax({
        type: "post",
        contentType:"application/json",
        data:JSON.stringify(param),
        url: "http://127.0.0.1:9000/pc/save",
        success: function (data,status) {
           alert("保存成功！");
            $("#myModal").modal('hide');
            location.reload();
        },
        error: function (data,status) {
            alert("保存失败:"+data.responseJSON.message);
            $("#myModal").modal('hide');
        }
    });
    

    
}