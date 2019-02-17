//加载下拉框数据
function selectReady(){
    $.ajax({
        type: "get",
        url: "http://127.0.0.1:9000/pc/list?param=",
        success: function (data,status) {
            //商品去重
            let allBrand = [];
            data.forEach((item)=>{allBrand.push(JSON.stringify(item.brand))});
            let newAllBrand = Array.from(new Set(allBrand));
            //名称去重
            let allPcName = [];
            data.forEach((item)=>{allPcName.push(JSON.stringify(item.pcName))})
            let newAllPcName = Array.from(new Set(allPcName));
            showOption(newAllBrand,newAllPcName);
        },
        error: function (data,status) {
            alert("请求失败："+ data.responseJSON.message);
        }
    });
}

//展示下拉框数据
function showOption(newBrand,newPcName){
    $.each(newBrand,function (i, result) {
        let brand = result;
        let brandNum = result;
        switch (brand) {
            case "1": brand = "华为";break;
            case "2": brand = "华硕";break;
            case "3": brand = "戴尔";break;
            case "4": brand = "小米";break;
            default:
        }
        let brandOption = "<option value='"+brandNum+"'>"+brand+"</option>";
        $("#pcOrderBrand").append(brandOption);
    });
    $.each(newPcName,function(i, result){
        result= result.replace("\"","").replace("\"","");
        let pcNameOption = "<option value='"+result+"'>"+result+"</option>";
        $("#pcOrderName").append(pcNameOption);
    });
}

//实时刷新金额
function refreshTotalMoney(){
    let price = $("#pcOrderPrice").val();
    let num = $("#pcBuyNum").val();
    let total = price*num;
    $("#totalMoney").val(total);
}

//下单
function submit(){
    let pcOrderBrand = $("#pcOrderBrand option:selected").val();
    let pcOrderName = $("#pcOrderName  option:selected").val();
    let pcOrderPrice = $("#pcOrderPrice").val();
    let pcBuyNum = $("#pcBuyNum").val();
    let totalMoney = $("#pcPrice").val();

}



